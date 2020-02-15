<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title>NC DASHBOARD</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${contextPath}/resources/css/welcome.css" rel="stylesheet">
<!--  <link rel="stylesheet"
	href="${contextPath}/resources/css/bootstrap.min.css">-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/welcome.js"></script>
</head>

<spring:url value="welcome1" var="urlDashBoard" />
<spring:url value="addURL" var="addMessageURL" />

<!--  <nav class="navbar navbar-inverse ">-->
	 <div class="container">
		<!-- <div class="navbar-header">
			<a class="navbar-brand" href="${urlDashBoard}">NC DASHBOARD</a>
		</div> -->
		<!--  <div id="navbar">-->
			<ul class="nav navbar-nav navbar-right">
				<li class="active">
				<a href="${addMessageURL}"><span class="glyphicon glyphicon-plus"  aria-hidden="true"></span></a>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="active">
				<a href="${urlDashBoard}"><span class="glyphicon glyphicon-dashboard"  aria-hidden="true"></span></a>
				
				</li>
			</ul>
		<!--</div>-->
	</div>
<!--</nav>-->