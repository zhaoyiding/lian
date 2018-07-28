package com.webank.lian.controller;

import com.webank.lian.domain.BankStatement;
import com.webank.lian.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/bank")
public class BankController {
	
	@Autowired
	BankService bankService;

	@RequestMapping(value = "/statements")
	public String getBankStatement(@RequestParam("personIdentification") String identification,@RequestParam("bankName") String bankName,
	                         Model model) {
		System.out.print(identification+bankName);

		List<BankStatement> bankStatements
				= bankService.getBankStatement(identification,bankName);

		model.addAttribute("bankStatements", bankStatements);

		System.out.print(bankStatements);
		return "yinhang";
	}

}
