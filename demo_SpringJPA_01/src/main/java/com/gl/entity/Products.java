package com.gl.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity  // Persistence entity & not a Normal Java POJO Object
@Table(name="Product")
public class Products {
	
	@Id
	@Column(name="id") // actual name of column in DB-Table
	private int productId;
	private String name;
	private float price;
	public Products() {
		
	}
	public Products(int productId, String name, float price) {
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
		
		Products other = (Products) obj;
		return Objects.equals(name, other.name) && Float.floatToIntBits(price) == Float.floatToIntBits(other.price)
				&& productId == other.productId;
	}
	@Override
	public String toString() {
		return "Products [productId=" + productId + ", name=" + name + ", price=" + price + "]";
	}
	
	

}
