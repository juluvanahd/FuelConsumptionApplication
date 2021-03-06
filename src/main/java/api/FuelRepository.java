package api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelRepository extends JpaRepository<Data, Integer> {

    @Query(value = "SELECT * FROM Data WHERE driverID = ?1", nativeQuery = true)
    List<Data> findByDriverID(int driverID);

    @Query(value = "SELECT * FROM Data WHERE driverID = ?1 AND fuelType = ?2", nativeQuery = true)
    List<Data> findByDriverIDAndFuelType(int driverID, String fuelType);

    @Query(value = "SELECT * FROM Data WHERE fuelType = ?1", nativeQuery = true)
    List<Data> findByFuelType(String fuelType);
}
