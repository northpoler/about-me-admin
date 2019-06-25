package pro.jianbing.aboutme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.jianbing.aboutme.service.LikeService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/like")
public class LikeController {

    private final
    LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @GetMapping("insert")
    public Integer insertLike(HttpServletRequest request){
        likeService.insertLike(request);
        int sumLikes = likeService.getSumLikes();
        return sumLikes;
    }
}
