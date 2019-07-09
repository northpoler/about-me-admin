package pro.jianbing.aboutme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pro.jianbing.aboutme.service.CountdownService;
import pro.jianbing.aboutme.service.LikeService;

/**
 * @author 李建兵
 */
@Controller
public class DefaultController {

    @GetMapping("/countdown")
    public String countdown(){
        return "countdown";
    }
}
