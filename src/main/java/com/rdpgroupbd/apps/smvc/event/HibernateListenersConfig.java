package com.rdpgroupbd.apps.smvc.event;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
@SuppressWarnings("restriction")
public class HibernateListenersConfig {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private PreInsertHandler preInsert;

	@Autowired
	private PreUpdateHandler preUpdate;

	@Autowired
	private PostInsertHandler postInsert;

	@Autowired
	private PostUpdateHandler postUpdate;

	@PostConstruct
	public void registerListeners() {
		SessionFactoryImpl sessionFactoryImpl = (SessionFactoryImpl) sessionFactory;
		ServiceRegistryImplementor  sri = sessionFactoryImpl.getServiceRegistry();
		EventListenerRegistry reg = sri.getService(EventListenerRegistry.class);
		
		register(reg, EventType.PRE_INSERT, preInsert);
		register(reg, EventType.PRE_UPDATE, preUpdate);
		register(reg, EventType.POST_INSERT, postInsert);
		register(reg, EventType.POST_UPDATE, postUpdate);		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void register(EventListenerRegistry reg, EventType evt, Object lstnr) {
		reg.getEventListenerGroup(evt).appendListener(lstnr);
	}

}
