package pro.jianbing.aboutme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.jianbing.aboutme.entity.VisitCountDaily;
import pro.jianbing.aboutme.service.KeywordService;
import pro.jianbing.aboutme.service.VisitCountDailyService;
import pro.jianbing.aboutme.service.VisitService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李建兵
 */
@RestController
@RequestMapping("/visit")
public class VisitController {

    private final
    VisitCountDailyService visitCountDailyService;
    private final VisitService visitService;

    @Autowired
    public VisitController(VisitCountDailyService visitCountDailyService,VisitService visitService) {
        this.visitCountDailyService = visitCountDailyService;
        this.visitService = visitService;
    }

    @GetMapping("count/daily")
    public Map<String,Object> getCountVisitorsDaily(){
        List<VisitCountDaily> all = visitCountDailyService.findAll();
        int size = all.size();
        List<String> date = new ArrayList<>(size);
        List<Integer> count = new ArrayList<>(size);
        for(int i=0;i<size;i++){
            VisitCountDaily visitCountDaily = all.get(i);
            date.add(visitCountDaily.getDay());
            count.add(visitCountDaily.getCount());
        }
        Integer visitorsToday = visitService.countVisitorsToday();
        date.add(LocalDate.now().toString());
        count.add(visitorsToday);
        Map<String, Object> result = new HashMap<>(4);
        result.put("code",0);
        result.put("date",date);
        result.put("count",count);
        return result;
    }
}
