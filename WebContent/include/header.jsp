<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
	Object user = session.getAttribute("getMember");
	String id = user.id;
--%>
<header>
	<div class="header-wrap">
		<a class="logo" href="${pageContext.request.contextPath}"> <img
			src="${pageContext.request.contextPath}/assets/images/icon.png"
			alt="꿀방icon" />
			<h1>꿀방</h1>
		</a>
		<ul>		
			<%--관리자로 로그인하지 않았을 경우 메뉴 --%>
			<c:if test="${cookie.rememberId.value ne 'admin'}">
				<li><button class="header-btn">어서오세요</button></li>
			</c:if>
			
			<%--관리자로 로그인 했을 경우 메뉴 --%>
			<c:if test="${cookie.rememberId.value eq 'admin'}">
				<li><button class="header-btn">어서오세요</button></li>
			</c:if>
			
			<%--로그인하지 않은 경우 메뉴 --%>
			<c:if test="${empty sessionScope.getMember }">
				<li>
					<button class="header-btn">
						<a href="${pageContext.request.contextPath}/member?action=mvLogin">로그인</a>
					</button>
				</li>
			</c:if>
			<%--로그인하지 않은 경우 메뉴 --%>
			<c:if test="${not empty sessionScope.getMember }">
				<li>
					<button class="header-btn">
						<a href="${pageContext.request.contextPath}/member?action=logout">로그아웃</a>
					</button>
				</li>
			</c:if>
		</ul>
	</div>
</header>
