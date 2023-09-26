window.onload = function () {
  let signup = document.querySelector("#signup");
  let signin = document.querySelector("#signin");
  let reset = document.querySelector("#reset");
  let first_input = document.querySelector(".first-input");
  let hidden_input = document.querySelector("#repeat__password");
  let signin_btn = document.querySelector(".signin__btn");
  let check = document.querySelector(".check");
  let name = document.querySelector("#input_name");
  console.log("name", name);

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
    name.style.display = "block";
    if (check.style.display !== "none") {
      check.style.display = "none";
    }
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
    name.style.display = "none";
    if (check.style.display == "none") {
      check.style.display = "block";
    }
  });
};
