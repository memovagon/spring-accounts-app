package com.accounts.app.models.service;

import java.util.List;
import java.util.Optional;

import com.accounts.app.models.entity.Account;

public interface IAccountService {
	
	public List<Account> findAll();
	
	public Account save(Account account);
	
	public Optional<Account> getById(Long id);
	
	public void delete(Long id);

}
