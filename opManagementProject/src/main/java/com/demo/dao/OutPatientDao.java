package com.demo.dao;


	

	import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.OutPatientEntity;

	@Repository
	public interface OutPatientDao extends JpaRepository<OutPatientEntity,Integer> {

	}

