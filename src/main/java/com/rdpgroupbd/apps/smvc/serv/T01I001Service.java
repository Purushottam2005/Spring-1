package com.rdpgroupbd.apps.smvc.serv;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rdpgroupbd.apps.smvc.domain.T01I001;
import com.rdpgroupbd.apps.smvc.repo.IT01I001Dao;

@Service
@Transactional(readOnly = true)
public class T01I001Service implements IT01I001Service {

	@Autowired
	private IT01I001Dao continentDao;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = false)
	public List<T01I001> findAll() {
		T01I001 model = new T01I001();
		model.setNameEn("Event Test");
		model.setNameBn("Event Check");
		continentDao.save(model);
		sessionFactory.getCurrentSession().flush();
		return continentDao.findAll();
	}

}
