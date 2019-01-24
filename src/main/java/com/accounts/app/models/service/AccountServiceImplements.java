package com.accounts.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accounts.app.models.dao.IAccountDao;
import com.accounts.app.models.entity.Account;

@Service
public class AccountServiceImplements implements IAccountService {

	@Autowired
	private IAccountDao accountDao;

	@Override
	@Transactional(readOnly = true)
	public List<Account> findAll() {
		return (List<Account>) accountDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Account getById(Long id) {
		return accountDao.findById(id).get();
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
