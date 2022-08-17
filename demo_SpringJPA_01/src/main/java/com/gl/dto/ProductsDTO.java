package com.gl.dto;

import java.util.Objects;

public class ProductsDTO implements Comparable <ProductsDTO> {
	
	private int productId;
	private String name;
	private float price;
	public ProductsDTO() {
		// TODO Auto-generated constructor stub
	}
	public ProductsDTO(int productId, String name, float price) {
		super();
		this.productId = productId;
		this.name = name;
		this.price = price;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, price, productId);
	}
	@Override
	public boolean equals(Object obj) {
		
		ProductsDTO other = (ProductsDTO) obj;
		return Objects.equals(name, other.name) && Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& productId == other.productId;
	}
	@Override
	public String toString() {
		return "ProductsDTO [productId=" + productId + ", name=" + name + ", price=" + price + "]";
	}
	
	@Override
	public int compareTo(ProductsDTO p) {
		float r=p.price-this.price;
		return (int)r;
	}
	

}
