<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<%@ include file="/include/headerFooter.jsp"%>
</head>
<body>
	<!-- header -->
	<%@ include file="/include/header.jsp"%>
	<h1>관리자 보기</h1>
	<h2>전체 회원 리스트</h2>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>이메일</th>
				<th>가입날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${list}">
				<tr>
					<td>${member.userNo }</td>
					<td>${member.userId }</td>
					<td>${member.userName }</td>
					<td>${member.userEmail }</td>
					<td>${member.joinDate }</td>
					<td><button type="button" id="delete" value="${member.userId }">삭제</button></td>
				</tr>
				
			</c:forEach>
		</tbody>
	</table>


	<!-- footer -->
	<%@ include file="/include/footer.jsp"%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/assets/js/adminPage.js"></script>
	
</body>
</html>