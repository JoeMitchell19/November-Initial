package com.qa.account;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AccountEntity {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column (length = 20)
	private String firstName;
	@Column (length = 30)
	private String LastName;
	@Column (length = 20)
	private long accountNumber;
	

}
