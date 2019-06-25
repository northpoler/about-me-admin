package pro.jianbing.aboutme.mapper;

import org.springframework.stereotype.Repository;
import pro.jianbing.aboutme.pojo.po.Countdown;

import java.util.List;

@Repository
public interface CountdownMapper {

    List<Countdown> getTwoCountdown();
}
