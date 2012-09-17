package com.rdpgroupbd.apps.smvc.quartz;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("runMeTask")
public class RunMeTask implements Serializable {
	
	private static final long serialVersionUID = -6516758908423844550L;
	private static Logger log = LoggerFactory.getLogger(RunMeTask.class);
	
	public void printMe() {
		log.info("Corn Job");
	}
}
