package com.lgy.member_jdbc_oracle.contoroller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.member_jdbc_oracle.service.MemLoginService;
import com.lgy.member_jdbc_oracle.service.MemService;
import com.lgy.member_jdbc_oracle.service.MwriteService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MemController {

	MemService service;
	public JdbcTemplate template;

//	濡쒓렇�씤 �솕硫� �씠�룞
	@RequestMapping("/login")
	public String login(Model model) {
		log.info("@# login()");

		return "login";
	}

// 濡쒓렇�씤 �솕硫� => 濡쒓렇�씤 �뿬遺� �뙋�떒 
	@RequestMapping("/login_yn")
	public String write(HttpServletRequest request, Model model) {
		log.info("@# loginyn()");

		model.addAttribute("request", request);

		service = new MemLoginService();
		int result = service.execute(model);

//		�븘�씠�뵒�� 鍮꾨�踰덊샇媛� �씪移�
		if (result == 1) {
			return "redirect:login_ok";
		}

		return "write_result";
	}

	@RequestMapping("/login_ok")
	public String write_view() {
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

		service = new MwriteService();
		service.execute(model);

		return "redirect:login";
	}
}
