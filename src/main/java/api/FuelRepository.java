package api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuelRepository extends JpaRepository<Data, Integer> {

    //List<Data> findByTitleContainingOrContentContaining(String text, String textAgain);

}
