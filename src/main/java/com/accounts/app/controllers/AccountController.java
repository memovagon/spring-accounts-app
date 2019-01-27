package com.accounts.app.controllers;

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

@Controller
@SessionAttributes("account")
public class AccountController {

	@Autowired
	private IAccountService accountService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listAccounts(Model model) {

		model.addAttribute("title", "Account List");
		model.addAttribute("accounts", accountService.findAll());
		return "list_accounts";
	}

	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String formAccount(Map<String, Object> model) {

		Account account = new Account();

		model.put("title", "Account Form");
		model.put("account", account);

		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String saveAccount(Account account, SessionStatus status) {

		accountService.save(account);
        status.setComplete();
		return "redirect:list";
	}

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

	@RequestMapping(value = "/delete/{id}")
	public String deleteAccount(@PathVariable(value = "id") Long id) {

		if (id > 0)
			accountService.delete(id);

		return "redirect:/list";
	}

}
