package com.gl.services;

import java.time.LocalDate;
import java.util.List;

import com.gl.dto.CitizenDTO;
import com.gl.exception.CitizenException;

public interface CitizenService {
	
	public List<Object[]> getNameAndDob();
	public List<String> getNameEndsWith(String expr);
	public List<CitizenDTO> getCitizensByDobBetween(LocalDate l1,LocalDate l2);
	public Long getCitizenByGender(String gender);
	public String updateCitizenAddress(int id,String address) throws CitizenException;

}
