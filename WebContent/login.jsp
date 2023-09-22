<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/assets/css/login.css" />
    <%@ include file="/include/headerFooter.jsp" %>
    <title>Login Sample</title>
  </head>
  <body>
    <%--<!-- header -->--%>
    <%@ include file = "/include/header.jsp"%>

    <div class="container">
      <!-- Heading -->
      <h1>SIGN IN</h1>

      <!-- Links -->
      <ul class="links">
        <li>
          <a href="#" id="signin">로그인</a>
        </li>
        <li>
          <a href="#" id="signup">회원가입</a>
        </li>
        <li>
          <a href="#" id="reset">비밀번호 찾기</a>
        </li>
      </ul>

      <%--<!-- Form -->--%>
      <form action="" method="post">
        <!-- email input -->
        <div class="first-input input__block first-input__block">
          <input type="email" placeholder="Email" class="input" id="email" />
        </div>
        <!-- password input -->
        <div class="input__block">
          <input
            type="password"
            placeholder="Password"
            class="input"
            id="password"
          />
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
        <button class="signin__btn">Sign in</button>
      </form>
      <!-- separator -->
      <div class="separator">
        <p>OR</p>
      </div>
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
    <%@ include file = "/include/footer.jsp" %>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/login.js"></script>
  </body>
</html>
</html>