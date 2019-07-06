package pro.jianbing.aboutme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pro.jianbing.aboutme.entity.Visit;
import pro.jianbing.aboutme.repository.VisitRepositoty;

/**
 * @author 李建兵
 */
@Service
public class VisitService {

    private final
    VisitRepositoty visitRepositoty;

    @Autowired
    public VisitService(VisitRepositoty visitRepositoty) {
        this.visitRepositoty = visitRepositoty;
    }

    @Transactional
    public Integer saveVisit(Visit visit){
        visit = visitRepositoty.save(visit);
        if (visit!=null){
            return 1;
        }
        return 0;
    }
}
