package com.kh.change.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kh.change.member.model.service.MemberService;
import com.kh.change.member.model.vo.Member;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {
	
	// memberService를 controller 생성시에 주입해주겠다. => @RequiredArgsConstructor
	private final MemberService memberService;
	private final BCryptPasswordEncoder passwordEncoder;
	
	@PostMapping("login.me")
	public ModelAndView login(Member member, HttpSession session, ModelAndView mv) {
		
		// 로그인 시도한 유저가 DB에 존재하는지 service를 호출하여 확인 
		Member loginUser = memberService.login(member);
		
		// 1절 만약 조회된 결과가 있다면
		// 2절 암호화된 비밀번호
		if(loginUser != null 
		   && passwordEncoder.matches(member.getUserPwd(), loginUser.getUserPwd())
		   ) {
			
			session.setAttribute("loginUser", loginUser);
			session.setAttribute("alertMsg", "로그인 성공~");
			mv.setViewName("redirect:/");
			
		} else {
			
			mv.addObject("failMsg", "로그인 실패!").setViewName("common/fail_page");
//			mv.setViewName("common/error_page"); // mv는 자기 자신을 반환하기 때문에 메소드 체이닝 가능
		}
		
		return mv;
	}
	
	@GetMapping("logout.me")
	public String logout(HttpSession session) {
		
		// logout 요청시 sessionScope에 담긴 loginUser 삭제
//		session.invalidate();
		session.removeAttribute("loginUser");
		
		// 재요청
		return "redirect:/";
	}
	
	// 요청 보내는곳 확인
	@GetMapping("join.me")
	public String joinForm() {
		return "member/enroll_form";
	}
	
	// 요청 보내는곳 확인
	@PostMapping("join.me")
	public ModelAndView insertMember(Member member, HttpSession session, ModelAndView mv) {
		// 사용자가 회원가입시 입력한 값 member
		// 화면지정할때 필요한 
		// session => alertMsg 띄워줄거임
		// mv => 회원가입 실패했을때 failMsg와 함께 메세지 전달하고 포워딩할거임
		
		// 비밀번호 암호와 작업
		String encPwd = passwordEncoder.encode(member.getUserPwd()); 
		member.setUserPwd(encPwd);
		
		int result = memberService.insertMember(member);
		
		if(result > 0) {
			session.setAttribute("alertMsg", "회원가입 성공!");
			mv.setViewName("redirect:/");
		} else {
			mv.addObject("failMsg", "회원가입 실패!!!!!!").setViewName("common/fail_page");
		}
		
		return mv;
	}
	
}
