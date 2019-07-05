package pro.jianbing.aboutme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pro.jianbing.aboutme.entity.User;
import pro.jianbing.aboutme.service.CountdownService;
import pro.jianbing.aboutme.service.KeywordService;
import pro.jianbing.aboutme.service.LikeService;
import pro.jianbing.aboutme.service.UserService;
import pro.jianbing.aboutme.util.NetworkUtil;

import java.security.Principal;

/**
 * @author 李建兵
 */
@Controller
public class IndexController {

    private final LikeService likeService;
    @Autowired
    UserService userService;
    @Autowired
    KeywordService keywordService;

    @Autowired
    public IndexController(LikeService likeService, CountdownService countdownService) {
        this.likeService = likeService;
    }

    @GetMapping("")
    public String index(Principal principal, Model model){
        Authentication authentication = (Authentication) principal;
        User user = (User) authentication.getPrincipal();
        String addressByIp = NetworkUtil.getAddressByIp(user.getLastIP());
        model.addAttribute("user",user);
        model.addAttribute("address",addressByIp);
        int sumLikes = likeService.getSumLikes();
        /*model.addAttribute("sumLikes",sumLikes);
        Integer sumLikesToday = likeService.getSumLikesToday();
        model.addAttribute("sumLikesToday",sumLikesToday);
        Integer sumSearchToday = keywordService.getSumSearchToday();
        model.addAttribute("sumSearchToday",sumSearchToday);
        Long sumSearch = keywordService.getSumSearch();
        model.addAttribute("sumSearch",sumSearch);*/
        return "index";
    }
}
