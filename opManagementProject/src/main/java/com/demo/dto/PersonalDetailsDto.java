package com.demo.dto;

import java.util.Date;

public class PersonalDetailsDto {
	private int pdId;
    private String name;
    private String email;
    private String street;
    private Date createdAt;
    private Date updatedAt;
	public int getPdId() {
		return pdId;
	}
	public void setPdId(int Id) {
		pdId = Id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@Override
	public String toString() {
		return "PersonalDetailsDto [PdId=" + pdId + ", name=" + name + ", email=" + email + ", street=" + street
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	



}
