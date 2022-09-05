package onestar.onestar.controller.cafe;

import onestar.onestar.dto.CafeDto;
import onestar.onestar.entity.Cafe;
import onestar.onestar.entity.CafeRecommend;
import onestar.onestar.service.CafeDtoService;
import onestar.onestar.service.CafeRecommendService;
import onestar.onestar.service.CafeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/OneStar/Cafe")
public class CafeController {
    private CafeService cafeService;
    private CafeDtoService cafeDtoService;

    private CafeRecommendService cafeRecommendService;

    private CafeDto tmpCafeDto = new CafeDto();

    @Autowired
    public CafeController(CafeService cafeService, CafeDtoService cafeDtoService, CafeRecommendService cafeRecommendService){
        this.cafeService = cafeService;
        this.cafeDtoService = cafeDtoService;
        this.cafeRecommendService = cafeRecommendService;
    }


    @GetMapping("/recommend")
    public String cafe(Model model){
        List<CafeDto> cafeDtoList = cafeDtoService.findAll();
        CafeDto cafeDto = new CafeDto();
        model.addAttribute("data", cafeDto);
        model.addAttribute("cafe", cafeDtoList);
        return "similarCafeFind";
    }


    @PostMapping("/recommend")
    public String post(@ModelAttribute("data") CafeDto cafeDto){
        tmpCafeDto = cafeDto;
        return "similarCafeList";
    }

    @GetMapping("/recommend/list")
    public String list(Model model){
        CafeRecommend cafeRecommend = cafeRecommendService.findbyName(tmpCafeDto.getName());
        List<String> list = new ArrayList<>();
        list.add(cafeRecommend.getFirst());
        list.add(cafeRecommend.getSecond());
        list.add(cafeRecommend.getThird());
        list.add(cafeRecommend.getFourth());
        list.add(cafeRecommend.getFifth());
        list.add(cafeRecommend.getSixth());
        list.add(cafeRecommend.getSeventh());
        list.add(cafeRecommend.getEighth());
        list.add(cafeRecommend.getNinth());
        list.add(cafeRecommend.getTenth());
        model.addAttribute("list", list);
        return "similarCafeList";
    }





}
