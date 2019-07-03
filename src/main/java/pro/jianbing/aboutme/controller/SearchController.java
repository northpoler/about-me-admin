package pro.jianbing.aboutme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pro.jianbing.aboutme.service.LikeService;

/**
 * @author 李建兵
 */
@Controller
public class SearchController {

    private final
    LikeService likeService;

    @Autowired
    public SearchController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("search")
    public String search(Model model){
        return "search";
    }
}
