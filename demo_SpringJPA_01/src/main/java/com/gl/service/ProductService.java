package com.gl.service;

import java.util.List;

import com.gl.dto.ProductsDTO;

public interface ProductService {
	
	public List<ProductsDTO> getAllProducts();
	public String addNewProduct(ProductsDTO p);
	public ProductsDTO getProduct(int productId);
	public String updateProductDetails(int productId,String name);
	public String removeProductDetails(int productId);

}
