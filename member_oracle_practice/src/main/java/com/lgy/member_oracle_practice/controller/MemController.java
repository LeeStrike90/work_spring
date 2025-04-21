package com.lgy.member_oracle_practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController
{
	MemService service;
	@RequestMapping("/login")
	public String login(Model model)
	{
		return "login";
	}
	
}
