package pro.jianbing.aboutme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.jianbing.aboutme.service.LikeService;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李建兵
 */
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

    @GetMapping("count/all")
    public Map<String,Object> getCountLikes(){
        int sumLikes = likeService.getSumLikes();
        Map<String, Object> result = getResult(sumLikes);
        return result;
    }

    @GetMapping("count/today")
    public Map<String,Object> getCountLikesToday(){
        int sumLikesToday = likeService.getSumLikesToday();
        Map<String, Object> result = getResult(sumLikesToday);
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
