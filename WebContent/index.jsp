<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="/include/headerFooter.jsp" %>
    <link href="${pageContext.request.contextPath}/assets/css/index.css" rel="stylesheet" />

  </head>
  <body>
    <%@ include file="/include/header.jsp" %>
    
    <section>
      <main>
        <section class="banner">
          <div id="banners">
            <img src="${pageContext.request.contextPath}/assets/images/uphouse1.jpg" alt="" />
            <img src="${pageContext.request.contextPath}/assets/images/uphouse2.jpg" alt="" />
            <img src="${pageContext.request.contextPath}/assets/images/uphouse3.jpg" alt="" />
          </div>
          <div class="midMenu-container">
            <div class="midMenu-wrap">
              <h1>어떤 꿀방을 찾으세요?</h1>
              <div class="banner-tab">
                <ul>
                  <li><a href="${pageContext.request.contextPath}/house?action=mvHouse">실시간 거래 조회</a></li>
                  <li><a>관심 지역 설정</a></li>
                  <!-- <li><a>탭1</a></li> -->
                </ul>
              </div>
              <form class="search-form">
                <input
                  id="searchWidth"
                  type="text"
                  placeholder="지역, 동, 아파트명을 입력하세요"
                />
                <button id="btn" type="submit">
                  <a href="${pageContext.request.contextPath}/search.jsp">검색</a>
                </button>
              </form>
            </div>
          </div>
        </section>

        <section class="featured-listings">
          <div id="newWrapper">
            <div class="newHead">
              <div class="newsHeadStyle">공지사항</div>
              <div><a href="<%=request.getContextPath()%>/article?action=list">더보기</a></div>
            </div>

            <div id="newsContentWrapper">
              <div class="newsContentBox">
                <a href="" class="newsContent"> 꿀방 9월 이벤트 안내 </a>
              </div>
            </div>

            <div id="newsContentWrapper">
              <div class="newsContentBox">
                <a href="" class="newsContent">
                  꿀방과 함께하는 안전한 부동산 거래 수칙
                </a>
              </div>
            </div>

            <div id="newsContentWrapper">
              <div class="newsContentBox">
                <a href="" class="newsContent"> 꿀방 100% 활용하는 방법 </a>
              </div>
            </div>

            <div id="newsContentWrapper">
              <div class="newsContentBox">
                <a href="" class="newsContent"> 꿀방 신규 회원 이벤트 </a>
              </div>
            </div>

            <div id="newsContentWrapper">
              <div class="newsContentBox">
                <a href="" class="newsContent">
                  합리적인 부동산 거래 꿀방과 함께 하세요
                </a>
              </div>
            </div>
          </div>

          <div id="newWrapper">
            <div class="newHead">
              <div class="newsHeadStyle">뉴스</div>
            </div>

            <div id="newsContentWrapper">
              <div class="newsContentBox">
                <a
                  href="https://www.segye.com/newsView/20230904517144?OutUrl=naver"
                  class="newsContent"
                >
                  부동산PF 부실에 제2금융권 연체율 ‘급등’ 外 [한강로 경제브리핑]
                </a>
              </div>
            </div>

            <div id="newsContentWrapper">
              <div class="newsContentBox">
                <a
                  href="https://www.yna.co.kr/view/AKR20230831144900002?input=1195m"
                  class="newsContent"
                >
                  [게시판] 금투협, 한국부동산원과 부동산 금융 활성화 협약
                </a>
              </div>
            </div>

            <div id="newsContentWrapper">
              <div class="newsContentBox">
                <a
                  href="https://news.kbs.co.kr/news/view.do?ncd=7762271&ref=A"
                  class="newsContent"
                >
                  [성공예감] 부동산 바닥 찍었지만 대세상승 아니다 – 김인만
                  소장(부동산연구소)
                </a>
              </div>
            </div>

            <div id="newsContentWrapper">
              <div class="newsContentBox">
                <a
                  href="https://www.nocutnews.co.kr/news/6004973"
                  class="newsContent"
                >
                  대통령실 "부동산 공급 활성화 방안 이달 중에 발표"
                </a>
              </div>
            </div>

            <div id="newsContentWrapper">
              <div class="newsContentBox">
                <a
                  href="https://www.yna.co.kr/view/AKR20230829122100003?input=1195m"
                  class="newsContent"
                >
                  '출산가구에 7만호 공급'…부동산 전문가들 "일정 효과 기대"
                </a>
              </div>
            </div>
          </div>
        </section>
      </main>

      <!--카드돌아가는 부분  START-->

      <div id="cardsWrapper">
        <div id="wrap">
          <div class="card">
            <div class="card-front"><img src="${pageContext.request.contextPath}/assets/images/house1.jpg" /></div>
            <div class="card-back"><img src="${pageContext.request.contextPath}/assets/images/house2.jpg" /></div>
          </div>
        </div>

        <div id="wrap">
          <div class="card">
            <div class="card-front"><img src="${pageContext.request.contextPath}/assets/images/house3.jpg" /></div>
            <div class="card-back"><img src="${pageContext.request.contextPath}/assets/images/house4.jpg" /></div>
          </div>
        </div>

        <div id="wrap">
          <div class="card">
            <div class="card-front"><img src="${pageContext.request.contextPath}/assets/images/house5.jpg" /></div>
            <div class="card-back"><img src="${pageContext.request.contextPath}/assets/images/house6.jpg" /></div>
          </div>
        </div>
      </div>
      <!--카드돌아가는 부분  END-->
      <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/home.js"></script>
    </section>
    
    <%@ include file="/include/footer.jsp" %>
    
  </body>
</html>
