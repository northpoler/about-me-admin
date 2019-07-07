package pro.jianbing.aboutme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.jianbing.aboutme.entity.Countdown;
import pro.jianbing.aboutme.mapper.CountdownMapper;
import pro.jianbing.aboutme.pojo.CountdownDto;
import pro.jianbing.aboutme.repository.CountdownRepositoty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author 李建兵
 */
@Service
public class CountdownService {

    private final
    CountdownMapper countdownMapper;
    private final CountdownRepositoty countdownRepositoty;

    @Autowired
    public CountdownService(CountdownMapper countdownMapper, CountdownRepositoty countdownRepositoty) {
        this.countdownMapper = countdownMapper;
        this.countdownRepositoty = countdownRepositoty;
    }

    public List<Countdown> getTwoCountdown() {
        List<Countdown> twoCountdown = countdownMapper.getTwoCountdown();
        return twoCountdown;
    }

    @Transactional
    public Integer saveCountdownInfo(CountdownDto countdownDto){
        Countdown countdown = countdownRepositoty.getOne(countdownDto.getId());
        if ("title".equals(countdownDto.getField())){
            countdown.setTitle(countdownDto.getValue());
        } else if ("endTime".equals(countdownDto.getField())){
            LocalDateTime dateTime = LocalDateTime
                    .parse(countdownDto.getValue(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            countdown.setEndTime(dateTime);
        } else {
            countdown.setDays(Integer.parseInt(countdownDto.getValue()));
        }
        Countdown save = countdownRepositoty.save(countdown);
        if (save!=null){
            return 1;
        }
        return 0;
    }
}
