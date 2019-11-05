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

        BigDecimal totalPrice = data.getPrice().multiply(data.getLiters());

        list.add(Integer.toString(data.getDriverID()));
        list.add(data.getFuelType());
        list.add(data.getPrice().toString());
        list.add(data.getLiters().toString());
        list.add(data.getDate());
        list.add(totalPrice.toString());

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

        BigDecimal totalMoneySpent;
        for (int j = 1; j <= 12; j++)
        {
            totalMoneySpent = BigDecimal.valueOf(0.0);
            for (int i = 0; i < data.size(); i++)
            {
                String[] str = data.get(i).getDate().split("-");
                int dateMonth = Integer.parseInt(str[1]);
                if(dateMonth == j)
                {
                    totalMoneySpent = totalMoneySpent.add(data.get(i).getTotalPrice());
                }
            }

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

        BigDecimal totalMoneySpent, averagePrice, liters;
        int counter;
        for (int j = 1; j <= 12; j++)
        {
            totalMoneySpent = BigDecimal.valueOf(0.0);
            averagePrice = BigDecimal.valueOf(0.0);
            liters = BigDecimal.valueOf(0.0);
            counter = 0;

            for (int i = 0; i < data.size(); i++)
            {
                String[] str = data.get(i).getDate().split("-");
                int dateMonth = Integer.parseInt(str[1]);
                if(dateMonth == j)
                {
                    counter = counter + 1;
                    totalMoneySpent = totalMoneySpent.add(data.get(i).getTotalPrice());
                    liters = liters.add(data.get(i).getLiters());
                }
            }
            if(counter > 0) {
                averagePrice = totalMoneySpent.divide(BigDecimal.valueOf(counter));
            }

            fuel.add(new Fuel(Month.of(j).getDisplayName(TextStyle.FULL_STANDALONE, Locale.US), fuelType, liters, averagePrice, totalMoneySpent));
        }

        return fuel;
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
