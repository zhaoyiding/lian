package com.webank.lian.service;

import com.webank.lian.dao.BankStatementDao;
import com.webank.lian.domain.BankStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {
	
	@Autowired
	BankStatementDao bankStatementDao;

	public List<BankStatement> getBankStatement(
			String personIdentification,String bankName) {
		return bankStatementDao.getBankStatement(personIdentification,bankName);
	}
}
