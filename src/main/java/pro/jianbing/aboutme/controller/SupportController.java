package pro.jianbing.aboutme.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.jianbing.aboutme.entity.Picture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/support")
public class SupportController {

    @GetMapping("alipay")
    public Map<String, Object> getAlipay(){
        Picture alipay = new Picture("支付宝收款码","001","../static/image/AliPay.jpg","../static/image/AliPay.jpg");
        return constructSupport(alipay);
    }

    @GetMapping("weChat")
    public Map<String, Object> getWeChat(){
        Picture weChat = new Picture("微信收款码","001","../static/image/weChat.jpg","../static/image/weChat.jpg");
        return constructSupport(weChat);
    }

    private Map<String, Object> constructSupport(Picture picture){
        Map<String,Object> support = new HashMap<>(4);
        support.put("title","感谢赞助");
        support.put("id","666");
        support.put("start",0);
        List<Picture> supports = new ArrayList<>(1);
        supports.add(picture);
        support.put("data",supports);
        return support;
    }
}
