package onestar.onestar.controller.cafe;

import onestar.onestar.dto.CafeHashDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.Map;


@Controller
@RequestMapping("/OneStar/Cafe/hashtag")
public class HashController {

    private Map<String, String > test() {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("coffee", "커피가 맛있어요");
        map.put("beverage", "음료가 맛있어요");
        map.put("interior", "인테리어가멋져요");
        map.put("talk", "대화하기좋아요");
        map.put("dessert", "디저트가맛있어요");
        map.put("view", "뷰가좋아요");
        map.put("picture", "사진이잘나와요");
        map.put("kind", "친절해요");
        map.put("concentration", "집중하기좋아요");
        map.put("food", "음식이맛있어요");
        map.put("wide", "매장이넓어요");
        map.put("clean", "매장이청결해요");
        map.put("parking", "주차하기편해요");
        map.put("bread", "빵이맛있어요");
        map.put("special", "특별한메뉴가있어요");
        map.put("cost", "가성비가좋아요");
        map.put("fresh", "재료가신선해요");
        map.put("chair", "좌석이편해요");
        map.put("tea", "차가맛있어요");
        return map;
    }

    @GetMapping("/hash")
    public String showForm(Model model) {
        model.addAttribute("hashes", test());
        return "hash";
    }

    @PostMapping("/hash")
    public String form(@ModelAttribute("hashes") CafeHashDto cafeHashDto){
        System.out.println(cafeHashDto.getName());
        return "hash";
    }

}
