package pro.jianbing.aboutme.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import pro.jianbing.aboutme.entity.VisitCountDaily;
import pro.jianbing.aboutme.service.VisitCountDailyService;
import pro.jianbing.aboutme.service.VisitService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 李建兵
 */
public class GetDataJob extends QuartzJobBean {
    private static final Logger log = LoggerFactory.getLogger(GetDataJob.class);

    @Autowired
    VisitService visitService;
    @Autowired
    VisitCountDailyService visitCountDailyService;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("开始执行任务：读取并写入每日访问量");
        String yestoday = LocalDate.now().minusDays(1L).toString();
        List<VisitCountDaily> byDay = visitCountDailyService.findByDay(yestoday);
        if (null==byDay||byDay.size()<1){
            Integer visitDaily = visitService.countVisitDaily();
            log.info("昨天的访问量："+visitDaily);
            log.info("开始插入昨日访问量.........");
            VisitCountDaily visitCountDaily = new VisitCountDaily();
            visitCountDaily.setCount(visitDaily);
            visitCountDaily.setDay(LocalDate.now().minusDays(1L).toString());
            visitCountDailyService.save(visitCountDaily);
            log.info("任务完成：读取并写入每日访问量");
        } else {
            log.info("数据已经存在，跳过任务");
        }
    }
}
