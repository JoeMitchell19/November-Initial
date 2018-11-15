package com.qa.repository;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import static javax.transaction.Transactional.TxType.SUPPORTS;
import static javax.transaction.Transactional.TxType.REQUIRED;

import com.qa.account.AccountEntity;

@Transactional(SUPPORTS)
public class AccountServiceFunctionality {
	@PersistenceContext(unitName = "Primary")
	private EntityManager em;
	
	public List<AccountEntity> findAllAccounts(){
		TypedQuery<AccountEntity> query = em.createQuery("SELECT * FROM AccountEntity a ORDER BY a.id desc",AccountEntity.class);
		return query.getResultList();
	}
	public List<AccountEntity> findSpecificAccount(long searchedId){
		TypedQuery<AccountEntity> query = em.createQuery("SELECT * FROM AccountEntity a WHERE a.id = " +searchedId,AccountEntity.class);
		return query.getResultList();
	}
	
	@Transactional(REQUIRED)
	public AccountEntity createAccount(AccountEntity account) {
		em.persist(account);
		return account;
	}
	@Transactional(REQUIRED)
	public AccountEntity updateAccount(AccountEntity account) {
		long id = account.getId();
		AccountEntity updatedAccount = em.find(AccountEntity.class,id);
		updatedAccount.updateAll(account);
		em.merge(updatedAccount);
		return updatedAccount;
	}
	@Transactional(REQUIRED)
	public boolean deleteAccount(AccountEntity account) {
		em.remove(account);
		return em.contains(account);
	}

}
