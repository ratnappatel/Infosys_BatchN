package com.gl.repository;

import java.util.List;

import com.gl.dto.ProductsDTO;
import com.gl.entity.Products;

public interface ProductRepository 
{
	public List<ProductsDTO> getAllProduct();
	public String addProduct(Products p);
	public Products getProductDetails(int productId);
	public String updateProductDetails(int productId, String name);
	public String deleteProduct(int productId);
}
