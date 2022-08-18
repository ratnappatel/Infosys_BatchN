package com.gl.service;

import java.util.List;

import com.gl.dto.CitizenDTO;
import com.gl.exception.CitizenException;

public interface CitizenService {

	public CitizenDTO addCitizen(CitizenDTO c);
	public List<CitizenDTO> getAllCitizen();
	public CitizenDTO updateCitizen(int id, CitizenDTO c) throws CitizenException;
	public CitizenDTO findCitizenDetails(int id) throws CitizenException;
	public String removeCitizenDetails(int id) throws CitizenException;
}
