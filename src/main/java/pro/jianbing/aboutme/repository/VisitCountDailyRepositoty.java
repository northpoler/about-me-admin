package pro.jianbing.aboutme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.jianbing.aboutme.entity.Visit;
import pro.jianbing.aboutme.entity.VisitCountDaily;

import java.util.List;


/**
 * @author 李建兵
 */
@Repository("visitCountDailyRepository")
public interface VisitCountDailyRepositoty extends JpaRepository<VisitCountDaily,Long> {
    List<VisitCountDaily> findByDay(String yesterday);
}
