package com.webank.lian.controller;

import com.webank.lian.domain.AuthorizationRecord;
import com.webank.lian.domain.User;
import com.webank.lian.service.AuthorizationRecordService;
import com.webank.lian.service.CompanyApplyRecordService;
import com.webank.lian.service.UserService;
import com.webank.lian.vo.CompanyApplyVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	CompanyApplyRecordService companyApplyRecordService;
	
	@Autowired
	AuthorizationRecordService authorizationRecordService;
	
	@RequestMapping(value = "/messages")
	public String getMessage(@RequestParam("identification") String identification,
	                         Model model) {
		
		User user = userService.getUserByIdentification(identification);
		model.addAttribute("user", user);
		
		//获取未被处理的申请（状态为0）
		List<CompanyApplyVo> applyRecords
				= companyApplyRecordService.listCompanyVoByPersonIdentificationAndStatus(identification, 0);
		for (CompanyApplyVo vo : applyRecords) {
			if (vo.getMsgType() == 0) {
				vo.setMsgTypeStr("学历");
			} else if (vo.getMsgType() == 1) {
				vo.setMsgTypeStr("银行流水");
			} else if (vo.getMsgType() == 2) {
				vo.setMsgTypeStr("户籍");
			}
		}
		
		model.addAttribute("applyRecords", applyRecords);
		return "person_xiaoxi";
	}
	
	
	@RequestMapping(value = "/agree")
	@Transactional
	@ResponseBody
	public String agreeAuthorization(@RequestParam("applyId") Integer applyId,
	                                 @RequestParam("identification") String identification) {
		//修改企业申请的状态为接受
		companyApplyRecordService.updateStatus(applyId, 2);
		
		//插入新的授权记录
		Date now = new Date();
		AuthorizationRecord a = new AuthorizationRecord(0, applyId, 1, now, identification);
		authorizationRecordService.addAuthorizationRecord(a);
		
		return "agree";
	}
	
	@RequestMapping(value = "/disagree")
	@Transactional
	@ResponseBody
	public String disagreeAuthorization(@RequestParam("applyId") Integer applyId,
	                                    @RequestParam("identification") String identification) {
		//修改企业申请的状态为拒绝
		companyApplyRecordService.updateStatus(applyId, 1);
		
		//插入新的授权记录
		Date now = new Date();
		AuthorizationRecord a = new AuthorizationRecord(0, applyId, 0, now, identification);
		authorizationRecordService.addAuthorizationRecord(a);
		
		return "disagree";
	}
	
	@RequestMapping(value = "/bankflow")
	public String getBankFlow(@RequestParam("identification") String identification,
	                          Model model) {
		User user = userService.getUserByIdentification(identification);
		model.addAttribute("user", user);
		
		
		return "yinhang";
	}
}
