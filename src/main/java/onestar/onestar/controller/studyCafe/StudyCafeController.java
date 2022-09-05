package onestar.onestar.controller.studyCafe;


import onestar.onestar.dto.MapDto;
import onestar.onestar.entity.StudyCafe;
import onestar.onestar.service.MapDtoService;
import onestar.onestar.service.StudyCafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/OneStar/StudyCafe")
public class StudyCafeController {
    private StudyCafeService studyCafeService;

    @Autowired
    public StudyCafeController(StudyCafeService studyCafeService){
        this.studyCafeService = studyCafeService;
    }

    @GetMapping("")

    public String studyCafeHome(Model model){
        List<StudyCafe> list = studyCafeService.findAll();
        model.addAttribute("list", list);
        return "studyCafe";
    }



    @GetMapping("/map")
    public String map(){
        //MapDtoService mapDtoService = new MapDtoService();
        //List<MapDto> mapDtoList = mapDtoService.insert();
        //model.addAttribute("mapDto", mapDtoList);
        return "map";
    }


    public String studyCafeHome(){
        return "studyCafe";
    }

}
