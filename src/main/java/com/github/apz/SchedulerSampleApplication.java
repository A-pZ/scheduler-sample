package com.github.apz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;

@SpringBootApplication
@EnableScheduling
// EnableSchedulerLockの属性値に指定する時間フォーマットはjava.time.Durationを利用。
// https://en.wikipedia.org/wiki/ISO_8601#Durations
// MostForはロック時間の最長。LeastFor は ロック時間の最短。
@EnableSchedulerLock(defaultLockAtMostFor = "PT5M", defaultLockAtLeastFor = "PT30S")
public class SchedulerSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchedulerSampleApplication.class, args);
	}

}
