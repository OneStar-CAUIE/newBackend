package onestar.onestar.repository;

import onestar.onestar.entity.CafeRecommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRecommendRepository extends JpaRepository<CafeRecommend, Integer> {

    CafeRecommend findByName(String name);
}
