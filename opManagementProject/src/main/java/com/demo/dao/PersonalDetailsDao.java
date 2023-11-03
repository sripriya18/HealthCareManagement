package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.demo.entity.PersonalDetailsEntity;


@Repository
public interface PersonalDetailsDao extends JpaRepository<PersonalDetailsEntity,Integer> {
	//filter by id @query
	@Query(value="select p from PersonalDetailsEntity p where p.pdId> :pdId")
	List<PersonalDetailsEntity> filterById(@Param("pdId") int pdId);
	//substring @query
	/*
	 * @Query(value ="select p from PdEntity p where p.name LIKE%:name%")
	 * List<PdEntity> filterByName(@Param("name") String name);
	 */
	
	@Query("select c.street as street, c.email as email from PersonalDetailsEntity c where c.name=:name")
	List<Customized>filterByCustomized(@Param("name")String name);
	//named query
	List<PersonalDetailsEntity> findAllByDesc();
	 
	//left join
	@Query("select p from PersonalDetailsEntity p LEFT JOIN p.op l")
	List<PersonalDetailsEntity> leftJoin();
	//inner join
	@Query("select p from PersonalDetailsEntity p JOIN p.op  l")
	List<PersonalDetailsEntity> innerJoin();
	
	//customized join
	@Query("select p.name as name,p.street as street,p.email as email from PersonalDetailsEntity p JOIN p.op l")
	List<Customized> customizedJoin();
	

}
