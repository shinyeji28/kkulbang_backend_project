<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="/css/login.css" />
    <title>Login Sample</title>
  </head>
  <body>
    <!-- header -->
    <header>
      <div class="header-wrap">
        <a class="logo" href="index.html">
          <img src="/images/icon.png" alt="꿀방icon" />
        </a>
        <a class="logo" href="index.html"><h1 class="logo">꿀방</h1></a>

        <ul>
          <li><button class="header-btn">어서오세요</button></li>
          <li>
            <button class="header-btn">
              <a href="./login.html">로그인</a>
            </button>
          </li>
        </ul>
      </div>
    </header>

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

      <!-- Form -->
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
        <!-- naver button -->
        <input
          type="image"
          src="/images/naver.png"
          height="45px"
          width="183px"
        />
        <!-- kakao button -->
        <input type="image" src="/images/kakao.png" />
        <!-- google button -->
        <input type="image" src="/images/goggle_login.png" />
      </nav>
    </div>
    <!-- footer -->
    <footer>
      <div class="footer-content">
        <div class="footer-nav">
          <ul>
            <li><a href="#">이용약관</a></li>
            <li><a href="#">개인정보처리방침</a></li>
            <li>고객센터: 123-4567</li>
          </ul>
        </div>
      </div>
      <div class="footer-bottom">
        <p>&copy; 2023 대전6반</p>
      </div>
    </footer>
    <script type="text/javascript" src="../js/login.js"></script>
  </body>
</html>
</html>