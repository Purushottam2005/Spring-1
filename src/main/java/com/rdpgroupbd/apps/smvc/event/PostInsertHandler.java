package com.rdpgroupbd.apps.smvc.event;

import java.io.Serializable;

import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rdpgroupbd.apps.smvc.domain.AuditUser;
import com.rdpgroupbd.apps.smvc.domain.AuthUser;

@Component
public class PostInsertHandler implements PostInsertEventListener, Serializable {

	private static final long serialVersionUID = 8807432409552952627L;
	private static Logger log = LoggerFactory.getLogger(PostInsertHandler.class);

	public void onPostInsert(PostInsertEvent event) {
		trackUser(event);
	}

	private void trackUser(PostInsertEvent event) {
		try {
			AuthUser auth = (AuthUser) event.getEntity();
			AuditUser audit = auth.getAudit();
			log.info("POST INSERT => ENTERER:" + audit.getEntryUser() + " ENTERED: " + audit.getEntryDate());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
	}

}
