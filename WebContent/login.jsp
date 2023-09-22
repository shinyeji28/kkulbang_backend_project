<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
      href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&display=swap"
      rel="stylesheet"
      type="text/css"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/css/login.css" />
    <title>Login Sample</title>
  </head>
  <body>
  	<%--
    <!-- header -->
    <%@ include file = "/include/header.jsp"%>
    --%>

    <div class="container">
      <!-- Heading -->
      <h1>SIGN IN</h1>

      <!-- Links -->
      <ul class="links">
        <li>
          <a href="#" id="signin" name="choiceLogin">로그인</a>
        </li>
        <li>
          <a href="#" id="signup"name="choiceLogup">회원가입</a>
        </li>
        <li>
          <a href="#" id="reset"name="choiceFindPass">비밀번호 찾기</a>
        </li>
      </ul>

      <%--<!-- Form -->--%>
      <form action="${pageContext.request.contextPath}" method="post">
      <input type="hidden" name="action" value="login">
        <!-- id input -->
        <div class="first-input input__block first-input__block">
          <input type="email" placeholder="Id" class="input" id="email" name="id"/>
        </div>
        <!-- password input -->
        <div class="input__block">
          <input
            type="password"
            placeholder="Password"
            class="input"
            id="password"
            name="password"
          />
        </div>
        
        <div class="check">
		<input type="checkbox" name="isRemember" ${empty cookie.rememberID?"":"checked"}>아이디 기억하기
        </div>
        
        <!-- repeat password input -->
        <div class="input__block">
          <input
            type="password"
            placeholder="Repeat password"
            class="input repeat__password"
            id="repeat__password"
          />
        </div>
        <!-- sign in button -->
        <button type="submit"class="signin__btn">Sign in</button>
      </form>
      <!-- separator -->
      <div class="separator">
        <p>OR</p>
      </div>
      <%--다른 로그인 방법--%>
      <nav>
        <%--<!-- naver button -->--%>
        <input
          type="image"
          src="${pageContext.request.contextPath }/assets/images/naver.png"
          height="45px"
          width="183px"
        />
        <!-- kakao button -->
        <input type="image" src="${pageContext.request.contextPath }/assets/images/kakao.png" />
        <!-- google button -->
        <input type="image" src="${pageContext.request.contextPath }/assets/images/goggle_login.png" />
      </nav>
    </div>
    <!-- footer -->
    <%--
    <%@ include file = "/include/header.jsp" %>
    --%>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/login.js"></script>
   
  </body>
</html>
</html>