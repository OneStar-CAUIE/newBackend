package onestar.onestar.repository;

import onestar.onestar.entity.CauRecommend;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CauRecommendRepository extends JpaRepository<CauRecommend, Integer> {

    CauRecommend findByName(String name);
}
