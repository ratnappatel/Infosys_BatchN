package com.gl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gl.entity.Order;
import com.gl.entity.Product;
import com.gl.service.ProductService;

@SpringBootApplication
public class DemoSpringManyToOneDemoApplication  implements CommandLineRunner{

	@Autowired
	ProductService service;
	public static void main(String[] args) {
		SpringApplication.run(DemoSpringManyToOneDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.addProduct();
		this.getAllProduct();
		
	}

	private void getAllProduct() {
		List<Product> products=service.getAllProduct();
		for(Product p:products)
			System.out.println(p);
	}

	private void addProduct() {
		Order o1=new Order();
		o1.setPrice(100);
		o1.setOrderDate(LocalDate.of(2022, 03, 23));
	
		Product p1=new Product();
		p1.setTitle("Keyboard");
		p1.setCost(2499.0f);
		p1.setOrder(o1);
		
		Product p2=new Product();
		p2.setTitle("Portable Speaker");
		p2.setCost(1789.0f);
		p2.setOrder(o1);
				
		Product p3=new Product();
		p3.setTitle("USB Cable");
		p3.setCost(299.00f);
		p3.setOrder(o1);
		
		service.addProduct(p1);
		//service.addProduct(p2);
		//service.addProduct(p3);
		
	}

}
