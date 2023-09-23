const root = "/WhereIsMyHome";

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

function sidoOnChange(dongCode) {
  let url = `${root}/house?action=gugun&dongCode=${dongCode}`;
  fetch(url)
    .then((response) => response.json())
    .then((data) => resultViewJSON(data));
} 
function resultViewJSON(datas) {
  console.log(datas);
  let gugunSelect = document.querySelector("#gugunSelect");
  gugunSelect.innerHTML = "";
  datas.forEach(function(data){
    gugunSelect.innerHTML += `<option value=${data.dongcode}>${data.gugunName}</option>`;
  })

  
  
	  

  // if (data.cnt == 0) {
  //   isUseId = true;
  //   resultDiv.setAttribute("class", "mb-3 text-primary");
  //   resultDiv.innerHTML =
  //     "<span class='fw-bold'>" + data.checkid + "</span>은 사용할 수 있습니다.";
  // } else {
  //   isUseId = false;
  //   resultDiv.setAttribute("class", "mb-3 text-warning");
  //   resultDiv.innerHTML =
  //     "<span class='fw-bold'>" + data.checkid + "</span>은 사용할 수 없습니다.";
  // }
}
