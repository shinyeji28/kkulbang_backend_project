window.onload = function () {
  let signup = document.querySelector("#signup");
  let signin = document.querySelector("#signin");
  let reset = document.querySelector("#reset");
  let first_input = document.querySelector(".first-input");
  let hidden_input = document.querySelector("#repeat__password");
  let signin_btn = document.querySelector(".signin__btn");
  let check = document.querySelector(".check");
  let name = document.querySelector("#name");
  const root =  window.location.pathname+"/findUser.jsp";

  //----------- sign up 로그아웃 ---------------------
  signup.addEventListener("click", function (e) {
    e.preventDefault();
    signup.style.opacity = "1";
    signin.style.opacity = "0.6";
    first_input.classList.remove("first-input__block");
    first_input.classList.add("signup-input__block");
    hidden_input.style.opacity = "1";
    hidden_input.style.display = "block";//repeat비밀번호 보이기
    signin_btn.innerText = "Sign up";
    name.style.display = "block";//이름 보이기
    check.style.display = "none";//체크박스 없애기
	console.log("click 회원가입");
	document.querySelector("input[name=action]").value="regist";
  });

  //----------- sign in 로그인---------------------
  signin.addEventListener("click", function (e) {
    e.preventDefault();
    signin.style.opacity = "1";
    signup.style.opacity = "0.6";
    first_input.classList.add("first-input__block");
    first_input.classList.remove("signup-input__block");
    hidden_input.style.opacity = "0";
    hidden_input.style.display = "none";//repeat비밀번호 숨기기
    signin_btn.innerText = "Sign in";
    name.style.display = "none";//이름 없애기
    check.style.display = "block";//체크박스 보이기
    console.log("click 로그인");
	document.querySelector("input[name=action]").value="login";
  });
//----------- find password  ---------------------
  reset.addEventListener("click", function (e) {
	console.log("click reset");
	window.open(root, "비밀번호 찾기", "width=400, height=300, top=50, left=50");
	console.log("출력 reset");
	});
};
