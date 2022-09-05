package onestar.onestar.controller.cafe;

import onestar.onestar.entity.Cafe;
import onestar.onestar.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/OneStar/Cafe")
public class CafeController {
    private CafeService cafeService;

    @Autowired
    public CafeController(CafeService cafeService){
        this.cafeService = cafeService;
    }


    @GetMapping("/recommend")
    public String cafe(Model model){
        List<Cafe> cafeList = cafeService.findAll();
        model.addAttribute("cafe", cafeList);
        return "similarCafeFind";
    }





}
