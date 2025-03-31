package com.lgy.spring_11_5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller  //얘가 없으면 못찾아감

public class MyController
{
	@RequestMapping("shopping2")
	public String shopping2()
	{
		return "shopping2";
	}
}
