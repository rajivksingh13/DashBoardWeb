<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="bottomleft">
		<img src="${contextPath}/resources/images/netcracker_logo2.jpg" style="width:40%;">
</div>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

<spring:url value="/resources/core/js/hello.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js"
	var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>


