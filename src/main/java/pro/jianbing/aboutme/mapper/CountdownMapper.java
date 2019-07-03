package pro.jianbing.aboutme.mapper;

import org.springframework.stereotype.Repository;
import pro.jianbing.aboutme.entity.Countdown;

import java.util.List;

/**
 * @author 李建兵
 */
@Repository
public interface CountdownMapper {

    /**
     * 获取两个未来最接近的两个倒计时
     * @return
     */
    List<Countdown> getTwoCountdown();
}
