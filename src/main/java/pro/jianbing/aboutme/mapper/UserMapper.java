package pro.jianbing.aboutme.mapper;

import org.springframework.stereotype.Repository;
import pro.jianbing.aboutme.entity.Like;
import pro.jianbing.aboutme.entity.User;

@Repository
public interface UserMapper {

    User getUserByUsername(String username);

    void updateUserInfo(User user);
}
