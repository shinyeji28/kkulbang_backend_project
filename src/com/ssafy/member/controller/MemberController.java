package com.ssafy.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
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
		System.out.println("삭제할 회원 아이디: "+id);
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
//		String repeatPass = request.getParameter("repeatPassword");
		MemberDto member= new MemberDto(id,name,password,null,null);
		System.out.println("등록할 정보: "+member);
		int cnt = memberService.registerMember(member);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		String pageUrl = request.getContextPath()+"/member?action=mvLogin";
		if(cnt==0) {
			writer.println("<script>alert('회원가입을 실패했습니다.'); location.href='"+pageUrl+"';</script>"); 
		
		}else {
			writer.println("<script>alert('회원가입을 성공했습니다.'); location.href='"+pageUrl+"';</script>"); 
		}
		writer.close();

		
	}
	//비밀번호 찾기
	private void findUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		System.out.println("비밀번호 찾기 요청");
		String id=request.getParameter("find_id");
		String name=request.getParameter("find_name");
		String email=request.getParameter("find_email");
		MemberDto member= new MemberDto(id,name,null,email,null);
		System.out.println("찾을 회원 정보 : "+member);
		String password=memberService.findUser(member);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		String pageUrl = request.getContextPath()+"/member?action=mvLogin";
		if(password!=null) {
			writer.println("<script>alert('"+id+"님의 비밀번호는 "+password+"입니다.'); window.close(); </script>"); 
		
		}else {
			writer.println("<script>alert('입력하신 정보의 회원 정보가 존재하지 않습니다.'); window.close(); </script>"); 
		}
		writer.close();

	}
	// id로 로그인
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
		System.out.println("로그인 요청");
		String id = request.getParameter("id");		
		String password = request.getParameter("password");
		System.out.println(id+" "+password);

		MemberDto member= new MemberDto(id,null,password,null,null);
		MemberDto userInfo = memberService.login(member);

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter writer = response.getWriter();
		String pageUrl = request.getContextPath();
		
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

			writer.println("<script>alert('로그인을 성공했습니다.'); location.href='"+pageUrl+"';</script>"); 
		}else {//로그인 실패
			System.out.println("로그인 실패");
			pageUrl += "/member?action=mvLogin";
			writer.println("<script>alert('로그인을 실패했습니다.'); location.href='"+pageUrl+"';</script>"); 
		}	
		writer.close();

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
