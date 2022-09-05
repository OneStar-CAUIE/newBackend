package onestar.onestar.controller;

import onestar.onestar.entity.StudyCafe;
import onestar.onestar.service.CafeRecommendService;
import onestar.onestar.service.CafeService;
import onestar.onestar.service.CauRecommendService;
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
    private CauRecommendService cauRecommendService;
    private CafeRecommendService cafeRecommendService;

    @Autowired
    public HomeController(
            StudyCafeService studyCafeService, CafeService cafeService, CauRecommendService cauRecommendService,
            CafeRecommendService cafeRecommendService){
        this.studyCafeService = studyCafeService;
        this.cafeService = cafeService;
        this.cauRecommendService = cauRecommendService;
        this.cafeRecommendService = cafeRecommendService;
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
        if(cauRecommendService.countRecommend() == 0){
            cauRecommendService.insert();
        }
        if(cafeRecommendService.countCafeRecommend()==0){
            cafeRecommendService.insert();
        }
        return "home";
    }


    @ResponseBody
    @GetMapping("/studyCafe/list")
    public List<StudyCafe> findAll(){
        return studyCafeService.findAll();
    }



}
