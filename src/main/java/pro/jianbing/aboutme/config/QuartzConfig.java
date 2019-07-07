package pro.jianbing.aboutme.config;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.jianbing.aboutme.job.GetDataJob;

import static org.quartz.DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule;


/**
 * @author 李建兵
 */
@Configuration
public class QuartzConfig {

    /**
     * 使用jobDetail包装job
     * @return
     */
    @Bean
    public JobDetail myJobDetail() {
        return JobBuilder.newJob(GetDataJob.class).withIdentity("getDataJob").storeDurably().build();
    }

    /**
     * 把jobDetail注册到trigger上去
     * @return
     */
    @Bean
    public Trigger myJobTrigger() {
        DailyTimeIntervalScheduleBuilder scheduleBuilder = dailyTimeIntervalSchedule()
                .startingDailyAt(TimeOfDay.hourAndMinuteOfDay(0, 1))
                .withIntervalInHours(8);

        return TriggerBuilder.newTrigger()
                .forJob(myJobDetail())
                .withIdentity("getDataJobTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
