package com.gl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.repository.CitizenRepository;

@Service
public class CitizenServiceImpl implements CitizenService {

	@Autowired
	CitizenRepository repository;
	
	@Override
	public List<Object[]> getNameAndDob() {
		List<Object[]> data=repository.getDobAndAddress();
		
		return data;
	}

}
