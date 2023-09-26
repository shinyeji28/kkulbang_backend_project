<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header>
	<div class="header-wrap">
		<a class="logo" href="index.html"> <img
			src="${pageContext.request.contextPath}/assets/images/icon.png"
			alt="꿀방icon" />
			<h1>꿀방</h1>
		</a>
		<ul>
			<li><button class="header-btn">어서오세요</button></li>
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
