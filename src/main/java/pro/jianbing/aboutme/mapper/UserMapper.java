package pro.jianbing.aboutme.mapper;

import org.springframework.stereotype.Repository;
import pro.jianbing.aboutme.entity.Like;
import pro.jianbing.aboutme.entity.User;

@Repository
public interface UserMapper {

    /**
     * 通过用户名获取用户信息
     * @param username 用户名
     * @return
     */
    User getUserByUsername(String username);

    /**
     * 更新用户信息（目前仅用于更新登陆时间和IP地址）
     * @param user
     */
    void updateUserInfo(User user);
}
