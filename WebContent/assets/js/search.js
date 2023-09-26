const root = "/WhereIsMyHome";


// 카카오 맵 ------------------------------------------------------------------
var container = document.getElementById("map"); //지도를 담을 영역의 DOM 레퍼런스
var options = {
  //지도를 생성할 때 필요한 기본 옵션
  center: new kakao.maps.LatLng(33.450701, 126.570667), //지도의 중심좌표.
  level: 3, //지도의 레벨(확대, 축소 정도)
};

var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴

var positions = [];

// 지도에 여러개 마킹하기
function marking(){
	// 마커 이미지의 이미지 주소입니다
	var imageSrc =
	  "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
	
	for (var i = 0; i < positions.length; i++) {
	  // 마커 이미지의 이미지 크기 입니다
	  var imageSize = new kakao.maps.Size(24, 35);
	
	  // 마커 이미지를 생성합니다
	  var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);
	
	  // 마커를 생성합니다
	  var marker = new kakao.maps.Marker({
	    map: map, // 마커를 표시할 지도
	    position: positions[i].latlng, // 마커를 표시할 위치
	    title: positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
	    image: markerImage, // 마커 이미지
	  });
	}	
}

// 부드럽게 지도 중심을 이동 시키기
function panTo(lat, lng) {
  // 이동할 위도 경도 위치를 생성합니다 
  var moveLatLon = new kakao.maps.LatLng(lat, lng);
  
  // 지도 중심을 부드럽게 이동시킵니다
  // 만약 이동할 거리가 지도 화면보다 크면 부드러운 효과 없이 이동합니다
  map.panTo(moveLatLon);            
}

//------------------------------------------------------------------------------------

// mapPath = '<script type="text/javascript" src="' +root+ '/assets/js/map.js"></script>'
// document.write(mapPath);

const aptSection = document.querySelector("#aptSection");
const dealSection = document.querySelector("#dealSection");
const aptTabBtn = document.querySelector("#aptTabBtn");
const dealTapBtn = document.querySelector("#dealTapBtn");
const main = document.querySelector("main");
dealSection.setAttribute("style","display:none");
aptTabBtn.setAttribute("class","activeTap");

aptTabBtn.addEventListener("click", function () {
	dealSection.setAttribute("style","display:none");
	aptSection.setAttribute("style","display:block");

  aptTabBtn.setAttribute("class","activeTap");
  dealTapBtn.removeAttribute("class","activeTap");
	// document.documentElement.scrollTop = 0;

});

dealTapBtn.addEventListener("click", function () {
  clickDealTap();
});
function clickDealTap(){
	aptSection.setAttribute("style","display:none");
	dealSection.setAttribute("style","display:block");
  
  aptTabBtn.removeAttribute("class","activeTap");
  dealTapBtn.setAttribute("class","activeTap");
	// document.documentElement.scrollTop = 0;
}
/*
const pickBtn = document.querySelector("#pickBtn");
pickBtn.addEventListener("click", function () {});

const aroundBtn = document.querySelector("#aroundBtn");
aroundBtn.addEventListener("click", function () {});

const envBtn = document.querySelector("#envBtn");
envBtn.addEventListener("click", function () {});
*/


  // 구군 리스트 요청 및 출력
function sidoOnChange(dongCode) {
  let url = `${root}/house?action=gugun&dongCode=${dongCode}`;
  fetch(url)
    .then((response) => response.json())
    .then((data) => gugunListParsing(data));
} 
function gugunListParsing(datas) {
  let gugunSelect = document.querySelector("#gugunSelect");
  gugunSelect.innerHTML = `<option selected disabled>--- 구군 선택 ---</option>`;
  datas.forEach(function(data){
    gugunSelect.innerHTML += `<option value=${data.dongCode}>${data.gugunName}</option>`;
  })
  let dongSelect = document.querySelector("#dongSelect");
  dongSelect.innerHTML = `<option selected disabled>--- 동 선택 ---</option>`;
}
  // 동 리스트 요청 및 출력
function gugunOnChange(dongCode) {
  let url = `${root}/house?action=dong&dongCode=${dongCode}`;
  fetch(url)
    .then((response) => response.json())
    .then((data) => dongListParsing(data));
} 
function dongListParsing(datas) {
  let dongSelect = document.querySelector("#dongSelect");
  dongSelect.innerHTML = `<option selected disabled>--- 동 선택 ---</option>`;
  datas.forEach(function(data){
    dongSelect.innerHTML += `<option value=${data.dongCode}>${data.dongName}</option>`;
  })
}
  // 동 까지 선택했을 때 아파트 정보 요청 및 출력 
function dongOnChange(dongCode) {
  let url = `${root}/house?action=aptInfo&dongCode=${dongCode}`;
  fetch(url)
    .then((response) => response.json())
    .then((data) => aptListParsing(data));
} 
function aptListParsing(datas) {
  let aptListDiv = document.querySelector("#aptListDiv");
  let markList = [];
  let firstDataPos = []; // 첫번째 데이터의 위도와 경도
  datas.forEach(function(data){
    firstDataPos= [data.lat, data.lng];
    aptListDiv.innerHTML += ` 
    <ul onclick=aptDeal(${data.aptCode})>
      <li><h3>${data.apartmentName}<h3></li>
      <br>  
      <li>${data.dong} ${data.roadName} ${data.roadNameBonbun.replace(/(^0+)/,"")}</li>
      <li>건축년도 : ${data.buildYear}</li>
    </ul>`;
    
    markList.push({
      title: data.apartmentName,
      latlng: new kakao.maps.LatLng(data.lat, data.lng)});
  })
	
  let navRight = document.querySelector("#nav-right");
  navRight.setAttribute("style", "position: absolute;");

  positions = markList;
  marking();
  panTo(firstDataPos[0],firstDataPos[1]);
}

// 아파트 거래 정보 
function aptDeal(aptCode){
  let url = `${root}/house?action=deal&aptCode=${aptCode}`;
  fetch(url)
    .then((response) => response.json())
    .then((data) => {dealListParsing(data)});
}
function dealListParsing(datas){
  let dealData = document.querySelector("#dealData");
  dealData.innerHTML = `	
    <tr>
      <th>거래 금액</th>	
      <th>면적</th>	
      <th>거래 층</th>
      <th>거래 날짜</th>			
    </tr>
  `;
  datas.forEach(function(data){
    dealData.innerHTML += `
      <tr>
        <td>${data.dealAmount}<td>
        <td>${data.area}<td>
        <td>${data.floor}<td>
        <td>${data.dealYear}.${data.dealMonth}.${data.dealDay}<td>
      </tr>
    `;
  });
  clickDealTap();
}