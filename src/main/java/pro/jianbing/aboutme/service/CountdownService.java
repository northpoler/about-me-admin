package pro.jianbing.aboutme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.jianbing.aboutme.entity.Like;
import pro.jianbing.aboutme.mapper.CountdownMapper;
import pro.jianbing.aboutme.mapper.LikeMapper;
import pro.jianbing.aboutme.pojo.po.Countdown;
import pro.jianbing.aboutme.util.NetworkUtil;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class CountdownService {

    private final
    CountdownMapper countdownMapper;

    @Autowired
    public CountdownService(CountdownMapper countdownMapper) {
        this.countdownMapper = countdownMapper;
    }

    public List<Countdown> getTwoCountdown() {
        List<Countdown> twoCountdown = countdownMapper.getTwoCountdown();
        return twoCountdown;
    }
}
