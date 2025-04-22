package com.lgy.member_oracle.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lgy.member_oracle.dao.MemDAO;

@Service  // 이 클래스가 서비스 역할임을 Spring에게 알려주는 어노테이션 (자동 등록됨)
public class MemLoginService implements MemService
{
	/**
	 * 로그인 처리를 위한 메서드
	 * 컨트롤러에서 넘긴 model 안에 들어 있는 request 객체로부터 사용자 입력값을 꺼내서
	 * DAO를 통해 DB에 로그인 여부를 확인한 후, 결과(int)를 반환
	 *
	 * @param model JSP에서 넘겨받은 사용자 입력값(HttpServletRequest 포함)
	 * @return 로그인 성공 여부를 int로 반환 (1: 성공, 0: 비번 틀림, -1: 아이디 없음)
	 */
	@Override
	public int excute(Model model)
	{
		// model 안에 있는 값들을 Map 형식으로 변환
		Map<String, Object> map = model.asMap();

		// model에 담겨있던 request 객체를 꺼내서 사용 (컨트롤러에서 addAttribute로 넘김)
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		// 사용자로부터 입력받은 아이디와 비밀번호를 가져옴
		String mId = request.getParameter("mem_uid");  // 폼 name="mem_uid"
		String mPw = request.getParameter("mem_pwd");  // 폼 name="mem_pwd"

		// DB 작업을 위해 DAO 객체 생성
		MemDAO dao = new MemDAO();

		// DAO의 loginYn() 메서드를 호출하여 로그인 여부 확인
		// 결과는 1(성공), 0(비밀번호 틀림), -1(아이디 없음)
		int re = dao.loginYn(mId, mPw);

		// 컨트롤러에 결과값 전달
		return re;
	}
}
