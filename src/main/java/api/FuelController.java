package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
public class FuelController {

    @Autowired
    FuelRepository fuelRepository;

    @GetMapping("/api")
    public List<Data> index(){
        return fuelRepository.findAll();
    }

    @PostMapping("/api")
    public Data create(@RequestBody Data data){
        int driverID = data.getDriverID();
        String fuelType = data.getFuelType();
        double price = data.getPrice();
        double liters = data.getLiters();
        String date = data.getDate();
        double totalPrice = price * liters;
        totalPrice = Round(totalPrice, 2);
        return fuelRepository.save(new Data(driverID, fuelType, price, liters, date, totalPrice));
    }

    @RequestMapping("/")
    public ModelAndView Index() {
        ModelAndView index = new ModelAndView("index");
        return index;
    }

    @RequestMapping("/resultSpecifiedMonth")
    public ModelAndView ResultSpecifiedMonth(
            @RequestParam(value = "driverID", required = false, defaultValue = "-1") String driverID,
            @RequestParam(value = "month") String month,
            Model model) {

        List<Data> data = new ArrayList<>();
        List<Data> endResult = new ArrayList<>();

        if(Integer.parseInt(driverID) != -1)
        {
            data = fuelRepository.findByDriverID(Integer.parseInt(driverID));
        }
        else
        {
            data = fuelRepository.findAll();
        }

        for (int i = 0; i < data.size(); i++)
        {
            String str[] = data.get(i).getDate().split("-");
            int dateMonth = Integer.parseInt(str[1]);
            if(dateMonth == Integer.parseInt(month))
            {
                endResult.add(data.get(i));
            }
        }

        ModelAndView result = new ModelAndView("resultSpecifiedMonth");
        model.addAttribute("list", endResult);

        return result;
    }

    @RequestMapping("/resultMoney")
    public ModelAndView ResultMoney(
            @RequestParam(value = "driverID", required = false, defaultValue = "-1") String driverID,
            Model model) {


        List<Data> data = new ArrayList<>();
        List<Total> total = new ArrayList<>();

        if(Integer.parseInt(driverID) != -1)
        {
            data = fuelRepository.findByDriverID(Integer.parseInt(driverID));
        }
        else
        {
            data = fuelRepository.findAll();
        }

        double totalMoneySpent;
        for (int j = 1; j <= 12; j++)
        {
            totalMoneySpent = 0;
            for (int i = 0; i < data.size(); i++)
            {
                String str[] = data.get(i).getDate().split("-");
                int dateMonth = Integer.parseInt(str[1]);
                if(dateMonth == j)
                {
                    totalMoneySpent = totalMoneySpent + data.get(i).getTotalPrice();
                }
            }
            totalMoneySpent = Round(totalMoneySpent, 2);
            total.add(new Total(Month.of(j).getDisplayName(TextStyle.FULL_STANDALONE, Locale.US), totalMoneySpent));
        }

        ModelAndView result = new ModelAndView("resultMoney");
        model.addAttribute("list", total);

        return result;
    }

    @RequestMapping("/resultFuel")
    public ModelAndView ResultFuel(
            @RequestParam(value = "driverID", required = false, defaultValue = "-1") String driverID,
            @RequestParam(value = "fuelType") String fuelType,
            Model model) {

        List<Data> data = new ArrayList<>();
        List<Fuel> fuel = new ArrayList<>();

        if(Integer.parseInt(driverID) != -1)
        {
            data = fuelRepository.findByDriverIDAndFuelType(Integer.parseInt(driverID), fuelType);
        }
        else
        {
            data = fuelRepository.findByFuelType(fuelType);
        }

        double totalMoneySpent, averagePrice, liters;
        for (int j = 1; j <= 12; j++)
        {
            totalMoneySpent = 0;
            averagePrice = 0;
            liters = 0;
            for (int i = 0; i < data.size(); i++)
            {
                String str[] = data.get(i).getDate().split("-");
                int dateMonth = Integer.parseInt(str[1]);
                if(dateMonth == j)
                {
                    totalMoneySpent = totalMoneySpent + data.get(i).getTotalPrice();
                    liters = liters + data.get(i).getLiters();
                }
            }
            if(data.size() > 0) {
                averagePrice = totalMoneySpent / data.size();
                averagePrice = Round(averagePrice, 2);
            }
            else
            {
                averagePrice = 0.0;
            }
            totalMoneySpent = Round(totalMoneySpent, 2);
            liters = Round(liters, 2);
            fuel.add(new Fuel(Month.of(j).getDisplayName(TextStyle.FULL_STANDALONE, Locale.US), fuelType, liters, averagePrice, totalMoneySpent));
        }

        ModelAndView result = new ModelAndView("resultFuel");
        model.addAttribute("list", fuel);

        return result;
    }

    public static double Round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
