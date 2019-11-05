package api;

import java.util.List;

public interface FuelService {

    public List<String> addDriver(Data data);
    public List<Data> specifiedMonth(String driverID, String month, FuelRepository fuelRepository);
    public List<Total> money(String driverID, FuelRepository fuelRepository);
    public List<Fuel> fuel(String driverID, String fuelType, FuelRepository fuelRepository);
}
