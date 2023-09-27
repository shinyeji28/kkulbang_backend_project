window.onload = function () {
  
  let del=document.querySelector("#delete");

//----------- list element delete ---------------------
  del.addEventListener("click", function (e) {
	console.log("삭제 요청");
	location.href = "${pageContext.request.contextPath }/member?action=delete&id="+del.value;
	});
	//<td><button type="button" id="delete" value="${member.userId }">삭제</button></td>
};
