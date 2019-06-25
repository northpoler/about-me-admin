package pro.jianbing.aboutme.mapper;

import org.springframework.stereotype.Repository;
import pro.jianbing.aboutme.entity.Like;

@Repository
public interface LikeMapper {

    int getSumLikes();

    void insertLike(Like like);
}
