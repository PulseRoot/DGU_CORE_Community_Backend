package core.community.repository;

import core.community.entity.GymReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymReviewRepository extends JpaRepository<GymReview, Long> {
}
