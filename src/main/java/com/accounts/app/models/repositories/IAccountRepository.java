package com.accounts.app.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.accounts.app.models.entity.Account;

public interface IAccountRepository extends CrudRepository<Account, Long> {

			
}
