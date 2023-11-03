package com.demo.bo;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.dao.PersonalDetailsDao;
import com.demo.dao.Customized;
import com.demo.entity.PersonalDetailsEntity;
import com.demo.exception.NullException;
@Component
public class PersonalDetailBo {
	static Logger log = Logger.getLogger(PersonalDetailBo.class.getName());


	@Autowired
	PersonalDetailsDao dao;
	PersonalDetailsEntity a=new PersonalDetailsEntity();

	public PersonalDetailsEntity insert(PersonalDetailsEntity add) {
		if (add.getName() == null || add.getName().isEmpty()) {
			log.info("error occured while running insert method");
	        throw new NullException("Patient name cannot be empty.");
	    }
		return dao.save(add);
		
	}
		
	public PersonalDetailsEntity findById(Integer id) {
		Optional<PersonalDetailsEntity> doc = dao.findById(id);
		if(doc.isPresent()) {
			PersonalDetailsEntity c=doc.get();
			return c;
		}
		else {
			throw new NullException("Inappropriate Id");
		}
	}
	
	public List<PersonalDetailsEntity> findAllPd(){
		if(a==null) {
			log.info("error occured while running findAllPd parent method ");

			throw new NullException("there is no data exist in this table");
		}

		return dao.findAll();
	}
		
	public PersonalDetailsEntity updatePd(PersonalDetailsEntity myd) {
		if(myd.getPdId()<=0) {
			throw new NullException("Inappropriate Id");
		}
			return dao.save(myd);	
	}
	//filter by id by @query
	public List<PersonalDetailsEntity> filterById(int pdId){
		return dao.filterById(pdId);
		
		
	}
	

	/*
	 * //substring by @query public List<PdEntity> filterByName(String name){ return
	 * dao.filterByName(name); }
	 */
	
	public List<Customized> filterByCustomized(String name)
	{
		return dao.filterByCustomized(name);
	}
	//named query
	public List<PersonalDetailsEntity> findAllByDesc(){

		return dao.findAllByDesc();
	}
	
		//left join
	public List<PersonalDetailsEntity> leftJoin()
	{
		log.info("leftJoin method started");

		return dao.leftJoin();
	
	}
	//innerjoin
	public List<PersonalDetailsEntity> innerJoin()
	{
		log.info("innerJoin method started");

		return dao.innerJoin();
	
	}
	//custom join
	public List<Customized> customizedJoin()
	{
		log.info("customizedJoin method started");

		return dao.customizedJoin();
	
	}
	
	}
	
	

