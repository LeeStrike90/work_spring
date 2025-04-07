package com.lgy.member_jdbc_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.member_jdbc_oracle.service.MWriteService;
import com.lgy.member_jdbc_oracle.service.MemLoginService;
import com.lgy.member_jdbc_oracle.service.MemService;
import com.lgy.member_jdbc_oracle.util.Constant;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController {
	MemService service;
	public JdbcTemplate template;
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}
	
//	로그인 화면 이동
	@RequestMapping("/login")
	public String login(Model model) {
		log.info("@# login()");
		
		return "login";
	}
	
//	로그인화면->로그인 여부 판단
	@RequestMapping("/login_yn")
	public String loginYn(HttpServletRequest request, Model model) {
		log.info("@# loginYn()");
		
		model.addAttribute("request", request);
		
		service=new MemLoginService();
		int result = service.execute(model);
		
//		아이디와 비밀번호가 일치
		if (result == 1) {
			return "redirect:login_ok";
		}
		return "redirect:login";
	}
	
//	로그인 성공시 이동
	@RequestMapping("/login_ok")
	public String login_ok() {
		log.info("@# login_ok()");
		
		return "login_ok";
	}
	
	@RequestMapping("/register")
	public String register() {
		log.info("@# register()");
		
		return "register";
	}
	
	@RequestMapping("/registerOk")
	public String registerOk(HttpServletRequest request, Model model) {
		log.info("@# registerOk()");

		model.addAttribute("request", request);
		
		service=new MWriteService();
		service.execute(model);
		
		return "redirect:login";
	}
	
}









