package com.study.servlet.cookie;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookie/1")
public class Cookie1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookie = new Cookie("data1", "쿠키저장"); // key와 value로 구성됨
		cookie.setMaxAge(60 * 60); // 1시간. 1 -> 1초		
		
		Cookie cookie2 = new Cookie("data2", URLEncoder.encode("데이터 하나 더 추가!!", StandardCharsets.UTF_8));
		cookie2.setMaxAge(60 * 60);
		
		response.addCookie(cookie); // 매개변수로 cookie 객체를 받을 수 있음
		response.addCookie(cookie2);
	}


}
