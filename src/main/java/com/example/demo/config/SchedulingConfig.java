package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * 定时任务配置
 *
 * @Author luoyong
 * @Date 2021-06-01 13:00
 */
@Configuration
@EnableScheduling
@ConditionalOnProperty(prefix = "luoyong.scheduling", name = "enabled", havingValue = "true")
public class SchedulingConfig implements SchedulingConfigurer {

	@Value("${luoyong.scheduling.pool-size:10}")
	private Integer poolSIze;

	@Value("${luoyong.scheduling.await-termination:60}")
	private Integer awaitTermination;

	@Value("${luoyong.application.name:xm-system}")
	private String applicationName;

	/**
	 * 使用线程池执行定时任务
	 *
	 * @param taskRegistrar 注册器
	 */
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		// 获取线程池
		TaskScheduler taskScheduler = taskScheduler();
		// 设置执行定时任务的线程池
		taskRegistrar.setTaskScheduler(taskScheduler);
	}

	/**
	 * 配置一个线程池用于执行定时任务，多任务并行策略
	 */
	@Bean(destroyMethod = "shutdown")
	public ThreadPoolTaskScheduler taskScheduler() {
		ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
		scheduler.setPoolSize(poolSIze);
		scheduler.setThreadNamePrefix(applicationName + "-");
		scheduler.setAwaitTerminationSeconds(awaitTermination);
		scheduler.setWaitForTasksToCompleteOnShutdown(true);
		return scheduler;
	}
}
