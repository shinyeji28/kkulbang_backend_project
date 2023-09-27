<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<%@ include file="/include/headerFooter.jsp"%>

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/assets/css/login.css" />
<title>Login Sample</title>
</head>
<body>
	<!-- header -->
	<%@ include file="/include/header.jsp"%>

	<div class="container">
		<!-- Heading -->
		<h1>SIGN IN</h1>
		<c:set var="flag" value="0" />
		<!-- Links -->
		<ul class="links">
			<li><a id="signin" name="choiceLogin" >로그인</a></li>
			<li><a id="signup" name="choiceLogup">회원가입</a></li>
			<li><a id="reset" name="choiceFindPass">비밀번호 찾기</a></li>
		</ul>

		<%--<!-- Form -->--%>
		<form action="${pageContext.request.contextPath}/member" method="post">

			<input type="hidden" id="login"name="action" value="login">
		
			<input type="hidden" id="regist" name="action" value="regist">
	

			<!-- id input -->
			<div class="first-input input__block first-input__block">
				<input type="text" placeholder="ID" class="input" id="input_id"
					name="id" value="${cookie.rememberId.value }" />
			</div>
			<!-- name input -->
			<div class="input__block" style="display: none">
				<input type="text" placeholder="Name" class="input" id="input_name"
					name="input_name" />
			</div>
			<!-- password input -->
			<div class="input__block">
				<input type="password" placeholder="Password" class="input"
					id="password" name="password" />
			</div>
			<!-- id checkbox -->
			<div class="check">
				<input type="checkbox" name="isRemember"
					${empty cookie.rememberId?"":"checked"}>아이디 기억하기
			</div>

			<!-- repeat password input -->
			<div class="input__block">
				<input type="password" placeholder="Repeat password"
					class="input repeat__password" id="repeat__password"
					name="repeatPassword" />
			</div>
			<!-- sign in button -->
			<button type="submit" class="signin__btn">Sign in</button>
		</form>
		<!-- separator -->
		<div class="separator">
			<p>OR</p>
		</div>
		<%--다른 로그인 방법--%>
		<nav>
			<%--<!-- naver button -->--%>
			<input type="image"
				src="${pageContext.request.contextPath }/assets/images/naver.png"
				height="45px" width="183px" />
			<!-- kakao button -->
			<input type="image"
				src="${pageContext.request.contextPath }/assets/images/kakao.png" />
			<!-- google button -->
			<input type="image"
				src="${pageContext.request.contextPath }/assets/images/goggle_login.png" />
		</nav>
	</div>
	<!-- footer -->
	<%@ include file="/include/footer.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/assets/js/login.js"></script>

</body>
</html>