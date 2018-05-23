package com.joylink.userms.configuration;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.joylink.userms.quartz.GetAccessTokenQuartz;

@Configuration
public class QuartzConfiguration {
	
	@Bean
    public JobDetail teatQuartzDetail(){
        return JobBuilder.newJob(GetAccessTokenQuartz.class).withIdentity("getAccessTokenQuartz").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger(){
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(60*60)  //设置时间周期单位秒
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(teatQuartzDetail())
                .withIdentity("getAccessTokenQuartz")
                .withSchedule(scheduleBuilder)
                .build();
    }
	
}
