package com.qa.business;

import javax.inject.Inject;

import com.qa.account.AccountEntity;
import com.qa.repository.AccountService;

public class AccountInterfaceImp implements AccountInterface{
	@Inject
	private AccountService repo;
	
	public String findAllAccounts(){
		return repo.findAllAccounts();
	}
	public String createAccount(AccountEntity account) {
		return repo.createAccount(account);
	}
	public String updateAccount(AccountEntity account) {
		return repo.updateAccount(account);
	}
	public String deleteAccount(AccountEntity account) {
		return repo.deleteAccount(account);
	}
	@Override
	public String findSpecificAccount(AccountEntity account) {
		return repo.findSpecificAccount(account);
	}
	


}

