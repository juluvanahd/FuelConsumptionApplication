package api;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class FuelServiceImpl implements FuelService {

    private List<Data> data = new ArrayList<>();

    @Override
    public List<String> addDriver(Data data) {

        List<String> list = new ArrayList<>();

        double totalPrice = data.getPrice() * data.getLiters();
        totalPrice = round(totalPrice, 2);

        list.add(Integer.toString(data.getDriverID()));
        list.add(data.getFuelType());
        list.add(Double.toString(data.getPrice()));
        list.add(Double.toString(data.getLiters()));
        list.add(data.getDate());
        list.add(Double.toString(totalPrice));

        return list;
    }

    @Override
    public List<Data> specifiedMonth(String driverID, String month, FuelRepository fuelRepository) {

        List<Data> endResult = new ArrayList<>();

        request(driverID,
                fuelRepository.findByDriverID(Integer.parseInt(driverID)),
                fuelRepository.findAll());

        for (int i = 0; i < data.size(); i++)
        {
            String[] str = data.get(i).getDate().split("-");
            int dateMonth = Integer.parseInt(str[1]);
            if(dateMonth == Integer.parseInt(month))
            {
                endResult.add(data.get(i));
            }
        }

        return endResult;
    }

    @Override
    public List<Total> money(String driverID, FuelRepository fuelRepository) {

        List<Total> total = new ArrayList<>();

        request(driverID,
                fuelRepository.findByDriverID(Integer.parseInt(driverID)),
                fuelRepository.findAll());

        double totalMoneySpent;
        for (int j = 1; j <= 12; j++)
        {
            totalMoneySpent = 0;
            for (int i = 0; i < data.size(); i++)
            {
                String[] str = data.get(i).getDate().split("-");
                int dateMonth = Integer.parseInt(str[1]);
                if(dateMonth == j)
                {
                    totalMoneySpent = totalMoneySpent + data.get(i).getTotalPrice();
                }
            }
            totalMoneySpent = round(totalMoneySpent, 2);
            total.add(new Total(Month.of(j).getDisplayName(TextStyle.FULL_STANDALONE, Locale.US), totalMoneySpent));
        }

        return total;
    }

    @Override
    public List<Fuel> fuel(String driverID, String fuelType, FuelRepository fuelRepository) {

        List<Fuel> fuel = new ArrayList<>();

        request(driverID,
                fuelRepository.findByDriverIDAndFuelType(Integer.parseInt(driverID), fuelType),
                fuelRepository.findByFuelType(fuelType));

        double totalMoneySpent, averagePrice, liters;
        for (int j = 1; j <= 12; j++)
        {
            totalMoneySpent = 0;
            averagePrice = 0.0;
            liters = 0;
            for (int i = 0; i < data.size(); i++)
            {
                String[] str = data.get(i).getDate().split("-");
                int dateMonth = Integer.parseInt(str[1]);
                if(dateMonth == j)
                {
                    totalMoneySpent = totalMoneySpent + data.get(i).getTotalPrice();
                    liters = liters + data.get(i).getLiters();
                }
            }
            if(data.size() > 0) {
                averagePrice = totalMoneySpent / data.size();
                averagePrice = round(averagePrice, 2);
            }
            totalMoneySpent = round(totalMoneySpent, 2);
            liters = round(liters, 2);
            fuel.add(new Fuel(Month.of(j).getDisplayName(TextStyle.FULL_STANDALONE, Locale.US), fuelType, liters, averagePrice, totalMoneySpent));
        }
        return fuel;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private void request(String driverID, List<Data> fuelRepositoryTrue, List<Data> fuelRepositoryFalse)
    {
        if(Integer.parseInt(driverID) != -1)
        {
            data = fuelRepositoryTrue;
        }
        else
        {
            data = fuelRepositoryFalse;
        }
    }
}
