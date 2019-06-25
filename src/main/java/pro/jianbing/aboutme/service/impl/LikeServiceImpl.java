/*package pro.jianbing.aboutme.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pro.jianbing.aboutme.entity.Like;
import pro.jianbing.aboutme.mapper.LikeMapper;
import pro.jianbing.aboutme.service.LikeService;
import pro.jianbing.aboutme.util.NetworkUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    LikeMapper likeMapper;

    @Override
    public int getSumLikes() {
        int sumLikes = likeMapper.getSumLikes();
        return sumLikes;
    }

    @Override
    public int insertLike(HttpServletRequest request) {

        Like like = new Like();
        like.setId(UUID.randomUUID().toString().replaceAll("-",""));
        like.setIp(NetworkUtil.getIpAddress(request));
        like.setLikeTime(new Date());
        int result = likeMapper.insertLike(like);

        return result;
    }
}*/
