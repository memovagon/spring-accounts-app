package com.accounts.app.controllers;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.accounts.app.models.entity.Account;
import com.accounts.app.models.service.IAccountService;

/**
 *  @Controller AccountController Class
 *  The AccountController Class is used to control Account GUI interface
 */

@Controller
@SessionAttributes("account")
public class AccountController {

	@Autowired
	private IAccountService accountService;

	//List available accounts 
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAccounts(Model model) {

		model.addAttribute("title", "Account List");
		model.addAttribute("accounts", accountService.findAll());
		return "list_accounts";
	}

	//Load Account into Form
	@RequestMapping(value = "/form/{id}")
	public String editAccount(@PathVariable(value = "id") Long id, Map<String, Object> model) {

		Account account = null;

		if (id > 0)
			account = accountService.getById(id).get();
		else
			return "redirect:list";

		model.put("title", "Edit Account");
		model.put("account", account);
		return "form";
	}
	
	//New empty account form
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String formAccount(Map<String, Object> model) {

		Account account = new Account();

		model.put("title", "Account Form");
		model.put("account", account);

		return "form";
	}
    
	//Store account into DB
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String saveAccount(Account account, SessionStatus status) {

		if(account.getId() != null)
			account.setUpdatedTimestamp(new Date());
		accountService.save(account);
        status.setComplete();
		return "redirect:list";
	}


	//Delete provided account
	@RequestMapping(value = "/delete/{id}")
	public String deleteAccount(@PathVariable(value = "id") Long id) {

		if (id > 0)
			accountService.delete(id);

		return "redirect:/list";
	}

}
