package com.accounts.app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.accounts.app.models.entity.Account;
import com.accounts.app.models.service.IAccountService;

@RestController
@RequestMapping("/api")
public class AccountRestController {

	@Autowired
	private IAccountService accountService;

	@RequestMapping(value = "/accounts/", method = RequestMethod.GET)
	public List<Account> listAccounts() {
		return accountService.findAll();

	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
	public Account listAccount(@PathVariable(value = "id") Long id) {
		return accountService.getById(id);

	}

	//API Request POST - Create Accounts
	@RequestMapping(value = "/accounts", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public Account save(@RequestBody Account account) {

		 return accountService.save(account);

	}
	
	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public Account udpate(@RequestBody Account account, @PathVariable(value = "id") Long id ) {

		 Account accountTemp = accountService.getById(id);
		 accountTemp.setAccount(account.getAccount());
		 accountTemp.setAccount(account.getBeneficiary());
		 return accountService.save(accountTemp);

	}
	

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable(value = "id") Long id) {

		if (id > 0)
			accountService.delete(id);

	}

}
