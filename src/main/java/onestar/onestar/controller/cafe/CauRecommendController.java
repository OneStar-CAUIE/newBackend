package onestar.onestar.controller.cafe;

import onestar.onestar.entity.CauRecommend;
import onestar.onestar.service.CauRecommendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/OneStar/Cafe/Recommend")
public class CauRecommendController {
    private CauRecommendService cauRecommendService;

    @Autowired
    public CauRecommendController(CauRecommendService cauRecommendService){
        this.cauRecommendService = cauRecommendService;
    }

    @GetMapping("")
    public String recommendList(Model model){
        List<CauRecommend> list = cauRecommendService.findAll();
        model.addAttribute("list", list);
        return "cauRecommend";
    }

    @ResponseBody
    @GetMapping("/list")
    public List<CauRecommend> list(){
        return cauRecommendService.findAll();
    }

}
