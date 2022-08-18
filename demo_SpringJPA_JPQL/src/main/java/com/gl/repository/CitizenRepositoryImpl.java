package com.gl.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.gl.dto.CitizenDTO;
import com.gl.entity.Citizen;
import com.gl.exception.CitizenException;

@Repository
public class CitizenRepositoryImpl implements CitizenRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Object[]> getDobAndAddress() {
		//setting parameter at runtime using : symbol to provide runtime parameter
		Query query=em.createQuery("SELECT c.name, c.dob from Citizen c ");
		List<Object[]> data=query.getResultList();
		return data;
	}

	@Override
	public List<String> getNameEndWith(String pattern) {
		// Named Parameter In Query
		Query query=em.createQuery("SELECT c.name from Citizen c where c.name like :expr");
		query.setParameter("expr",pattern);
		List<String> names=query.getResultList();
		return names;
	}

	@Override
	public List<CitizenDTO> getByDobBetween(LocalDate l1, LocalDate l2) {
		// Indexed Parameter
		Query query=em.createQuery("SELECT c from Citizen c where c.dob between ?1 and ?2");
		query.setParameter(1, l1);
		query.setParameter(2, l2);
		
		List<Citizen> citizens=query.getResultList();
		List<CitizenDTO> citizenDTOs=new ArrayList<CitizenDTO>();
		citizens.forEach((citizen)->{
			citizenDTOs.add(this.getCitizenDTO(citizen));
			});
		
		return citizenDTOs;
	}
	
	public CitizenDTO getCitizenDTO(Citizen citizen)
	{
		CitizenDTO ct=new CitizenDTO();
		ct.setId(citizen.getId());
		ct.setName(citizen.getName());
		ct.setAddress(citizen.getAddress());
		ct.setDob(citizen.getDob());
		ct.setEmailId(citizen.getEmailId());
		ct.setMobileNo(citizen.getMobileNo());
		ct.setGender(citizen.getGender());
		
		return ct;
		
	}

	
	@Override
	public Long getCitizenByGender(String gender) {
		Query query =em.createQuery("SELECT count(c) from Citizen c where c.gender=:gender");
		query.setParameter("gender",gender);
		Object o=query.getSingleResult();
		return 	(long)o ;
	}

	@Override
	public String updateAddress(int id, String address)throws CitizenException
	{
		Query query=em.createQuery("update Citizen c set c.address=:address where c.id=:id");
		query.setParameter("address",address);
		query.setParameter("id", id);
		Citizen c=this.findById(id);
		if(c==null)
			throw new CitizenException("Citizen with id "+id+" does not exists");
		else
		{
			int r=query.executeUpdate();
			if(r>0)
				return "Updated";
			else
				return "Not Updated";
		}
		
	}

	@Override
	public Citizen findById(int id) throws CitizenException{
		Query query=em.createQuery("SELECT c from Citizen c where c.id=?1");
		query.setParameter(1, id);
		Object obj=null;
		try 
		{
			obj=query.getSingleResult();
		}
		catch(Exception e)
		{
			throw new CitizenException("Citizen Details is not availbale.");
		}
		if(obj==null)
			return null;
		else
		{
			Citizen c=(Citizen)obj;
			return c;
		}
	}

}
