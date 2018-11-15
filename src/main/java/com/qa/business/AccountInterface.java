package com.qa.business;

import com.qa.account.AccountEntity;

public interface AccountInterface {
	String findAllAccounts();
	String createAccount(AccountEntity account);
	String updateAccount(AccountEntity account);
	String deleteAccount(AccountEntity account);
	String findSpecificAccount(AccountEntity account);
}
