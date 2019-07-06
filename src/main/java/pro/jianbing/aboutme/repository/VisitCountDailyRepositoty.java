package pro.jianbing.aboutme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pro.jianbing.aboutme.entity.Visit;
import pro.jianbing.aboutme.entity.VisitCountDaily;


/**
 * @author 李建兵
 */
@Repository("visitCountDailyRepository")
public interface VisitCountDailyRepositoty extends JpaRepository<VisitCountDaily,Long> {
}
