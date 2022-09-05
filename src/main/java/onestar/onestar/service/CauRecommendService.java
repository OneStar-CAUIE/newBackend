package onestar.onestar.service;

import onestar.onestar.entity.CauRecommend;
import onestar.onestar.repository.CauRecommendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CauRecommendService {
    private final CauRecommendRepository cauRecommendRepository;

    @Autowired
    public CauRecommendService(CauRecommendRepository cauRecommendRepository){
        this.cauRecommendRepository = cauRecommendRepository;
    }

    public List<CauRecommend> findAll(){
        return cauRecommendRepository.findAll();
    }

    public long countRecommend(){
        return cauRecommendRepository.count();
    }

    public void insert() {
        CSVReader csvReader = new CSVReader("C:\\Users\\82107\\Desktop\\Database\\recommend_cafe_for_study.csv");

        List<List<String>> recommendData = csvReader.readCSV();

        for (int i = 1; i < recommendData.size(); i++) {
            List<String> tmp = recommendData.get(i);
            CauRecommend cauRecommend = new CauRecommend();
            cauRecommend.setName(tmp.get(1));
            cauRecommend.setRate(tmp.get(2));
            cauRecommend.setAddress(tmp.get(3));
            cauRecommend.setDate(tmp.get(4).
                    replace("[", "").replace("]", "").replace("'", ""));
            cauRecommend.setTime(tmp.get(5).
                    replace("[", "").replace("]", ""));
            cauRecommendRepository.save(cauRecommend);

        }
    }
}
