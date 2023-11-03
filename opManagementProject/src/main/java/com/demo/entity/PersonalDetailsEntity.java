package com.demo.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Personal_details")
@EntityListeners(AuditingEntityListener.class)
@NamedQueries({@NamedQuery (name = "PersonalDetailsEntity.findAllByDesc" , query = "select a from PersonalDetailsEntity a ORDER BY a.name DESC")})
public class PersonalDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pdId;
    
   
    @Column(unique=true,name = "pd_name")
    private String name;
    
    @JsonManagedReference
    @OneToMany(fetch = FetchType.EAGER	,cascade = CascadeType.ALL,mappedBy = "ent")
    private List<OutPatientEntity> op;
    
    @Column(name="email")
    private String email;
    
    
    @Column(name="street")
    private String street;
    
   
  
    
    
    @Column(nullable = false,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;
    
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
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




	public List<OutPatientEntity> getOp() {
		return op;
	}




	public void setOp(List<OutPatientEntity> op) {
		this.op = op;
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
		return "PdEntity [id ="+pdId + ", name=" + name + ", email=" + email + ", op="+op+", street=" + street
				+  ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}




	
    
    
    
    
}

