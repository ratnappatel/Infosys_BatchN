package com.gl.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dto.CitizenDTO;
import com.gl.entity.Citizen;
import com.gl.exception.CitizenException;
import com.gl.repository.CitizenRepository;

@Service
@Transactional
public class CitizenServiceImpl implements CitizenService{

	@Autowired
	private CitizenRepository repository;
	@Override
	public CitizenDTO addCitizen(CitizenDTO citizenDTO) {
		Citizen citizen=this.getCitizenEntity(citizenDTO);
		citizen=repository.save(citizen);
		return this.getCitizenDTO(citizen);
	}

	@Override
	public List<CitizenDTO> getAllCitizen() {
		Iterable<Citizen> itr=repository.findAll();
		List<CitizenDTO> citizenDTOs=new ArrayList<CitizenDTO>();
		itr.forEach((citizen)->{
			citizenDTOs.add(this.getCitizenDTO(citizen));
		});
		return citizenDTOs;
	}
	

	@Override
	public CitizenDTO updateCitizen(int id, CitizenDTO c) throws CitizenException {
		Optional<Citizen> citizenOptional=repository.findById(id);
		Citizen citizen=citizenOptional.orElseThrow(()->new CitizenException("Citizen with id "+id+" does not exists"));
		
		citizen.setAddress(c.getAddress());
		citizen.setDob(c.getDob());
		citizen.setEmailId(c.getEmailId());
		citizen.setGender(c.getGender());
		citizen.setMobileNo(c.getMobileNo());
		
		citizen=repository.save(citizen);
		
		return this.getCitizenDTO(citizen);
	}

	@Override
	public CitizenDTO findCitizenDetails(int id) throws CitizenException {
		Optional<Citizen> optionalCitizen=repository.findById(id);
		
		Citizen c=optionalCitizen.orElseThrow(()-> new CitizenException("Citizen with id "+id+" does not exists"));
		return this.getCitizenDTO(c);
		
	}

	@Override
	public String removeCitizenDetails(int id) throws CitizenException {
Optional<Citizen> optionalCitizen=repository.findById(id);
		
		Citizen c=optionalCitizen.orElseThrow(()-> new CitizenException("Citizen with id "+id+" does not exists"));
		
		repository.delete(c);
		return "Deleted";
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
	
	public Citizen getCitizenEntity(CitizenDTO citizen)
	{
		Citizen ct=new Citizen();
		ct.setId(citizen.getId());
		ct.setName(citizen.getName());
		ct.setAddress(citizen.getAddress());
		ct.setDob(citizen.getDob());
		ct.setEmailId(citizen.getEmailId());
		ct.setMobileNo(citizen.getMobileNo());
		ct.setGender(citizen.getGender());
		
		return ct;
		
	}
	
	

}
