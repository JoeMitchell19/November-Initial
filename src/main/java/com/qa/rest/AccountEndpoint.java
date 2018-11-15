package com.qa.rest;


import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.qa.account.AccountEntity;
import com.qa.business.AccountInterface;


@Path("/AccountEntity")
public class AccountEndpoint {
	@Inject
	private AccountInterface accountInter;
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String findAllAccounts() {
		return accountInter.findAllAccounts();
		
	}
	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String createAccount(AccountEntity account) {
		return accountInter.createAccount(account);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(AccountEntity account) {
		return accountInter.updateAccount(account);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(AccountEntity account) {
		return accountInter.deleteAccount(account);
	}
	

}
