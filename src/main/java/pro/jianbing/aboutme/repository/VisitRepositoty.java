package pro.jianbing.aboutme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pro.jianbing.aboutme.entity.Visit;

import java.util.Map;


/**
 * @author 李建兵
 */
@Repository("visitRepository")
public interface VisitRepositoty extends JpaRepository<Visit,Long> {
    @Query("select count(visit_time) from Visit where visit_time between (current_date-1) and current_date")
    Integer countVisitDaily();
}
