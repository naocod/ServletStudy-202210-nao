package com.study.servlet.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session/1")
public class Session1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); // session 객체 필요해서 사용
		
		 //1. 세션 객체를 가져옴 > 데이터가 없으니 null 값이 뜸
		// 2. RequestDispatcher를 통해 html을 띄움
		// 3. 데이터 전송을 누르면 post요청 되어있는 session 가져옴
		// 4. form안에 들어있는 getParameter 가져옴
		// 5. session 저장소에다가 setAttribute 함. key-value 하여 저장함
		// 6. 새로 요청을 보내도 session이 살아있기에 session 안에 있는 값들을 get하기 때문에 같은 값을 불러옴
		// > 브라우저가 닫히기 전까지 페이지를 계속 고치더라도 session 안의 값은 동일 함
		//요청 안에서만 쓸 수 있는건 request???
		System.out.println(session.getAttribute("user_name")); // 키 값 가져와서 출력
		System.out.println(session.getAttribute("user_phone")); // 브라우저를 닫고 새로 열면 세션 초기화 됨 
		System.out.println(session.getAttribute("user_email"));
		System.out.println(session.getAttribute("user_address"));
		System.out.println(session.getAttribute("user_password"));

		request.getRequestDispatcher("/WEB-INF/form1.html").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		// request 객체 안에서 get Session
		
		session.setAttribute("user_name", request.getParameter("name")); // parameter로 전달한 값들이 user_name 키 값에 저장됨
		session.setAttribute("user_phone", request.getParameter("phone")); // 데이터들이 세션에 저장됨 > 계속 출력 가능
		session.setAttribute("user_email", request.getParameter("email")); 
		session.setAttribute("user_address", request.getParameter("address"));
		session.setAttribute("user_password", request.getParameter("pw"));
		
	
	}

}
