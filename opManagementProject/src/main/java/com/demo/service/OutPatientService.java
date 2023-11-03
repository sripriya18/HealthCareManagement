package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.bo.OutPatientBo;
import com.demo.entity.OutPatientEntity;
@Component
public class OutPatientService {
	
	@Autowired
	OutPatientBo bo;
	
	public OutPatientEntity insertOp(OutPatientEntity add) {
		return bo.insert(add);
	}
	
	public OutPatientEntity findById(Integer id) {
		return  bo.findById(id);
		
		}
	
	public List<OutPatientEntity> findAll(){
		return bo.findAll();
	}
		
	public OutPatientEntity updateOp(OutPatientEntity upd) {
			return bo.updateOp(upd);	
	}
		
	

}