package com.gl.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int price;
	
	
	@Column(name="order_date")
	LocalDate orderDate;
	public Order() {
	}
	public Order(int id, int price,LocalDate orderDate) {
		super();
		this.id = id;
		this.price = price;
		this.orderDate=orderDate;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, price);
	}
	@Override
	public boolean equals(Object obj) {
	
		Order other = (Order) obj;
		return id == other.id && price == other.price;
	}
	
	
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	@Override
	public String toString() {
		
		return "Order [id=" + id + ", price=" + price + "]";
	}
	
	
}
