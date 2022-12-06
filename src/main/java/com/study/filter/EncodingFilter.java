package com.study.filter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class EncodingFilter extends HttpFilter implements Filter {
       
	private static final long serialVersionUID = 1L;

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//다운캐스팅하여 getMethod 사용 가능
		HttpServletRequest hsr = (HttpServletRequest) request;
		
//		System.out.println(hsr.getMethod());
		if(hsr.getMethod().equalsIgnoreCase("POST")) { //문자열을 대소문자 구분 없이 비교
//			request.setCharacterEncoding("UTF-8");
			request.setCharacterEncoding(StandardCharsets.UTF_8.name()); // post마다 인코딩을 안해도 됨
			
		}
		//전처리
		chain.doFilter(request, response); //실행되면 servlet이 실행됨
		//후처리
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
