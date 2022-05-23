package core.community.repository;

import core.community.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GymRepository extends JpaRepository<Gym, Long> {
    List<Gym> findByLocation(String location);

    List<Gym> findByNameContainingIgnoreCase(String name);

    @Query("Select gym from Gym gym where lower(gym.name) like lower(concat('%', :name, '%'))")
    List<Gym> customSearch(String name);

}
