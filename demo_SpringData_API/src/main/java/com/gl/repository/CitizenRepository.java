package com.gl.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.gl.entity.Citizen;

public interface CitizenRepository  extends CrudRepository<Citizen, Integer>{

	public Optional<Citizen> findByName(String name);
	
	// like '2/5 Heerabagh %'
	@Query("SELECT c.name, c.address from Citizen c where c.address like :expr")
	public List<String[]> getCitizenByAddress(@Param("expr")String expr);
}
