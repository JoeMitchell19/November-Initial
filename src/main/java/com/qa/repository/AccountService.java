package com.qa.repository;

import com.qa.account.AccountEntity;

public interface AccountService {
	String findAllAccounts();
	String createAccount(AccountEntity account);
	String updateAccount(AccountEntity account);
	String deleteAccount(AccountEntity account);

}
