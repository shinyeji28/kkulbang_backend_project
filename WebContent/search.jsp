<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="/css/search.css" />
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
    <header>
      <div class="header-wrap">
        <a class="logo" href="index.html">
          <img src="/images/icon.png" alt="꿀방icon" />
          <h1>꿀방</h1>
        </a>
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
    <div class="back">
      <h1>
        <pre>
                       우리나라 어디든 조회하세요!!
          실시간 거래를 한눈에 확인하실 수 있습니다.
        </pre>
      </h1>
      <img src="/images/house5.jpg" />
    </div>
    <main class="container">
      <section class="show-container">
        <section class="tab">
          <ul>
            <li><button id="aptTabtBtn">아파트 실거래</button></li>
            <li><button id="houseTabgBtn">빌라 실거래</button></li>
            <li><button id="pickBtn">관심 지역 정보</button></li>
            <li><button id="aroundBtn">주변 탐방 정보</button></li>
            <li><button id="envBtn">환경 정보</button></li>
          </ul>
        </section>
        <div class="show-wrap">
          <div class="show-wrap2">
            <section id="nav-left" class="nav-left">
              <input
                type="text"
                placeholder="원하시는 지역명/지하철역/아파트명을 검색하세요"
              />
              <button class="search-btn">
                <i class="bi bi-search"></i>
              </button>
              <div class="user-condition">
                <select>
                  <option value="서울">서울</option>
                </select>
                <select>
                  <option value="강남구">강남구</option>
                </select>
                <select>
                  <option value="역삼동">역삼동</option>
                </select>
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
              <div class="nav-right-wrap">
                <ul>
                  <li>카카오스페이스탓원</li>
                  <li>제주특별자치도 제주시 아라동 첨단로 242</li>
                  <li>거래 금액 : 60,000</li>
                  <li>건축년도 : 2007</li>
                  <li>전용면적 : 149.95</li>
                </ul>
                <ul>
                  <li>생태연못</li>
                  <li>제주특별자치도 제주시 5·16로 2596[용강동 산14-1]</li>
                  <li>거래 금액 : 120,000</li>
                  <li>건축년도</li>
                  <li>전용면적 : 3000.95</li>
                </ul>
                <ul>
                  <li>제주스페이스닷키즈어린이집</li>
                  <li>제주특별자치도 제주시 첨단로 216-18</li>
                  <li>거래 금액 : 70,000</li>
                  <li>건축년도 : 2010</li>
                  <li>전용면적 : 87.95</li>
                </ul>
                <ul>
                  <li>롯데미도파광화문빌딩</li>
                  <li>당주동 232 - 10</li>
                  <li>거래 금액 : 60,000</li>
                  <li>건축년도</li>
                  <li>전용면적 : 149.95</li>
                </ul>
                <ul>
                  <li>나눔건설사업관리본부</li>
                  <li>제주특별자치도 제주시 첨단로 241</li>
                  <li>거래 금액 : 120,000</li>
                  <li>건축년도</li>
                  <li>전용면적 : 149.95</li>
                </ul>
                <ul>
                  <li>롯데미도파광화문빌딩</li>
                  <li>당주동 232 - 10</li>
                  <li>거래 금액 : 60,000</li>
                  <li>건축년도</li>
                  <li>전용면적 : 149.95</li>
                </ul>
                <ul>
                  <li>롯데미도파광화문빌딩</li>
                  <li>당주동 232 - 10</li>
                  <li>거래 금액 : 60,000</li>
                  <li>건축년도</li>
                  <li>전용면적 : 149.95</li>
                </ul>
              </div>
            </section>
            <div id="map" class="map" style="width: 100%; height: 70vh"></div>
          </div>
        </div>
      </section>
    </main>
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=7859d560b2d7fe4dfec5c4ce888fb58b"
    ></script>
    <script type="text/javascript" src="../js/map.js"></script>
    <script type="text/javascript" src="../js/search.js"></script>
  </body>
</html>