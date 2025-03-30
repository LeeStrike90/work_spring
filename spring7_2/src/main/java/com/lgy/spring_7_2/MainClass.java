package com.lgy.spring_7_2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass
{
	public static void main(String[] args)
	{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:applicationCTX.xml");
		
//		applicationCTX.xml 에서 , namespace->context 를 켜니, 나머지도 다 출력되었다.
		
//		refresh를 먹이니까, 어노테이션 두개가 나타났다.
//		@# afterPropertiesSet()
//		@# destroy()
		ctx.refresh();
//		INFO : org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loading XML bean definitions from class path resource [applicationCTX.xml]
		ctx.close();
		
//		최종순서
//		@# afterPropertiesSet()
//		@# initMethod()
//		@# destroyMethod()
//		@# destroy()

	}
}
