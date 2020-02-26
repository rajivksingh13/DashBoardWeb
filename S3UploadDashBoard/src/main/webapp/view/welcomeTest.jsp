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
<script type='text/javascript' src='${contextPath}/resources/js/jquery-1.10.2.js'></script> 
<script type='text/javascript' src='${contextPath}/resources/js/jquery-ui.js'></script>
<script type='text/javascript' src='${contextPath}/resources/js/jquery-ui.min.js'></script>
<script type='text/javascript' src='${contextPath}/resources/js/jquery.sessionTimeout.js'></script>
<script type='text/javascript' src='${contextPath}/resources/js/jquery.cookie.js'></script>

</head>
<body>
	<div id="welcome">
	 <iframe id="ifame1" src=" ">
	</iframe>
	</div>

	<script src="${contextPath}/resources/js/welcome1.js"></script>

</body>
</html>

