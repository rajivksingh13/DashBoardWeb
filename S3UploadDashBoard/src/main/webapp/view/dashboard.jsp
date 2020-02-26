<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<title>NC DASHBOARD</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${contextPath}/resources/css/welcome.css" rel="stylesheet">
<link rel="stylesheet"
	href="${contextPath}/resources/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	 <div class="bgimg">
		<div class="middle">
			<h1>COMING SOON</h1>
			<hr>
			<p id="demo" style="font-size: 30px"></p>
		</div>
		<!--  <div class="bottomleft">
		<img src="${contextPath}/resources/images/netcracker_logo2.jpg" style="width:40%;">
		</div>-->
		<div class="container">
			<div class="jumbotron">
				<h1><c:out value="${message}"/></h1>
				<c:forEach var="message" items="${messageList}">
			<tr>
				<td>${message.id}</td>
				<td>${message.message}</td>
			</tr>
		</c:forEach>
			</div>
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4"></div>
				<div class="col-sm-4"></div>
			</div>
		</div>
	</div>	
	<jsp:include page="footer.jsp" />
	<script src="${contextPath}/resources/js/welcome.js"></script>

</body>
</html>

