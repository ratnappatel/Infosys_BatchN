package com.gl.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.gl.dto.ProductsDTO;
import com.gl.entity.Products;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

	@PersistenceContext
	EntityManager em;
	
	@Override
	public List<ProductsDTO> getAllProduct() {
		String str="SELECT p from Products p";
		TypedQuery<Products> query=em.createQuery(str,Products.class);
		List<Products> lists=query.getResultList();
		
		List<ProductsDTO> products=new ArrayList<ProductsDTO>();
				
		lists.forEach((product)->{
			ProductsDTO p=new ProductsDTO();
			
			p.setProductId(product.getProductId());
			p.setName(product.getName());
			p.setPrice(product.getPrice());
			
			products.add(p);
		});
			return products;
	}

	@Override
	public String addProduct(Products p) {
		em.persist(p);
		return "Inserted Successfully.";
	}

	@Override
	public Products getProductDetails(int productId) {
	Products p=em.find(Products.class, productId);
		return p;
	}

	@Override
	public String updateProductDetails(int productId, String name) {
		Products p=this.getProductDetails(productId);
		if(p!=null)
			p.setName(name);
		else
			return "Product does not exists!!";
		return "Product Details Updated..";
	}

	@Override
	public String deleteProduct(int productId) {
		Products p=this.getProductDetails(productId);
		if(p!=null)
			em.remove(p);
		else
			return "Product does not exists!!";
		return "Product Details Removed Successfully";
	}

}
