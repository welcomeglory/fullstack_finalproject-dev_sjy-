package com.kakao.app;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private KakaoAPI kakaoApi = new KakaoAPI();

    @GetMapping("/login")
    public String login(@RequestParam("code") String code, HttpSession session, Model model) {
        String accessToken = kakaoApi.getAccessToken(code);
        HashMap<String, Object> userInfo = kakaoApi.getUserInfo(accessToken);

        if (userInfo.get("email") != null) {
            session.setAttribute("userId", userInfo.get("email"));
            session.setAttribute("accessToken", accessToken);
            model.addAttribute("userId", userInfo.get("email"));
        }

        return "redirect:/index";  // 로그인 후 홈 페이지로 리디렉션
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        String accessToken = (String) session.getAttribute("accessToken");
        if (accessToken != null) {
            kakaoApi.kakaoLogout(accessToken);
            session.removeAttribute("accessToken");
            session.removeAttribute("userId");
        }
        return "redirect:/index";  // 로그아웃 후 홈 페이지로 리디렉션
    }

    @GetMapping("/index")
    public String home(Model model, HttpSession session) {
        String userId = (String) session.getAttribute("userId");
        model.addAttribute("userId", userId);
        return "index";  // home.html 페이지로 이동
    }    
//    
//    @Autowired
//	private KakaoService kakaoService ;
//	
//
//	@RequestMapping(value = "/kakao")
//	public String kakaoLogin(@RequestParam("code") String code,Model model ,HttpSession session) throws Exception {
//		
//		//code로 토큰 받음
//		String access_token = kakaoService.getToken(code);
//		
//		//토큰으로 사용자 정보 담은 list 가져오기
//		ArrayList<Object> list = kakaoService.getUserInfo(access_token);
//		
//		//list 모델에 담아 view로 넘김
//		model.addAttribute("list", list);
//	
//		return "userInfo";
//	} 
}
