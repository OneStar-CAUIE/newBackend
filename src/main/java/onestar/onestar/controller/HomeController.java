package onestar.onestar.controller;

import onestar.onestar.entity.StudyCafe;
import onestar.onestar.service.CafeService;
import onestar.onestar.service.StudyCafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/OneStar")
public class HomeController {

    private StudyCafeService studyCafeService;
    private CafeService cafeService;

    @Autowired
    public HomeController(StudyCafeService studyCafeService, CafeService cafeService){
        this.studyCafeService = studyCafeService;
        this.cafeService = cafeService;
    }


    @GetMapping("/Home")
    public String home(){
        // 데이터베이스가 비어있을 때만 삽입 진행
        if(studyCafeService.countStudyCafe() == 0){
            studyCafeService.insert();
        }
        if(cafeService.countCafe() == 0){
            cafeService.insert();
        }
        return "home";
    }


    @ResponseBody
    @GetMapping("/studyCafe/list")
    public List<StudyCafe> findAll(){
        return studyCafeService.findAll();
    }

    @GetMapping("/studyCafe/map")
    public String map(){
        return "map";
    }


}
