package com.rdpgroupbd.apps.smvc.event;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rdpgroupbd.apps.smvc.domain.AuditUser;
import com.rdpgroupbd.apps.smvc.domain.AuthUser;

@Component
public class PreUpdateHandler implements PreUpdateEventListener, Serializable {

	private static final long serialVersionUID = 5285566849342476348L;

	Logger log = LoggerFactory.getLogger(PreUpdateHandler.class);

	public boolean onPreUpdate(PreUpdateEvent event) {
		trackUser(event);
		return false;
	}

	private void trackUser(PreUpdateEvent event) {
		log.info("PRE UPDATE");
		try {
			AuthUser auth = (AuthUser) event.getEntity();
			AuditUser audit = auth.getAudit();
			audit.setReviseUser(1);
			audit.setReviseDate(new Date());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
