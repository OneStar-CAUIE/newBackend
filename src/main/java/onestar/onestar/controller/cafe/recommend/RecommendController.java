package onestar.onestar.controller.cafe.recommend;

import onestar.onestar.entity.Recommend;
import onestar.onestar.service.RecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/OneStar/Cafe/Recommend")
public class RecommendController {
    private RecommendService recommendService;

    @Autowired
    public RecommendController(RecommendService recommendService){
        this.recommendService = recommendService;
    }

    @GetMapping("")
    public String recommendList(Model model){
        List<Recommend> list = recommendService.findAll();
        model.addAttribute("list", list);
        return "cafeRecommend";
    }

}
