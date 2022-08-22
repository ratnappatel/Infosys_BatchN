package com.gl.repository;

import org.springframework.data.repository.CrudRepository;

import com.gl.entity.Address;
import com.gl.entity.Student;

public interface AddressRepository extends CrudRepository<Address,Integer>{

}
