package com.lgy.spring_12_1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/board/confirmId")
//	public String confirmId(HttHttpServletRequest httpServletRequest, Model model)
	public String confirmId(HttpServletRequest httpServletRequest, Model model)
	{
		String id =	httpServletRequest.getParameter("id");
		String pw =	httpServletRequest.getParameter("pw");
		//getparameter로 받는경우 쿼리스트링이 없을때 아무것도 안뜸. 
		//@requestParam 으로 받는경우 쿼리스트링 없으면 오류
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "board/confirmId";
	}
	
}
