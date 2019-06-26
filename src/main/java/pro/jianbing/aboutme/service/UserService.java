package pro.jianbing.aboutme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.jianbing.aboutme.entity.User;
import pro.jianbing.aboutme.mapper.CountdownMapper;
import pro.jianbing.aboutme.mapper.UserMapper;
import pro.jianbing.aboutme.pojo.po.Countdown;

import java.util.List;

@Service
public class UserService {

    private final
    UserMapper userMapper;

    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    public User getUserByUsername(String username) {
        User user = userMapper.getUserByUsername(username);
        return user;
    }
}
