package com.accounts.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.accounts.app.models.entity.Account;

public interface IAccountDao extends CrudRepository<Account, Long> {

			
}
