package com.gl.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dto.CitizenDTO;
import com.gl.exception.CitizenException;
import com.gl.repository.CitizenRepository;

@Service
@Transactional
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	CitizenRepository repository;
	
	@Override
	public List<Object[]> getNameAndDob() {
		List<Object[]> data=repository.getDobAndAddress();
		
		return data;
	}

	@Override
	public List<String> getNameEndsWith(String expr) {
		
		return repository.getNameEndWith(expr);
	}

	@Override
	public List<CitizenDTO> getCitizensByDobBetween(LocalDate l1, LocalDate l2) {
		
		return repository.getByDobBetween(l1, l2);
	}

	@Override
	public Long getCitizenByGender(String gender) {
		return repository.getCitizenByGender(gender);
	}

	@Override
	public String updateCitizenAddress(int id, String address) throws CitizenException{
		
		return repository.updateAddress(id, address);
	}

}
