package pro.jianbing.aboutme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pro.jianbing.aboutme.entity.Like;
import pro.jianbing.aboutme.entity.User;

import java.time.LocalDateTime;

/**
 * @author 李建兵
 */
@Repository("likeRepository")
public interface LikeRepositoty extends JpaRepository<Like,String> {

}
