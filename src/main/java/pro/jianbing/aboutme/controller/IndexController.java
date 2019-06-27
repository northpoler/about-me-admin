package pro.jianbing.aboutme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pro.jianbing.aboutme.service.CountdownService;
import pro.jianbing.aboutme.service.LikeService;

@Controller
public class IndexController {

    private final LikeService likeService;

    @Autowired
    public IndexController(LikeService likeService, CountdownService countdownService) {
        this.likeService = likeService;
    }

    @GetMapping("")
    public String index(Model model){
        int sumLikes = likeService.getSumLikes();
        model.addAttribute("likes",sumLikes);
        return "index";
    }
}
