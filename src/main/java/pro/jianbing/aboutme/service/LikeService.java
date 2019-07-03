package pro.jianbing.aboutme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.jianbing.aboutme.entity.Like;
import pro.jianbing.aboutme.mapper.LikeMapper;
import pro.jianbing.aboutme.repository.LikeRepositoty;
import pro.jianbing.aboutme.util.NetworkUtil;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author 李建兵
 */
@Service
public class LikeService{

    private final
    LikeMapper likeMapper;
    private final
    LikeRepositoty likeRepositoty;

    @Autowired
    public LikeService(LikeMapper likeMapper,LikeRepositoty likeRepositoty) {
        this.likeMapper = likeMapper;
        this.likeRepositoty = likeRepositoty;
    }

    public int getSumLikes() {
        int sumLikes = likeMapper.getSumLikes();
        return sumLikes;
    }

    public void insertLike(HttpServletRequest request) {

        Like like = new Like();
        like.setId(UUID.randomUUID().toString().replaceAll("-",""));
        like.setIp(NetworkUtil.getIpAddress(request));
        like.setLikeTime(LocalDateTime.now());
        likeMapper.insertLike(like);
    }
}
