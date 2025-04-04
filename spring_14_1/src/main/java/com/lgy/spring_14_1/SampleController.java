package com.lgy.spring_14_1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lgy.spring_14_1.domain.MemberVO;
import com.lgy.spring_14_1.domain.SampleVO;
import com.lgy.spring_14_1.domain.TicketVO;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;


//@Controller
@RestController //pom.xml 설정이 되어야 사용가능
@RequestMapping("/sample")
@Slf4j
public class SampleController
{
//	@GetMapping(value="/getSample")
//	xml 이나 json 데이터 안나올때 추가(MediaType~)
	@GetMapping(value="/getSample", produces= {MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE,MediaType.APPLICATION_ATOM_XML_VALUE})
	public SampleVO getSample()
	{
		return new SampleVO(112,"스타","로드");
	}
	
	@GetMapping(value="/getList")
	public List<SampleVO> getList()
	{
		return IntStream.range(1, 10).mapToObj(i->new SampleVO(i, i+"First", i+"Last"))
				.collect(Collectors.toList());
	}
	
	@GetMapping(value="/getMap")
	public Map<String, SampleVO> getMap()
	{
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		return map;
	}
	
	@GetMapping(value="/check", params = {"height","weight"})
	//ResponseEntity :데이터 + http 상태코드를 전달 
	public ResponseEntity<SampleVO> check(Double height, Double weight)
	{
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		ResponseEntity<SampleVO> result = null; //값을 초기화
	
		if(height < 150)
		{
			//HttpStatus.BAD_GATEWAY : http 오류상태
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		}
		else
		{
//			HTTPStatus.OK :http 정상상태
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		return result;
	}
	
	@GetMapping(value="/product/{cat}/{pid}")
	public String[] getPath(@PathVariable("cat") String cat,@PathVariable("pid") int pid)
	{
		return new String[] {"category : " +cat, "product id : "+pid};
	}
	
	@PostMapping("/ticket")
//	public void convert(TicketVO ticketVO)
	//@RequestBody : 전송된 json 데이터를 TicketVO 타입의 객체로 변환
//	public void convert(@RequestBody TicketVO ticketVO)
	public TicketVO convert(@RequestBody TicketVO ticketVO)
	{
		//@#ticketVO => TicketVO(tno=0, owner=null, grade=null)
//		@RequestBody 추가 후, 정상출력 @# ticketVOTicketVO(tno=777, owner=gd, grade=A)
		System.out.println("@# ticketVO 1"+ticketVO);
//		@# ticketVO 1TicketVO(tno=777, owner=gd, grade=A)
		log.info("@# ticketVO 2"+ticketVO);
//		INFO : com.lgy.spring_14_1.SampleController - @# ticketVO 2TicketVO(tno=777, owner=gd, grade=A)
		return ticketVO;
	}
	
	@PostMapping("/info")
	public MemberVO convert(@RequestBody MemberVO memberVO)
	{
		log.info("@# memberVO=>"+memberVO);
		return memberVO;
	}
}
