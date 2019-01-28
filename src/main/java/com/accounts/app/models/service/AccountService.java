package com.accounts.app.models.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounts.app.models.entity.Account;
import com.accounts.app.models.repositories.IAccountRepository;

/**
 *  @Service AccountService class
 *  The AccountService class provide service layer implementation for Accounts.
 */

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository accountDao;

	@Override
	@Transactional(readOnly = true)
	public List<Account> findAll() {
		return (List<Account>) accountDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Account> getById(Long id) {
		return accountDao.findById(id);
	}

	@Override
	@Transactional
	public Account save(Account account) {
		return accountDao.save(account);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		accountDao.deleteById(id);

	}

}
