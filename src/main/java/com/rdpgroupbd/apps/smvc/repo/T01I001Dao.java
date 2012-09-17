package com.rdpgroupbd.apps.smvc.repo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.rdpgroupbd.apps.smvc.domain.T01I001;


@Repository
public class T01I001Dao implements IT01I001Dao {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<T01I001> findAll() throws DataAccessException {
		List<T01I001> list = new ArrayList<T01I001>();
		Session session = sessionFactory.getCurrentSession();
		list = session.createCriteria(T01I001.class).list();
		return list;
	}
	
	public void save(T01I001 e) {
		Session session = sessionFactory.getCurrentSession();
		session.save(e);
	}
	
	public void update(T01I001 e) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(e);
	}
}
