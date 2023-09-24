<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/search.css" />
	<%@ include file="/include/headerFooter.jsp" %>
	
    <link
      href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&display=swap"
      rel="stylesheet"
      type="text/css"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css"
    />
  </head>
  <body>
    <%@ include file="/include/header.jsp" %>
    
    <div class="back">
      <h1>
        <pre>
                       우리나라 어디든 조회하세요!!
          실시간 거래를 한눈에 확인하실 수 있습니다.
        </pre>
      </h1>
      <img src="${pageContext.request.contextPath}/assets/images/house5.jpg" />
    </div>
    <main class="container">
      <section class="show-container">
        <section class="tab">
          <ul>
            <li><button id="aptTabtBtn">아파트 정보</button></li>
            <li><button id="aptDetailBtn">실거래 상세 조회</button></li>
            <li><button id="pickBtn">관심 지역 정보</button></li>
            <!-- <li><button id="houseTabgBtn">빌라 실거래</button></li>
            <li><button id="aroundBtn">주변 탐방 정보</button></li>
            <li><button id="envBtn">환경 정보</button></li> -->
          </ul>
        </section>
        <div class="show-wrap">
          <div class="show-wrap2">
            <section id="nav-left" class="nav-left">
            
              <form method="post" action="${pageContext.request.contextPath}/house?action=searchKeyword">
	              <input
	                type="text"
	                placeholder="원하시는 지역명/지하철역/아파트명을 검색하세요"
	                name="keyword"
	              />
	              <button sub class="search-btn">
	                <i class="bi bi-search"></i>
	              </button>
	            </form>
	          	<form>
	              <div class="user-condition">
	                <select id="sidoSelect" onchange="sidoOnChange(this.value)">
	                  <c:forEach var="sido" items="${sidoList}">
	                  	<option value="${sido.dongCode}">${sido.sidoName}</option>
	                  </c:forEach>
	                </select>
	                <select id="gugunSelect" onchange="gugunOnChange(this.value)">
	                  	<option>구군 선택</option>
	                </select>
	                <select id="dongSelect" onchange="dongOnChange(this.value)">
	                  	<option>동 선택</option>
	                </select>
                </form>
                <button id="filter" class="filter">필터</button>
              </div>
              <section id="filterList" class="filterList">
                <div class="filter-sub-title">
                  <h3>제목</h3>
                  <table>
                    <tbody>
                      <tr>
                        <td>10평 이하</td>
                        <td>10평 이하</td>
                        <td>10평 이하</td>
                        <td>10평 이하</td>
                      </tr>
                      <tr>
                        <td>10평 이하</td>
                        <td>10평 이하</td>
                        <td>10평 이하</td>
                        <td>10평 이하</td>
                      </tr>
                    </tbody>
                  </table>
                </div>
                <div></div>
              </section>
            </section>
            <section class="nav-right">
              <div id="aptListDiv" class="nav-right-wrap">
               
                
              </div>
            </section>
            <div id="map" class="map" style="width: 100%; height: 70vh"></div>
          </div>
        </div>
      </section>
    </main>
    <%@ include file="/include/footer.jsp" %>
    
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7859d560b2d7fe4dfec5c4ce888fb58b"
    ></script>
  <!--   <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/map.js"></script> -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/search.js"></script>
  </body>
</html>
