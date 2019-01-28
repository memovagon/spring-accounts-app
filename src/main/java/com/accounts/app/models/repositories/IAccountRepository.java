package com.accounts.app.models.repositories;

import org.springframework.data.repository.CrudRepository;

import com.accounts.app.models.entity.Account;


/**
 *  @Repository AutorizationServerConfig Interface
 *   Accounts repository for CRUD operations.  
 */

public interface IAccountRepository extends CrudRepository<Account, Long> {

			
}
