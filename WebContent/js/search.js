const aptTabtBtn = document.querySelector("#aptTabtBtn");
aptTabtBtn.addEventListener("click", function () {});

const houseTabgBtn = document.querySelector("#aptTabtBtn");
aptTabtBtn.addEventListener("click", function () {});

const pickBtn = document.querySelector("#pickBtn");
pickBtn.addEventListener("click", function () {});

const aroundBtn = document.querySelector("#aroundBtn");
aroundBtn.addEventListener("click", function () {});

const envBtn = document.querySelector("#envBtn");
envBtn.addEventListener("click", function () {});

// filter btn을 눌렀을 때 filter list가 열려있다면 닫고, 닫쳤다면 열기
let filterIsOpen = false;
const filter = document.querySelector("#filter");
filter.addEventListener("click", function () {
  const wrap = document.querySelector(".nav-left");
  const filterList = document.querySelector("#filterList");

  if (filterIsOpen) {
    wrap.setAttribute("style", "height:100px");
    filterList.setAttribute("style", "display:none");
    filterIsOpen = false;
  } else {
    wrap.setAttribute("style", "height:90%");
    filterList.setAttribute("style", "display:block");
    filterIsOpen = true;
  }
});
