package onestar.onestar.controller.studyCafe;

<<<<<<< HEAD
import onestar.onestar.dto.StudyCafeDto;
=======
>>>>>>> c1a3f52849a2ac7ff248e0d4ab818352c8faf2dc
import onestar.onestar.entity.StudyCafe;
import onestar.onestar.service.StudyCafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
<<<<<<< HEAD
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

=======
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

>>>>>>> c1a3f52849a2ac7ff248e0d4ab818352c8faf2dc
@Controller
@RequestMapping("/OneStar/StudyCafe")
public class StudyCafeController {
    private StudyCafeService studyCafeService;

    @Autowired
    public StudyCafeController(StudyCafeService studyCafeService){
        this.studyCafeService = studyCafeService;
    }

    @GetMapping("")
<<<<<<< HEAD
    public String studyCafeHome(Model model){
        List<StudyCafe> list = studyCafeService.findAll();
        model.addAttribute("list", list);
        return "studyCafe";
    }



    @GetMapping("/map")
    public String map(){
        return "map";
    }

=======
    public String studyCafeHome(){
        return "studyCafe";
    }
>>>>>>> c1a3f52849a2ac7ff248e0d4ab818352c8faf2dc
}
