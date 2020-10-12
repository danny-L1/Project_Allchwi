package com.jhta.allchwi.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jhta.allchwi.service.login.KakaoLoginService;
import com.jhta.allchwi.service.login.MemberLoginService;

@Controller
public class LogoutController {
	@Autowired
	private MemberLoginService mls;
	// else문 아래 dead코드 없애기 위해 선언
	@SuppressWarnings("unused")
	// 로그인후 드롭바에서 로그아웃 눌렀을경우 호출
	@RequestMapping(value = "/login/logout")
	public String logout(HttpSession session) {
		//a 카카오 회원일 경우 세션에 담긴 access token 확인 후
		String access_Token = (String)session.getAttribute("access_Token");
		//a 토큰 값 존재할 경우 아래 경로로 리다이렉트 이동하여 카카오서버에서 계정 나가기 후 로그아웃 리다이렉트 uri로 이동
		if(access_Token != null) {
			System.out.println("카카오 맞다.");
			String client_id = "4f883a7141cac9d993029eba73513c89";
			//기존 본인 서버 실행시
			//String logout_redirect_uri = "http://localhost:8091/login/kakaologout";
			//규진이 서버 실행시
			//String logout_redirect_uri = "http://192.168.0.29:8091/login/kakaologout";
			//나스
			//String logout_redirect_uri = "http://pakye.synology.me:7070/login/kakaologout";
			//도메인
			String logout_redirect_uri = "http://www.allchwi.com/login/kakaologout";
			String path = "https://kauth.kakao.com/oauth/logout?client_id="+ client_id + "&logout_redirect_uri=" + logout_redirect_uri + "&state=?";
			return "redirect:" + path;
		} else {
			System.out.println("카카오 아니다.");
			//a 올취에서 가입한 회원인경우 
			mls.logout(session);    
			return "redirect:/";
		}
	}
	//a 카카오 서버에서 넘어오는 로그아웃 리다이렉트 uri를 받아서 아래 세션값들을 무효화하여 로그아웃
	@RequestMapping(value="/login/kakaologout")
	public String kakaologout(HttpSession session) {
	    session.removeAttribute("access_Token");
	    session.removeAttribute("ml_num");
	    session.removeAttribute("tutor_auth");
	    session.invalidate();
	    return "redirect:/";
	}
}
