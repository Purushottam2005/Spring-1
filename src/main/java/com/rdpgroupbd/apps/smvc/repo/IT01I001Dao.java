package com.rdpgroupbd.apps.smvc.repo;

import java.util.List;

import com.rdpgroupbd.apps.smvc.domain.T01I001;

public interface IT01I001Dao {
	
	public List<T01I001> findAll();
	
	public void save(T01I001 e);
	
	public void update(T01I001 e);
	
}
