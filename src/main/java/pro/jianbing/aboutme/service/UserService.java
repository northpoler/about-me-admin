package pro.jianbing.aboutme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.jianbing.aboutme.entity.User;
import pro.jianbing.aboutme.repository.UserRepositoty;

/**
 * @author 李建兵
 */
@Service
public class UserService {

    private final
    UserRepositoty userRepositoty;

    @Autowired
    public UserService(UserRepositoty userRepositoty) {
        this.userRepositoty = userRepositoty;
    }

    public User getUserById(String id){
        return userRepositoty.getOne(id);
    }

}
