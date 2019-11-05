package api;

import java.util.List;

public interface FuelService {

    List<String> addDriver(Data data);
    List<Data> specifiedMonth(String driverID, String month, FuelRepository fuelRepository);
    List<Total> money(String driverID, FuelRepository fuelRepository);
    List<Fuel> fuel(String driverID, String fuelType, FuelRepository fuelRepository);
}
