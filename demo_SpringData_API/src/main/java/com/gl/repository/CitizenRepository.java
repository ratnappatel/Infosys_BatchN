package com.gl.repository;

import org.springframework.data.repository.CrudRepository;

import com.gl.entity.Citizen;

public interface CitizenRepository  extends CrudRepository<Citizen, Integer>{

}
