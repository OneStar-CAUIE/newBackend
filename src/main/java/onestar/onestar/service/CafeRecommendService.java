package onestar.onestar.service;

import onestar.onestar.entity.CafeRecommend;
import onestar.onestar.repository.CafeRecommendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CafeRecommendService {
    private final CafeRecommendRepository cafeRecommendRepository;

    @Autowired
    public CafeRecommendService(CafeRecommendRepository cafeRecommendRepository){
        this.cafeRecommendRepository = cafeRecommendRepository;
    }

    public List<CafeRecommend> findAll(){
        return cafeRecommendRepository.findAll();
    }

    public long countCafeRecommend(){
        return cafeRecommendRepository.count();
    }

    public CafeRecommend findbyName(String name){
        return cafeRecommendRepository.findByName(name);
    }

    public void insert() {
        CSVReader csvReader = new CSVReader("C:\\Users\\82107\\Desktop\\Database\\cafe_recommended_10.csv");

        List<List<String>> recommendData = csvReader.readCSV();

        for (int i = 1; i < recommendData.size(); i++) {
            List<String> tmp = recommendData.get(i);
            CafeRecommend recommend = new CafeRecommend();
            recommend.setName(tmp.get(0));
            recommend.setFirst(tmp.get(1));
            recommend.setSecond(tmp.get(2));
            recommend.setThird(tmp.get(3));
            recommend.setFourth(tmp.get(4));
            recommend.setFifth(tmp.get(5));
            recommend.setSixth(tmp.get(6));
            recommend.setSeventh(tmp.get(7));
            recommend.setEighth(tmp.get(8));
            recommend.setNinth(tmp.get(9));
            recommend.setTenth(tmp.get(10));
            cafeRecommendRepository.save(recommend);

        }
    }

}
