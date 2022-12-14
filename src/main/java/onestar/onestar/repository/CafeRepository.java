package onestar.onestar.repository;

import onestar.onestar.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Integer> {
    Cafe findByName(String name);
}
