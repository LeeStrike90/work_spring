package com.lgy.spring_14_1.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO
{
	private String id;
	private String name;
	private String phone;
	private String address;
	
}
