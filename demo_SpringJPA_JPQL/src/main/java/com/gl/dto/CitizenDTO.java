package com.gl.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;

public class CitizenDTO {
	
	private int id;
	private LocalDate dob;
	private String name;
	private String address;
	private String emailId;
	private String gender;
	private String mobileNo;
	public CitizenDTO() {
		// TODO Auto-generated constructor stub
	}
	public CitizenDTO(int id, LocalDate dob, String name, String address, String emailId, String gender,
			String mobileNo) {
		super();
		this.id = id;
		this.dob = dob;
		this.name = name;
		this.address = address;
		this.emailId = emailId;
		this.gender = gender;
		this.mobileNo = mobileNo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, dob, emailId, gender, id, mobileNo, name);
	}
	@Override
	public boolean equals(Object obj) {
		
		CitizenDTO other = (CitizenDTO) obj;
		return Objects.equals(address, other.address) && Objects.equals(dob, other.dob)
				&& Objects.equals(emailId, other.emailId) && Objects.equals(gender, other.gender) && id == other.id
				&& Objects.equals(mobileNo, other.mobileNo) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "CitizenDTO [id=" + id + ", dob=" + dob + ", name=" + name + ", address=" + address + ", emailId="
				+ emailId + ", gender=" + gender + ", mobileNo=" + mobileNo + "]\n";
	}
	
	

}
