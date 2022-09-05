package onestar.onestar.service;

import onestar.onestar.dto.CafeDto;
import onestar.onestar.entity.Cafe;
import onestar.onestar.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CafeDtoService {
    private final CafeRepository cafeRepo;
    @Autowired
    public CafeDtoService(CafeRepository cafeRepo){
        this.cafeRepo = cafeRepo;
    }

    public List<CafeDto> findAll() {
        List<Cafe> cafeList = cafeRepo.findAll();
        List<CafeDto> cafeDtoList = new ArrayList<>();
        for(Cafe cafe : cafeList){
            CafeDto cafeDto = new CafeDto();
            cafeDto.setName(cafe.getName());
            cafeDtoList.add(cafeDto);
        }
        return cafeDtoList;
    }
}
