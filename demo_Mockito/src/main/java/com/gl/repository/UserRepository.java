package com.gl.repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
	Map<String,String> contacts=new HashMap<String,String>();
	
	public UserRepository() {
		contacts.put("Uttam", "7976694711");
	}
	
	public String getMobileNo(String name)
	{
		if(contacts.containsKey(name))
			return contacts.get(name);
		else
			return null;
	}

}
