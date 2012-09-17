package com.rdpgroupbd.apps.smvc.event;

import java.io.Serializable;

import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.rdpgroupbd.apps.smvc.domain.AuditUser;
import com.rdpgroupbd.apps.smvc.domain.AuthUser;

@Component
public class PostUpdateHandler implements PostUpdateEventListener, Serializable {

	private static final long serialVersionUID = -35081922295946530L;
	private static Logger log = LoggerFactory.getLogger(PostUpdateHandler.class);

	public void onPostUpdate(PostUpdateEvent event) {
		trackUser(event);
	}

	private void trackUser(PostUpdateEvent event) {
		AuthUser auth = (AuthUser) event.getEntity();
		AuditUser audit = auth.getAudit();
		log.info("POST UPDATE => REVISE:" + audit.getReviseUser() + " REVISED: " + audit.getReviseDate());
	}
}
