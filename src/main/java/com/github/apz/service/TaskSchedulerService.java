package com.github.apz.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.github.apz.repository.TaskRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.core.SchedulerLock;

@Service
@AllArgsConstructor
@Slf4j
public class TaskSchedulerService {
	
	TaskRepository repository;
	
	@Scheduled(cron = "0/10 * * * * ?")
	@SchedulerLock(name = "TaskScheduler_scheduledTask")
	public void registerNormal() {
		log.info("****normal");
		repository.register("normal");
	}
	
	@Scheduled(cron = "30 0/1 * * * ?")
	@SchedulerLock(name = "TaskScheduler_scheduledTaskSlow")
	public void registerSlow() {
		log.info("----slow");
		repository.register("slow");
	}
}
