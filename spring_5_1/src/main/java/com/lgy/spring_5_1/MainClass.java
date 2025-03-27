package com.lgy.spring_5_1;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lgy.spring_4_1.MyInfo;

public class MainClass
{
	public static void main(String[] args)
	{
		String configLoc = "classpath:application.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(configLoc);
		StudentInfo studentInfo = ctx.getBean("studentInfo", StudentInfo.class);
		studentInfo.getStudentInfo();
		
//		이름~반 출력
//		이름: 홍길동
//		나이: 10살
//		학년: 3학년
//		반: 2반
		
		
		//student2 : 홍길순 객체
		Student student2 = ctx.getBean("student2", Student.class);
		studentInfo.setStudent(student2);
//		이름~반 출력
//		이름: 홍길순
//		나이: 9살
//		학년: 2학년
//		반: 1반
		
		studentInfo.getStudentInfo();
		
		
		//자원반납
		ctx.close();


	}
}
