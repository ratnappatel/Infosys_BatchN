package com.gl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.repository.UserRepository;

@Service
public class UserServiceImpl {
	
	@Autowired
	UserRepository repository;
	public String findContact(String name)
	{
		String mobileNo=repository.getMobileNo(name);
		if(mobileNo==null)
			return "Not Found";
		else
			return "Found";
	}

}
