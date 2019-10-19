package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
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
        return fuelRepository.save(new Data(driverID, fuelType, price, liters, date));
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

    @RequestMapping("/result")
    public ModelAndView Result(
            @RequestParam(value = "driverID", required = false) String driverID,
            @RequestParam(value = "month", required = false) String month,
            @RequestParam(value = "submit", required = false) String submit,
            Model model) {
        ModelAndView result = new ModelAndView("result");
        model.addAttribute("list", fuelRepository.findAll());
        return result;
    }
}
