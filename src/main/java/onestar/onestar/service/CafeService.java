package onestar.onestar.service;

import onestar.onestar.entity.Cafe;
import onestar.onestar.entity.StudyCafe;
import onestar.onestar.repository.CafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CafeService {

    private final CafeRepository cafeRepo;

    @Autowired
    public CafeService(CafeRepository cafeRepo){
        this.cafeRepo = cafeRepo;
    }

    public List<Cafe> findAll(){
        return cafeRepo.findAll();
    }

    public long countCafe(){
        return cafeRepo.count();
    }

    public void insert(){
        CSVReader csvReader = new CSVReader("C:\\Users\\82107\\Desktop\\Database\\cafe_cau_for_database.csv");

        List<List<String>> cafeData = csvReader.readCSV();

        for(int i=1; i<cafeData.size(); i++){
            List<String> tmp = cafeData.get(i);
            Cafe cafe = new Cafe();
            cafe.setName(tmp.get(1));
            cafe.setRate(Double.parseDouble(tmp.get(2)));
            cafe.setAddress(tmp.get(3));
            if(tmp.get(4).equals("[]")) {
                cafe.setDate("정보없음");
            }
            else {
                cafe.setDate(tmp.get(4).
                        replace("[", "").replace("]","").replace("'", ""));
            }
            if(tmp.get(5).equals("[]")) {
                cafe.setTime("정보없음");
            }
            else {
                cafe.setTime(tmp.get(5).
                        replace("[", "").replace("]",""));
            }
            cafeRepo.save(cafe);

        }



    }
}
