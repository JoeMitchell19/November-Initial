package com.qa.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;

import com.qa.util.JSONConversion;

import com.qa.account.AccountEntity;

@ApplicationScoped
@Alternative
public class AccountServiceMap implements AccountService {
	private HashMap<Long,AccountEntity> hmap = new HashMap<Long,AccountEntity>();
	

	@Override
	public String findAllAccounts() {
		List<AccountEntity> results = new ArrayList<AccountEntity>(hmap.values()); 
		return JSONConversion.getJSONFromObject(results);
	}

	@Override
	public String createAccount(AccountEntity account) {
		hmap.put(account.getId(),account);
		return JSONConversion.getJSONFromObject(account);
	}

	@Override
	public String updateAccount(AccountEntity account) {
		hmap.put(account.getId(), account);
		return JSONConversion.getJSONFromObject(account);
	}

	@Override
	public String deleteAccount(AccountEntity account) {
		hmap.remove(account.getId(), account);
		if(hmap.containsValue(account)){
			System.out.println("Account has not been deleted");
			return "{\"message\": \"Account has not been deleted\"}";
		}
		else {
			System.out.println("Account has been deleted");
			return "{\"message\": \"Account has been deleted successfully\"}";
		}
	}
	public void initialiseMap() {
		AccountEntity ae = new AccountEntity();
		ae.setId(1);
		ae.setFirstName("Joe");
		ae.setLastName("Mitchell");
		ae.setAccountNumber(1);
	}

	@Override
	public String findSpecificAccount(AccountEntity account) {
		long searchedId = account.getId();
		hmap.put(searchedId, account);
		return JSONConversion.getJSONFromObject(hmap.put(searchedId, account));
	}

}
