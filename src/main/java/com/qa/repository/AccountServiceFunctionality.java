package com.qa.repository;


import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

import com.qa.account.AccountEntity;
import com.qa.util.JSONConversion;



@Default
@Transactional(SUPPORTS)
public class AccountServiceFunctionality implements AccountService {
	@PersistenceContext(unitName = "Primary")
	private EntityManager em;
	
	
	public String findAllAccounts(){
		TypedQuery<AccountEntity> query = em.createQuery("SELECT * FROM AccountEntity a ORDER BY a.id desc",AccountEntity.class);
		return JSONConversion.getJSONFromObject(query.getResultList());
	}
	public String findSpecificAccount(AccountEntity account){
		long searchedId = account.getId();
		TypedQuery<AccountEntity> query = em.createQuery("SELECT * FROM AccountEntity a WHERE a.id = " +searchedId,AccountEntity.class);
		return JSONConversion.getJSONFromObject(query.getResultList());
	}
	
	@Transactional(REQUIRED)
	public String createAccount(AccountEntity account) {
		em.persist(account);
		if(account.getAccountNumber() == 9999) {
			return "{\"message\": \"This Account is Blocked\"}";
		}
		else {
		return "{\"message\": \"new Account created successfully\"}";
	}
	}
	@Transactional(REQUIRED)
	public String updateAccount(AccountEntity account) {
		long id = account.getId();
		AccountEntity updatedAccount = em.find(AccountEntity.class,id);
		updatedAccount.updateAll(account);
		em.merge(updatedAccount);
		return "{\"message\": \"Account has been updated successfully\"}";
	}
	@Transactional(REQUIRED)
	public String deleteAccount(AccountEntity account) {
		em.remove(account);
		em.contains(account);
		return "{\"message\": \"Account has been deleted successfully\"}"; 
	}
	

}
