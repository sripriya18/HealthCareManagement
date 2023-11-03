package com.demo.entity;


import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

	@Entity
	@Table
	@EntityListeners(AuditingEntityListener.class)
	public class OutPatientEntity {
		
		 @Id
	     @GeneratedValue(strategy = GenerationType.IDENTITY)
	     private int opId;
	     
	     @Column(name="Op_Name")
	     private String OpName;
	     
	    
	     
	 	
	 	@Column(unique=true,name="contact_number")
	 	
	 	private long contactNumber;
	 	
	 	
	 	
	 	
	 	@Column(nullable=false,updatable=false)
	 	@CreatedDate
	 	@Temporal(TemporalType.TIMESTAMP)
	 	private Date createdAT;
	 	
	 	
	 	@Column(nullable=false,updatable=false)
	 	@LastModifiedDate
	 	@Temporal(TemporalType.TIMESTAMP)
	 	private Date updatedAT;
	 	
	     @JsonBackReference
	     @ManyToOne(fetch = FetchType.EAGER)
	     @JoinColumn(name = "pd_id",nullable = false,referencedColumnName = "PdId")
	     PersonalDetailsEntity ent;
	     
	     

	    


		public int getOpId() {
			return opId;
		}






		public void setOpId(int Id) {
			opId = Id;
		}






		public String getOpName() {
			return OpName;
		}






		public void setOpName(String opName) {
			OpName = opName;
		}











		public long getContactNumber() {
			return contactNumber;
		}






		public void setContactNumber(long contactNumber) {
			this.contactNumber = contactNumber;
		}






	






		public Date getCreatedAT() {
			return createdAT;
		}






		public void setCreatedAT(Date createdAT) {
			this.createdAT = createdAT;
		}






		public Date getUpdatedAT() {
			return updatedAT;
		}






		public void setUpdatedAT(Date updatedAT) {
			this.updatedAT = updatedAT;
		}






		public PersonalDetailsEntity getEnt() {
			return ent;
		}






		public void setEnt(PersonalDetailsEntity ent) {
			this.ent = ent;
		}






		@Override
		public String toString() {
			return "OpEntity [OpId=" + opId + ", OpName=" + OpName + ", contactNumber=" + contactNumber + ", createdAT=" + createdAT + ", updatedAT=" + updatedAT + "]";
		}
	}






		






		
