package pro.jianbing.aboutme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.jianbing.aboutme.entity.User;
import pro.jianbing.aboutme.mapper.CountdownMapper;
import pro.jianbing.aboutme.mapper.UserMapper;
import pro.jianbing.aboutme.pojo.po.Countdown;
import pro.jianbing.aboutme.repository.UserRepositoty;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author DefaultAccount
 */
@Service
public class UserService {

    final
    UserRepositoty userRepositoty;

    @Autowired
    public UserService(UserRepositoty userRepositoty) {
        this.userRepositoty = userRepositoty;
    }

    public Integer updateLoginInfo(String lastIP, LocalDateTime lastTime , String id){
        Integer result = userRepositoty.updateLoginInfo(lastIP, lastTime, id);
        return result;
    }

    public User getUserById(String id){
        return userRepositoty.getOne(id);
    }

}
