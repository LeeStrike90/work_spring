<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core" %>
	<!-- ${pageContext.request.contextPath} => 프로젝트명 -->
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
	$(function() {
		$("#checkJson").click(function() {
			var member = {
				id : "park",
				pw : "1234",
				name : "박지성",
				email : "park@test.com"
			};
			$.ajax({
				type : "post"
// 				url : "프로젝트경로/sample/ticket"
				,url : "${contextPath}/sample/info"
				,contentType: "application/json; charset=utf-8"
// 					JSON.stringify: 객체를 json문자열 형태로 변환
				,data:JSON.stringify(member)
				,success:function(data){
					alert("@# data =>" +data);
				}
				,error:function(data){
					alert("오류가 발생했습니다.");
				}
			}); //end ajax
		});//end click function
	}); //end of function
</script>

</head>
<body>
	<input type="button" id="checkJson" value="회원 정보 보내기">

</body>
</html>