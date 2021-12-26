package com.yj.app.task;

import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component
@Log
public class FileCheckTask {

	//@Scheduled(fixedDelay = 10000)
	//@Scheduled(cron = "15,30 * * * *")
	public void checkFile() {
		log.info("file check=============");
		log.info("==================");
	}
}
