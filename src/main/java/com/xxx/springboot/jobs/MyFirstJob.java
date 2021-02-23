package com.xxx.springboot.jobs;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther:嘻嘻
 * @Date:2021/2/22 - 02 - 22 - 22:09
 * @Description:com.xxx.springboot.jobs
 * @version:v1.0.0
 */

public class MyFirstJob implements Job {

    private Logger log = LoggerFactory.getLogger(MyFirstJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        TriggerKey triggerKey = context.getTrigger().getKey();
        log.info("触发器:" + triggerKey.getName() + "--->所属组:" + triggerKey.getGroup()
                + "--->" + sdf.format(new Date()) + "-->" + "hello spring Boot Quartz........");
    }
}
