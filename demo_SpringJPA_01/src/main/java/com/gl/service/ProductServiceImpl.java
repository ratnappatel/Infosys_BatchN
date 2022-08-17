package com.gl.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.dto.ProductsDTO;
import com.gl.entity.Products;
import com.gl.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired 
	private ProductRepository repository;
	
	@Override
	public List<ProductsDTO> getAllProducts() {
		List<ProductsDTO> products=repository.getAllProduct();
		List<ProductsDTO> filteredProducts=products.stream()
				.filter(p->p.getPrice()>1000).sorted().collect(Collectors.toList());
		return filteredProducts;
	}

	@Override
	public String addNewProduct(ProductsDTO p) {
		return repository.addProduct(this.getProductEntity(p));
		
	}
	
	

	@Override
	public ProductsDTO getProduct(int productId) {
		Products p=repository.getProductDetails(productId);
		return this.getProductsDTO(p);
	}

	@Override
	public String updateProductDetails(int productId, String name) {
		String msg=repository.updateProductDetails(productId, name);
		return msg;
	}
	
	public ProductsDTO getProductsDTO(Products p)
	{
		ProductsDTO prd=new ProductsDTO();
		prd.setProductId(p.getProductId());
		prd.setName(p.getName());
		prd.setPrice(p.getPrice());
		return prd;
	}
	
	public Products getProductEntity(ProductsDTO p)
	{
		Products prd=new Products();
		prd.setProductId(p.getProductId());
		prd.setName(p.getName());
		prd.setPrice(p.getPrice());
		return prd;
	}

	@Override
	public String removeProductDetails(int productId) {
		return repository.deleteProduct(productId);
	}

}
