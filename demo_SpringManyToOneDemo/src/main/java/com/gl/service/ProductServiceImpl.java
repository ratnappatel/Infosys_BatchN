package com.gl.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.entity.Product;
import com.gl.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository repository;
	@Override
	public Product addProduct(Product p) {
		p=repository.save(p);
		return p;
	}

	@Override
	public List<Product> getAllProduct() {
		Iterable<Product> itr=repository.findAll();
		List<Product> products=new ArrayList<Product>();
		itr.forEach((p)->{ products.add(p);	});
		return products;
	}

}
