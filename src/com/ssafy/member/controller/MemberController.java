package com.ssafy.member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

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
			case "login"://로그인
				login(request,response);
				break;
			case "logout"://로그아웃
				logout(request,response);
				break;
			case "mvFindPass"://비밀번호 찾기
				request.getRequestDispatcher("/member/findUser.jsp").forward(request, response);
				break;
			case "findUser"://비밀번호 찾기
				findUser(request,response);
				break;
			case "regist"://회원가입
				regist(request,response);
				break;
			case "list"://회원 리스트 보기
				list(request,response);
				break;
			case "delete"://회원 리스트에서 회원 삭제
				delete(request,response);
				break;
			default:
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			}

		} catch (Exception e) {			
			e.printStackTrace();
//			request.getRequestDispatcher("/error/error.jsp").forward(request, response);
		}

	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("삭제 요청 수신");
		String id = request.getParameter("id");
		System.out.println("삭제할 국가 코드: "+id);
		memberService.deleteMember(id);
		
		response.sendRedirect(request.getContextPath()+"/member?action=list");
		
	}
	//전체 회원 목록 보기
	private void list(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		System.out.println("전체 회원 목록 조회 요청 수신");
		List<MemberDto> list = memberService.list();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/member/adminPage.jsp").forward(request, response);	
	}
	//회원가입
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
	//비밀번호 찾기
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
		MemberDto userInfo = memberService.login(member);

		if(userInfo!=null) {//로그인 성공
			System.out.println("로그인 성공 : "+userInfo);
			HttpSession session = request.getSession();
			session.setAttribute("userinfo", userInfo);
			
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
	//로그아웃
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
