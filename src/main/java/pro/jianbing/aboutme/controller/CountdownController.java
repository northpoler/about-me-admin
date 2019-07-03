package pro.jianbing.aboutme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.jianbing.aboutme.entity.Countdown;
import pro.jianbing.aboutme.service.CountdownService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李建兵
 */
@RequestMapping("countdown")
@RestController
public class CountdownController {

    private final CountdownService countdownService;

    @Autowired
    public CountdownController(CountdownService countdownService) {
        this.countdownService = countdownService;
    }

    @GetMapping("table")
    public Map<String,Object> getTwoCountdown(){
        List<Countdown> twoCountdown = countdownService.getTwoCountdown();
        Map<String,Object> data = new HashMap<>(4);
        data.put("code",0);
        data.put("msg","success");
        data.put("data",twoCountdown);
        data.put("count",data.size());
        return data;
    }
}
