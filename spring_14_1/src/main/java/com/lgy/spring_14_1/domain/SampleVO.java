package com.lgy.spring_14_1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter //게터
//@Setter// 세터
@NoArgsConstructor //기본생성자
@AllArgsConstructor //모든 프로퍼티를 파라미터로 가지는 생성자
@Data //여러가지 메소드를 포함
public class SampleVO
{
	private int mno;
	private String firstName;
	private String lastName;

	
	/*
	public SampleVO(int mno, String firstName, String lastName)
	{
		super();
		this.mno = mno;
		this.firstName = firstName;
		this.lastName = lastName;
	}
*/	
	
	/*//기본생성자
	public SampleVO()
	{
		// TODO Auto-generated constructor stub
	}
	*/
	/*
	
	public int getMno()
	{
		return mno;
	}
	public void setMno(int mno)
	{
		this.mno = mno;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	 */
}