package com.lgy.spring_5_2;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class MainClass
{
	public static void main(String[] args)
	{
		String configLoc = "application.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
/*		Pencil6BWithEraser pencil1 = ctx.getBean("pencil1", Pencil6BWithEraser.class);
		
//		6B이고,지우개가 있습니다.
//		6B 입니다.
//		4B 입니다.
		
		pencil1.use();
		Pencil6B pencil2 = ctx.getBean("pencil2", Pencil6B.class);
		pencil2.use();
		Pencil4B pencil3 = ctx.getBean("pencil3", Pencil4B.class);
		pencil3.use();
*/
		
//		Pencil.class : 인터페이스도 사용가능(참조변수는 인터페이스로 받으면 됨)
		Pencil pencil1 = ctx.getBean("pencil1", Pencil.class);
//		use(): 오버라이딩한 메소드 호출
//		6B이고, 지우개가 있습니다.
		pencil1.use();
		
		
		//6B입니다.
		Pencil pencil2 = ctx.getBean("pencil2", Pencil.class);
		pencil2.use();
		
		//4B입니다.
		Pencil pencil3 = ctx.getBean("pencil3", Pencil.class);
		pencil3.use();
		
		
		
		//자원반납
		ctx.close();

	}
}
