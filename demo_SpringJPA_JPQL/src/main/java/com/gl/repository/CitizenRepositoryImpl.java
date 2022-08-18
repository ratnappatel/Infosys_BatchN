package com.gl.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class CitizenRepositoryImpl implements CitizenRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Object[]> getDobAndAddress() {
		Query query=em.createQuery("SELECT c.name, c.dob from Citizen c");
		List<Object[]> data=query.getResultList();
		return data;
	}

}
