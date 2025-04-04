package com.lgy.spring_14_1;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.google.gson.Gson;
import com.lgy.spring_14_1.domain.TicketVO;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml"
	,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Slf4j


public class SampleControllerTests
{
	@Setter(onMethod_= {@Autowired}) // 스프링 객체로 저장해서 사용
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
	@Before
	public void setup()
	{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testConvert() throws Exception
	{
		TicketVO ticketVO = new TicketVO();
		ticketVO.setTno(123);
		ticketVO.setOwner("Admin");
		ticketVO.setGrade("B");
		
		String jsonStr = new Gson().toJson(ticketVO);
		log.info("@# jsonStr=>" +jsonStr);
		mockMvc.perform(post("/sample/ticket")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonStr)
				)
				.andExpect(status().is(200));	
	}
}
