package core.community.repository;

import core.community.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GymRepository extends JpaRepository<Gym, Long> {
    List<Gym> findByLocation(String location);
}
