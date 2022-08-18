package com.gl.repository;

import java.time.LocalDate;
import java.util.List;

import com.gl.dto.CitizenDTO;
import com.gl.entity.Citizen;
import com.gl.exception.CitizenException;

public interface CitizenRepository {
	
	public List<Object[]> getDobAndAddress();
	public List<String> getNameEndWith(String pattern);
	public List<CitizenDTO> getByDobBetween(LocalDate l1,LocalDate l2);
	public Long getCitizenByGender(String gender);
	public String updateAddress(int id, String address) throws CitizenException;
	public Citizen findById(int id) throws CitizenException;

}
