package onestar.onestar.service;

import onestar.onestar.entity.Recommend;
import onestar.onestar.entity.StudyCafe;
import onestar.onestar.repository.RecommendRepository;
import onestar.onestar.repository.StudyCafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RecommendService {
    private final RecommendRepository recommendRepository;

    @Autowired
    public RecommendService(RecommendRepository recommendRepository){
        this.recommendRepository = recommendRepository;
    }

    public List<Recommend> findAll(){
        return recommendRepository.findAll();
    }

    public long countRecommend(){
        return recommendRepository.count();
    }

    public void insert() {
        CSVReader csvReader = new CSVReader("C:\\Users\\82107\\Desktop\\Database\\cafe_cau_for_database.csv");

        List<List<String>> recommendData = csvReader.readCSV();

        for (int i = 1; i < recommendData.size(); i++) {
            List<String> tmp = recommendData.get(i);
            Recommend recommend = new Recommend();
            recommend.setName(tmp.get(1));
            recommend.setRate(tmp.get(2));
            recommend.setAddress(tmp.get(3));
            recommend.setDate(tmp.get(4).
                    replace("[", "").replace("]", "").replace("'", ""));
            recommend.setTime(tmp.get(5).
                    replace("[", "").replace("]", ""));
            recommendRepository.save(recommend);

        }
    }
}
