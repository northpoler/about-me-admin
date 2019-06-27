package pro.jianbing.aboutme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pro.jianbing.aboutme.service.CountdownService;
import pro.jianbing.aboutme.service.LikeService;

/**
 * @author DefaultAccount
 */
@Controller
public class DefaultController {

    @GetMapping("/countdown")
    public String countdown(){
        return "countdown";
    }

    @GetMapping("/info")
    public String info(){
        return "info";
    }
}
