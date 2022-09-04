package onestar.onestar.controller;

import onestar.onestar.entity.StudyCafe;
import onestar.onestar.repository.StudyCafeRepository;
import onestar.onestar.service.StudyCafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/OneStar")
public class HomeController {

    private StudyCafeService studyCafeService;

    @Autowired
    public HomeController(StudyCafeService studyCafeService){
        this.studyCafeService = studyCafeService;
    }


    @GetMapping("/Home")
    public String home(){
        // 데이터베이스가 비어있을 때만 삽입 진행
        if(studyCafeService.countStudyCafe() == 0){
            studyCafeService.insert();
        }
        return "index";
    }

    @GetMapping("/Cafe")
    public String cafe(){
        return "cafe";
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
