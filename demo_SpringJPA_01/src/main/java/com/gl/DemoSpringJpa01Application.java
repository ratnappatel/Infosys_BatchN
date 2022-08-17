package com.gl;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.apache.commons.logging.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.dto.ProductsDTO;
import com.gl.service.ProductService;

@SpringBootApplication
public class DemoSpringJpa01Application implements CommandLineRunner{

	@Autowired ProductService service;
	private final Log LOGGER=LogFactory.getLog(DemoSpringJpa01Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringJpa01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//this.findProduct();
		//this.updateProduct();
		//this.findProduct();
		//this.addProduct();
		//this.displayAllProduct();
		this.deleteProduct();
		
	}
	public void displayAllProduct()
	{
		List<ProductsDTO> prd=service.getAllProducts();
		for(ProductsDTO p:prd)
			System.out.println(p);
	}
	
	public void addProduct()
	{
		ProductsDTO p=new ProductsDTO(999,"Fit Bit By Samsung",2999);
		String msg=service.addNewProduct(p);
		System.out.println(msg);
		LOGGER.info(msg);
	}

	public void findProduct()
	{
		int productId=12;
		ProductsDTO p=service.getProduct(productId);
		System.out.println(p);
	}
	public void updateProduct()
	{
	
		int productId=12;
		String name="Portable Table";
		
		String msg=service.updateProductDetails(productId, name);
		LOGGER.info(msg);
	}
	public void deleteProduct()
	{
		int productId=999;
		String msg=service.removeProductDetails(productId);
		System.out.println(msg);
	}
}
