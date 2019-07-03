package pro.jianbing.aboutme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pro.jianbing.aboutme.entity.User;

import java.time.LocalDateTime;
/**
 * @author 李建兵
 */
@Repository("userRepository")
public interface UserRepositoty extends JpaRepository<User,String> {
    /**
     * 用户每次登陆后，更新IP和时间
     * @param lastIP
     * @param lastTime
     * @param id
     * @return
     */
    @Transactional
    @Modifying
    @Query("update User set last_IP = ?1 ,lastTime = ?2 where id = ?3")
    Integer updateLoginInfo(String lastIP, LocalDateTime lastTime , String id);

    /**
     * 通过用户名获取用户--登录用
     * @param username
     * @return
     */
    User findByUsername(String username);
}
