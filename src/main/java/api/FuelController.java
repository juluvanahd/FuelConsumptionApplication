package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FuelController {

    @Autowired
    FuelRepository fuelRepository;

    @GetMapping("/api")
    public List<Data> index(){
        return fuelRepository.findAll();
    }

    @GetMapping("/api/{id}")
    public Data show(@PathVariable String id){
        int driverID = Integer.parseInt(id);
        return fuelRepository.findOne(driverID);
    }

    @PostMapping("/api")
    public Data create(@RequestBody Data data){
        int driverID = data.getDriverID();
        String fuelType = data.getFuelType();
        double price = data.getPrice();
        double liters = data.getLiters();
        String date = data.getDate();
        double totalPrice = price * liters;
        return fuelRepository.save(new Data(driverID, fuelType, price, liters, date, totalPrice));
    }

    @DeleteMapping("api/{id}")
    public boolean delete(@PathVariable String id){
        int driverID = Integer.parseInt(id);
        fuelRepository.delete(driverID);
        return true;
    }

    @RequestMapping("/")
    public ModelAndView Index() {
        ModelAndView index = new ModelAndView("index");
        return index;
    }

    @RequestMapping("/resultFuel")
    public ModelAndView Result(
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

        ModelAndView result = new ModelAndView("result");
        model.addAttribute("list", endResult);

        return result;
    }
}
