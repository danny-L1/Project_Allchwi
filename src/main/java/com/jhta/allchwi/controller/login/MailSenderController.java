package com.jhta.allchwi.controller.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jhta.allchwi.service.login.MailSenderService;
import com.jhta.allchwi.vo.login.MemberLoginVO;

@Controller
public class MailSenderController {
	@Autowired
	private MailSenderService mailSender;
	
	// 비밀번호찾기 페이지 이동
	@GetMapping("/login/searchPwd")
	public String goSearchPwd() {
		return ".login.searchPwd";
	}
	// 비밀번호 찾기 페이지에서 메일 보낸 뒤 메인으로   
	@RequestMapping(value = "/login/searchPwd", method = RequestMethod.POST)
	public String searchPwdEmail(MemberLoginVO mlv, String sendEmail, Model model, HttpServletRequest req) {		
		// 인증 메일 보내기 메서드
		mailSender.mailSendWithpassword(mlv, sendEmail, model, req);
		//메일보내고 메인으로 
		return "redirect:/";
	}
}
