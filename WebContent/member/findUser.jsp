<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/member" method="post">
<fieldset>
<input type="hidden" name="action" value="findUser">
<label>아이디 : <input type="text" name="find_id"></label>
<br>
<label>이름 : <input type="text" name="find_name"></label>
<br>
<label>이메일 : <input type="text" name="find_email"></label>
</fieldset>
<button type="submit">회원 확인</button>
</form>

</body>
</html>