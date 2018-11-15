package com.qa.account;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class AccountEntity {
	@Id
	private long id;
	@Column (length = 20)
	private String firstName;
	@Column (length = 30)
	private String LastName;
	@Column (length = 20)
	private long accountNumber;

	public AccountEntity() {
		
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		this.LastName = lastName;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void updateAll(AccountEntity account) {
		this.id = account.getId();
		this.firstName = account.getFirstName();
		this.LastName = account.getLastName();
		this.accountNumber = account.getAccountNumber();
		
		
	}
	

}
