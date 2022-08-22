package com.gl.dto;

import java.util.Objects;

public class AddressDTO {
	
	private int id;
	private String street;
	private String city;
	public AddressDTO() {
		// TODO Auto-generated constructor stub
	}
	public AddressDTO(int id, String street, String city) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public int hashCode() {
		return Objects.hash(city, id, street);
	}
	@Override
	public boolean equals(Object obj) {
		
		AddressDTO other = (AddressDTO) obj;
		return Objects.equals(city, other.city) && id == other.id && Objects.equals(street, other.street);
	}
	@Override
	public String toString() {
		return "AddressDTO [id=" + id + ", street=" + street + ", city=" + city + "]\n";
	}
	

}
