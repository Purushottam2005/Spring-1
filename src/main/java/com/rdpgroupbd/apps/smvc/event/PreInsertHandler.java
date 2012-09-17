package com.rdpgroupbd.apps.smvc.event;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rdpgroupbd.apps.smvc.domain.AuditUser;
import com.rdpgroupbd.apps.smvc.domain.AuthUser;

@Component
public class PreInsertHandler implements PreInsertEventListener, Serializable {

	private static final long serialVersionUID = 5950455283932090556L;

	Logger log = LoggerFactory.getLogger(PreInsertHandler.class);

	public boolean onPreInsert(PreInsertEvent event) {
		trackUser(event);
		return false;
	}

	private void trackUser(PreInsertEvent event) {
		log.info("PRE INSERT");
		try {
			AuthUser auth = (AuthUser) event.getEntity();
			AuditUser audit = auth.getAudit();
			audit.setEntryUser(1);
			audit.setEntryDate(new Date());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}
}
