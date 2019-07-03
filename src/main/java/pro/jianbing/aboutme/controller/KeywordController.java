package pro.jianbing.aboutme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.jianbing.aboutme.service.KeywordService;
import pro.jianbing.aboutme.service.LikeService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李建兵
 */
@RestController
@RequestMapping("/keyword")
public class KeywordController {

    private final
    KeywordService keywordService;

    @Autowired
    public KeywordController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

    @GetMapping("count/all")
    public Map<String,Object> getCountLikes(){
        Long sumSearch = keywordService.getSumSearch();
        Map<String, Object> result = getResult(sumSearch.intValue());
        return result;
    }

    @GetMapping("count/today")
    public Map<String,Object> getCountLikesToday(){
        Integer sumSearchToday = keywordService.getSumSearchToday();
        Map<String, Object> result = getResult(sumSearchToday);
        return result;
    }

    private Map<String,Object> getResult(Integer data){
        Map<String,Object> result = new HashMap<>(2);
        if (data>0){
            result.put("code",0);
            result.put("data",data);
        } else {
            result.put("code",1);
        }
        return result;
    }
}
