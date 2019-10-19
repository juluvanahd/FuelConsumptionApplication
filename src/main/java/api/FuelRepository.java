package api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelRepository extends JpaRepository<Data, Integer> {

    @Query(value = "SELECT * FROM Data WHERE driverID = ?1", nativeQuery = true)
    List<Data> findByDriverID(int driverID);
}
