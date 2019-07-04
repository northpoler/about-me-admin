package pro.jianbing.aboutme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.jianbing.aboutme.entity.Countdown;
import pro.jianbing.aboutme.pojo.CountdownDto;
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

    @PostMapping("update")
    public Map<String,Object> updateInfo(CountdownDto countdownDto){
        Integer result = countdownService.saveCountdownInfo(countdownDto);
        Map<String,Object> data = new HashMap<>(4);
        if (result>0){
            data.put("code",0);
        } else {
            data.put("code",1);
        }
        return data;

    }
}
