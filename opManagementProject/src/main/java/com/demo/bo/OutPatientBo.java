package com.demo.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.dao.OutPatientDao;
import com.demo.entity.OutPatientEntity;
@Component
public class OutPatientBo {
	@Autowired
	OutPatientDao dao;

	public OutPatientEntity insert(OutPatientEntity add) {
		return dao.save(add);
		
	}
		
	public OutPatientEntity findById(Integer id) {
		Optional<OutPatientEntity>   fetch = dao.findById(id);
		return fetch.get();
		}
	
	public List<OutPatientEntity> findAll(){
		return dao.findAll();
	}
		
	public OutPatientEntity updateOp(OutPatientEntity myd) {
			return dao.save(myd);	
	}
}
