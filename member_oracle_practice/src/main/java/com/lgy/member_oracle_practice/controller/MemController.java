package com.lgy.member_oracle_practice.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.member_oracle_practice.service.MemLoginService;
import com.lgy.member_oracle_practice.service.MemService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController
{
	MemService service;
	
	//로그인 화면 이동
	@RequestMapping("/login")
	public String login(Model model)
	{
		return "login";
	}
	
	//로그인은 아이디와 비밀번호가 일치한지 체킹을 해야함.
	@RequestMapping("login_yn")
	public String write(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		//로그인처리 서비스객체 생성 (MemLoginService 인터페이스 구현체)
		service = new MemLoginService();
		
		//로그인 여부 판단 (결과: 1=성공, 0=실패, -1= 오류 등)
		int result = service.excute(model);
		//로그인 성공일 경우(아이디/비밀번호 일치)
		if(result == 1)
		{
			return "redirect:login_ok";
		}
		
		//실패일경우 결과페이지로 이동
		return "write_result";
	}
	
	//로그출력
	@RequestMapping("login_ok")
	public String write_view()
	{
		return "login_ok";
	}
	
}
