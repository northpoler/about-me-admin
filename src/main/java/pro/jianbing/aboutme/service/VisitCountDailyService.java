package pro.jianbing.aboutme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.jianbing.aboutme.entity.Visit;
import pro.jianbing.aboutme.entity.VisitCountDaily;
import pro.jianbing.aboutme.repository.VisitCountDailyRepositoty;
import pro.jianbing.aboutme.repository.VisitRepositoty;

/**
 * @author 李建兵
 */
@Service
public class VisitCountDailyService {

    private final
    VisitCountDailyRepositoty visitCountDailyRepositoty;

    @Autowired
    public VisitCountDailyService(VisitCountDailyRepositoty visitCountDailyRepositoty) {
        this.visitCountDailyRepositoty = visitCountDailyRepositoty;
    }

    @Transactional
    public Integer save(VisitCountDaily visitCountDaily){
        VisitCountDaily countDaily = visitCountDailyRepositoty.save(visitCountDaily);
        return countDaily==null?1:0;
    }
}
