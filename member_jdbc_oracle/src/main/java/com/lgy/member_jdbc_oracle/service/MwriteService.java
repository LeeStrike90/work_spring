package com.lgy.member_jdbc_oracle.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.lgy.member_jdbc_oracle.dao.MemDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MwriteService implements MemService
{

	@Override
	public int execute(Model model)
	{
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String mem_uid = request.getParameter("mem_uid");
		String mem_pwd = request.getParameter("mem_pwd");
		String mem_name = request.getParameter("mem_name");

		log.info("@# mem_uid=>" + mem_uid);
		log.info("@# mem_pwd=>" + mem_pwd);
		log.info("@# mem_name=>" + mem_name);

		MemDAO dao = new MemDAO();
		dao.write(mem_uid, mem_pwd, mem_name);

		return 0;
	}

}
