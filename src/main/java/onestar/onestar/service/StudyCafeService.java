package onestar.onestar.service;

import onestar.onestar.entity.StudyCafe;
import onestar.onestar.repository.StudyCafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudyCafeService {

    private final StudyCafeRepository studyCafeRepo;

    @Autowired
    public StudyCafeService(StudyCafeRepository studyCafeRepo){
        this.studyCafeRepo =studyCafeRepo;
    }

    public List<StudyCafe> findAll(){
        return studyCafeRepo.findAll();
    }

    public long countStudyCafe(){
        return studyCafeRepo.count();
    }

    public void insert(){
        CSVReader csvReader = new CSVReader("C:\\Users\\82107\\Desktop\\Database\\studycafe_cau_for_database.csv");

        List<List<String>> studyCafeData = csvReader.readCSV();

        /*
        for(List<String> data :studyCafeData){
            System.out.println(data.get(1));
            System.out.println(data.get(2));
            System.out.println(data.get(3));
        }

        */


        for(int i=0; i<studyCafeData.size(); i++){
            List<String> tmp = studyCafeData.get(i);
            System.out.println(tmp);
            System.out.println(tmp.get(1) +"," + tmp.get(2) + "," + tmp.get(3) + "," + tmp.get(4));
            StudyCafe studyCafe = new StudyCafe();
            studyCafe.setName(tmp.get(1));
            studyCafe.setAddress(tmp.get(2));
            studyCafe.setDate(tmp.get(3).
                    replace("[", "").replace("]","").replace("'", ""));
            studyCafe.setTime(tmp.get(4).
                   replace("[", "").replace("]",""));
            studyCafeRepo.save(studyCafe);

        }



    }


}
