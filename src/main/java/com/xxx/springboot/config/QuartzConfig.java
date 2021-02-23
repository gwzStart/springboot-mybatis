package com.xxx.springboot.config;

import com.xxx.springboot.jobs.MyFirstJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther:嘻嘻
 * @Date:2021/2/22 - 02 - 22 - 22:15
 * @Description:com.xxx.springboot.config
 * @version:v1.0.0
 */

//定时执行任务
//@Configuration
public class QuartzConfig {

    @Bean
    public JobDetail jobDetail() {
        return JobBuilder.newJob(MyFirstJob.class).storeDurably().build();
    }

    @Bean
    public Trigger trigger1() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                //一秒执行一次
                .withIntervalInSeconds(1)
                //永久重复
                .repeatForever();
        return TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(scheduleBuilder)
                .forJob(jobDetail())
                .build();
    }

    @Bean
    public Trigger trigger2() {

        return TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "group1")
                //每5秒执行一次
                .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ? *"))
                .forJob(jobDetail())
                .build();
    }

}
