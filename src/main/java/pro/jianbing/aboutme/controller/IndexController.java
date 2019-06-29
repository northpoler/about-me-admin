package pro.jianbing.aboutme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pro.jianbing.aboutme.entity.User;
import pro.jianbing.aboutme.service.CountdownService;
import pro.jianbing.aboutme.service.LikeService;
import pro.jianbing.aboutme.service.UserService;
import pro.jianbing.aboutme.util.NetworkUtil;

import java.security.Principal;

@Controller
public class IndexController {

    private final LikeService likeService;
    @Autowired
    UserService userService;

    @Autowired
    public IndexController(LikeService likeService, CountdownService countdownService) {
        this.likeService = likeService;
    }

    @GetMapping("")
    public String index(Principal principal, Model model){
        Authentication authentication = (Authentication) principal;
        User user = (User) authentication.getPrincipal();
        User userById = userService.getUserById(user.getId());
        String addressByIp = NetworkUtil.getAddressByIp(userById.getLastIP());
        model.addAttribute("user",userById);
        model.addAttribute("address",addressByIp);
        return "index";
    }
}
