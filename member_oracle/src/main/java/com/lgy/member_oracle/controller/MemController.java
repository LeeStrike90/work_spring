package com.lgy.member_oracle.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lgy.member_oracle.service.MemLoginService;
import com.lgy.member_oracle.service.MemService;

import lombok.extern.slf4j.Slf4j;

@Controller // 이 클래스가 Spring MVC의 컨트롤러 역할을 한다는 것을 알려주는 어노테이션
@Slf4j      // 로그를 출력하기 위한 Lombok 어노테이션 (log.info() 등 사용 가능)
public class MemController {

	// 로그인 처리를 위한 서비스 인터페이스 (실제 구현체는 MemLoginService)
	MemService service;

	/**
	 * 로그인 페이지로 이동하는 메서드
	 * 사용자가 브라우저에서 /login 주소로 접근하면 이 메서드가 실행됨
	 * 
	 * @param model JSP로 데이터 전달 시 사용되는 객체
	 * @return 로그인 JSP 페이지 이름 (뷰 이름)
	 */
	@RequestMapping("/login") // 주소창에 /login으로 접근하면 이 메서드가 실행됨
	public String login(Model model) {
		log.info("@# login()"); // 서버 로그에 기록 (디버깅용)
		return "login";         // /WEB-INF/views/login.jsp 로 이동 (기본 prefix/suffix 기준)
	}

	/**
	 * 로그인 버튼 클릭 시, 아이디/비밀번호 일치 여부를 판단하는 메서드
	 * form에서 POST로 넘긴 데이터(HttpServletRequest)를 기반으로 로그인 검증 수행
	 * 
	 * @param request 사용자가 보낸 로그인 정보가 담긴 요청 객체
	 * @param model 모델 객체를 통해 request를 서비스 쪽으로 전달
	 * @return 로그인 성공 시 login_ok.jsp로 리다이렉트, 실패 시 write_result.jsp로 이동
	 */
	@RequestMapping("/login_yn") // login.jsp에서 로그인 시도 시 이 메서드가 실행됨
	public String write(HttpServletRequest request, Model model) {
		log.info("@# loginyn()"); // 로그 출력 (로그인 시도 확인)

		// 사용자 요청(request 객체)를 model에 담아서 서비스로 전달
		model.addAttribute("request", request);

		// 로그인 처리 서비스 객체 생성 (MemService 인터페이스 구현체)
		service = new MemLoginService();

		// 로그인 여부 판단 (결과: 1=성공, 0=실패, -1=오류 등)
		int result = service.excute(model);

		// 로그인 성공일 경우 (아이디/비밀번호 일치)
		if (result == 1) {
			// login_ok라는 주소로 리다이렉트 (화면 이동)
			return "redirect:login_ok";
		}

		// 로그인 실패 시 실패 결과 페이지로 이동
		return "write_result";
	}

	/**
	 * 로그인 성공 후 보여줄 페이지로 이동하는 메서드
	 * 
	 * @return 로그인 성공 화면(login_ok.jsp)
	 */
	@RequestMapping("/login_ok") // 위에서 redirect된 login_ok 주소 처리
	public String write_view() {
		log.info("@# login_ok()"); // 로그 출력 (성공 시)
		return "login_ok";         // /WEB-INF/views/login_ok.jsp로 이동
	}
}
