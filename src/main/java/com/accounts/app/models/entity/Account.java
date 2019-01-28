package com.accounts.app.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *  @Entity Accounts class
 *  The Account class links with Accounts Table 
 *  This is used to store Account information
 */

@Entity
@Table(name = "accounts")
public class Account implements Serializable {


	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String account;
	private String beneficiary;

	@Column(name = "created_timestamp")
	@Temporal(TemporalType.DATE)
	private Date createdTimestamp;

	@Column(name = "updated_timestamp")
	@Temporal(TemporalType.DATE)
	private Date updatedTimestamp;

	//Define timestamp before creating record 
	@PrePersist
	public void prePersist() {
		createdTimestamp = new Date();
	}
	
	//Define timestamp before updating record 
	@PreUpdate
	public void preUpdate() {
		updatedTimestamp = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(String beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

}
