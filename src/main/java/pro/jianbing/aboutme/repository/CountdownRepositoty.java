package pro.jianbing.aboutme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pro.jianbing.aboutme.entity.Countdown;
import pro.jianbing.aboutme.entity.Keyword;


/**
 * @author 李建兵
 */
@Repository("countdownRepository")
public interface CountdownRepositoty extends JpaRepository<Countdown,Long> {
}
