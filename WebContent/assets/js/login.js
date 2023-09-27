window.onload = function () {
  let signup = document.querySelector("#signup");
  let signin = document.querySelector("#signin");
  let reset = document.querySelector("#reset");
  let first_input = document.querySelector(".first-input");
  let hidden_input = document.querySelector("#repeat__password");
  let signin_btn = document.querySelector(".signin__btn");
  let check = document.querySelector(".check");
  let name = document.querySelector("#input_name");
//
  let login=document.querySelector("#login");
  let regist=document.querySelector("#regist");
  let findPass=document.querySelector("#login_reset");

  //----------- sign up ---------------------
  signup.addEventListener("click", function (e) {
    e.preventDefault();
    signup.style.opacity = "1";
    signin.style.opacity = "0.6";
    first_input.classList.remove("first-input__block");
    first_input.classList.add("signup-input__block");
    hidden_input.style.opacity = "1";
    hidden_input.style.display = "block";
    signin_btn.innerText = "Sign up";
    name.style.display = "block";//이름 보이기
    check.style.display = "none";//체크박스 없애기
	console.log("click 회원가입");
	login.style.display = "none";
	regist.style.display = "block";
	findPass.style.display = "none";
	
  });

  //----------- sign in ---------------------
  signin.addEventListener("click", function (e) {
    e.preventDefault();
    signin.style.opacity = "1";
    signup.style.opacity = "0.6";
    first_input.classList.add("first-input__block");
    first_input.classList.remove("signup-input__block");
    hidden_input.style.opacity = "0";
    hidden_input.style.display = "none";
    signin_btn.innerText = "Sign in";
    name.style.display = "none";//이름 없애기
    check.style.display = "block";//체크박스 보이기
	console.log("click 로그인");
	login.style.display = "block";
	regist.style.display = "none";
	findPass.style.display = "none";
  });
//----------- find password  ---------------------
  reset.addEventListener("click", function (e) {
	console.log("click reset");
	 //window.open("../member,ad=findUser.jsp", "비밀번호 찾기", "width=400, height=300, top=50, left=50");
	});
};
