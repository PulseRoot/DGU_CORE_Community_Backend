package core.community.repository;

import core.community.entity.GymBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymBoardRepository extends JpaRepository<GymBoard, Long> {
}
