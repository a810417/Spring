<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Member Page</title>
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
</head>
<body>
<c:forEach var="list" items="${list}">

<label>id: </label>
<input value="${list.id}"/>
<br/>
<label>account: </label>
<input value="${list.account}"/>
<br/>
<label>password: </label>
<input value="${list.password}"/>
<br/>
<label>nickname: </label>
<input value="${list.nickname}"/>
<br/>
<label>email: </label>
<input value="${list.email}"/>
<br/>
<label>create_at: </label>
<input value="${list.create_at}"/>
<br/>
<label>photo: </label>
<img alt="" src="${contextRoot}/downloadImage/${list.id}">
<br/>
<br/>
<br/>

</c:forEach>
</body>
</html>