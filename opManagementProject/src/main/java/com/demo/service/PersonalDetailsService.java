package com.demo.service;

import java.util.List;
import java.util.logging.Logger;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bo.OutPatientBo;
import com.demo.bo.PersonalDetailBo;
import com.demo.dao.Customized;
import com.demo.entity.OutPatientEntity;
import com.demo.entity.PersonalDetailsEntity;
import com.demo.exception.NullException;
import com.example.demo.OpManagementProjectApplication;

@Component
public class PersonalDetailsService {
	static Logger log = Logger.getLogger(OpManagementProjectApplication.class.getName());


	
	@Autowired
	PersonalDetailBo bo;
	
	
	public PersonalDetailsEntity insertPd(PersonalDetailsEntity add)throws NullException { 
		log.info("Insert method triggered"); 
    try {
	    log.info("Record inserted successfully"); 
	    return bo.insert(add); 
	} 
	catch (NullException e) {
	    log.info("Error while inserting record"); 
	    throw new NullException("Applicant name Invalid"); 
	}
	}
	
	/*public PersonalDetailsEntity insertPd(PersonalDetailsEntity add) {
		
		return bo.insert(add);
	}*/
	
	public PersonalDetailsEntity findById(Integer id) {
		return  bo.findById(id);
		
		}
	
	public List<PersonalDetailsEntity> findAll() throws NullException
	{
		log.info("Find All method triggered");
		try
		{
			log.info("Records Fetched successfully");
			return bo.findAllPd();
		}
		catch (NullException e) 
		{
			log.info("Error while fetching records");
            throw new NullException("No Applicants Found");
        }
		
	}
	
	/*public List<PersonalDetailsEntity> findAll(){
		log.info("findAll method triggered");
		return bo.findAllPd();
	}*/
		
	

	public PersonalDetailsEntity updateOp(PersonalDetailsEntity upd) {
			return bo.updatePd(upd);	
	}
	
	@Autowired
	PersonalDetailBo bo1; 
	
	@Autowired
	OutPatientBo  bo2;
	
	//transaction
	@Transactional(propagation = Propagation.REQUIRED)
	public void transactionDemo(PersonalDetailsEntity   cu1, OutPatientEntity cu2) {
		System.out.println("Patient Add-----Before");
		bo1.insert(cu1);
		System.out.println("Patient Add-----After");
		System.out.println("Patient Add-----Before");
		bo2.insert(cu2);
		System.out.println("Claim Add-----After");
	}
	
	//custom queries
	//filter by id by @query
	public List<PersonalDetailsEntity> filterById(Integer pdId)
	{
		return bo1.filterById(pdId);
	}

	
	
	public List<Customized> filterByCustomized(String name)
	{
		return bo1.filterByCustomized(name);
	}
	//named query
	public List<PersonalDetailsEntity> findAllByDesc(){
		return bo1.findAllByDesc();
	

	}
	//left join
	public List<PersonalDetailsEntity> leftJoin()
	{
		return bo1.leftJoin();
	}
	//innerjoin

	public List<PersonalDetailsEntity> innerJoin()
	{
		return bo1.innerJoin();
	}
	//custom join
	public List<Customized> customizedJoin()
	{
		return bo1.customizedJoin();
	}
}
