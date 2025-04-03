package com.lgy.item_oracle.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data // 게터 , 세터 + @ 개념으로
@AllArgsConstructor //생성자 모두 만드는 신선한 기술

public class ItemDTO
{
	private String name;
	private int Price;
	private String description;
}
