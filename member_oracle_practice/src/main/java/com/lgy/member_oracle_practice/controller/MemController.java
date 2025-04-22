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
	
	//�α��� ȭ�� �̵�
	@RequestMapping("/login")
	public String login(Model model)
	{
		return "login";
	}
	
	//�α����� ���̵�� ��й�ȣ�� ��ġ���� üŷ�� �ؾ���.
	@RequestMapping("login_yn")
	public String write(HttpServletRequest request, Model model)
	{
		model.addAttribute("request", request);
		//�α���ó�� ���񽺰�ü ���� (MemLoginService �������̽� ����ü)
		service = new MemLoginService();
		
		//�α��� ���� �Ǵ� (���: 1=����, 0=����, -1= ���� ��)
		int result = service.excute(model);
		//�α��� ������ ���(���̵�/��й�ȣ ��ġ)
		if(result == 1)
		{
			return "redirect:login_ok";
		}
		
		//�����ϰ�� ����������� �̵�
		return "write_result";
	}
	
	//�α����
	@RequestMapping("login_ok")
	public String write_view()
	{
		return "login_ok";
	}
	
}
