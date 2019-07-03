package pro.jianbing.aboutme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pro.jianbing.aboutme.entity.Countdown;
import pro.jianbing.aboutme.mapper.CountdownMapper;

import java.util.List;

/**
 * @author 李建兵
 */
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
