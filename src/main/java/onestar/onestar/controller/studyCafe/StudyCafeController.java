package onestar.onestar.controller.studyCafe;

import onestar.onestar.entity.StudyCafe;
import onestar.onestar.service.StudyCafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/OneStar/StudyCafe")
public class StudyCafeController {
    private StudyCafeService studyCafeService;

    @Autowired
    public StudyCafeController(StudyCafeService studyCafeService){
        this.studyCafeService = studyCafeService;
    }

    @GetMapping("")
    public String studyCafeHome(){
        return "studyCafe";
    }
}
