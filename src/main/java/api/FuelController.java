package api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FuelController {

    private FuelRepository fuelRepository;
    private FuelService fuelService;

    public FuelController(FuelRepository fuelRepository, FuelService fuelService) {
        this.fuelRepository = fuelRepository;
        this.fuelService = fuelService;
    }

    @PostMapping("/api")
    public @ResponseBody String create(@RequestBody Data data) {

        List<String> list = fuelService.addDriver(data);
        fuelRepository.save(new Data(Integer.parseInt(list.get(0)), list.get(1), Double.parseDouble(list.get(2)), Double.parseDouble(list.get(3)), list.get(4), Double.parseDouble(list.get(5))));

        return "Driver: " + "'" + list.get(0) + "' added successfully!";
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/resultSpecifiedMonth")
    public String resultSpecifiedMonth(
            @RequestParam(value = "driverID", required = false, defaultValue = "-1") String driverID,
            @RequestParam(value = "month") String month,
            Model model) {

        List<Data> endResult = fuelService.specifiedMonth(driverID, month, fuelRepository);
        model.addAttribute("list", endResult);
        return "resultSpecifiedMonth";
    }

    @RequestMapping("/resultMoney")
    public String resultMoney(
            @RequestParam(value = "driverID", required = false, defaultValue = "-1") String driverID,
            Model model) {

        List<Total> total = fuelService.money(driverID, fuelRepository);
        model.addAttribute("list", total);
        return "resultMoney";
    }

    @RequestMapping("/resultFuel")
    public String resultFuel(
            @RequestParam(value = "driverID", required = false, defaultValue = "-1") String driverID,
            @RequestParam(value = "fuelType") String fuelType,
            Model model) {

        List<Fuel> fuel = fuelService.fuel(driverID, fuelType, fuelRepository);
        model.addAttribute("list", fuel);
        return "resultFuel";
    }
}
