package pro.jianbing.aboutme.mapper;

import org.springframework.stereotype.Repository;
import pro.jianbing.aboutme.entity.Like;

@Repository
public interface LikeMapper {

    /**
     * 获取点赞总数
     * @return
     */
    int getSumLikes();


    /**
     * 插入点赞信息
     * @param like
     */
    void insertLike(Like like);
}
