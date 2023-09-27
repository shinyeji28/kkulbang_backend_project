package com.ssafy.member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.member.model.dto.MemberDto;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = MemberServiceImpl.getMemberService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch (action) {
			case "mvLogin":
				request.getRequestDispatcher("/member/login.jsp").forward(request, response);
				break;
			case "login":
				login(request,response);
				break;
			case "logout":
				logout(request,response);
				break;
			case "mvFindPass":
				request.getRequestDispatcher("/member/findUser.jsp").forward(request, response);
				break;
			case "findUser":
				findUser(request,response);
				break;
			case "regist"://회원가입
				regist(request,response);
				break;
			default:
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	private void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("회원가입");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String repeatPass = request.getParameter("repeatPassword");
		MemberDto member= new MemberDto(id,name,password,null,null);
		System.out.println("등록할 정보: "+member);
		memberService.registerMember(member);
		
		response.sendRedirect(request.getContextPath()+"/member?action=mvLogin");
	}
	private void findUser(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		System.out.println("비밀번호 찾기 요청");
		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		MemberDto member= new MemberDto(id,name,null,email,null);
		String password=memberService.findUser(member);
		

	}
	// id로 로그인
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		System.out.println("로그인 요청");
		String id = request.getParameter("id");		
		String password = request.getParameter("password");
		System.out.println(id+" "+password);

		MemberDto member= new MemberDto(id,null,password,null,null);
		MemberDto getMember = memberService.login(member);
		System.out.println(getMember);

		if(getMember!=null) {//로그인 성공
			System.out.println("로그인 성공 : "+getMember);
			HttpSession session = request.getSession();
			session.setAttribute("getMember", getMember);
			String isRemember = request.getParameter("isRemember");
			System.out.println("isRemember : "+isRemember);
			if(isRemember!=null) {//아이디 기억
				Cookie cookie= new Cookie("rememberId",id);
				cookie.setMaxAge(60*60);//1시간 기억
				response.addCookie(cookie);
			}else {//아이디 기억x
				Cookie cookie = new Cookie("rememberId",id);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}			
			response.sendRedirect(request.getContextPath());
		}else {//로그인 실패
			System.out.println("로그인 실패");
			response.sendRedirect(request.getContextPath()+"/member?action=mvLogin");
		}		
	}
	//이메일로 로그인
//	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
//		System.out.println("로그인 요청");
//		String email = request.getParameter("user_email");		
//		String password = request.getParameter("user_password");
//		MemberDto member= new MemberDto(null,email,password,null,null);
//		MemberDto getMember = memberService.loginByEamil(member);		
//
//		if(getMember!=null) {//로그인 성공
//			System.out.println("로그인 성공 : "+getMember);
//			HttpSession session = request.getSession();
//			session.setAttribute("getMember", getMember);
//			String isRemember = request.getParameter("isRemember");
//			System.out.println("isRemember : "+isRemember);
//			if(isRemember!=null) {//아이디 기억
//				Cookie cookie= new Cookie("rememberEmail",email);
//				cookie.setMaxAge(60*60);//1시간 기억
//				response.addCookie(cookie);
//			}else {//아이디 기억x
//				Cookie cookie = new Cookie("rememberEmail",email);
//				cookie.setMaxAge(0);
//				response.addCookie(cookie);
//			}			
//			response.sendRedirect(request.getContextPath());
//		}else {//로그인 실패
//			System.out.println("로그인 실패");
//			response.sendRedirect(request.getContextPath()+"/member?action=login");
//		}		
//	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("로그아웃 요청");
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath());		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
