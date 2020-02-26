<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">

<jsp:include page="header.jsp" />

<body>

	 <div class="container">

		<c:if test="${not empty msg}">
			<div class="alert alert-${css} alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<strong>${msg}</strong>
			</div>
		</c:if>

		<h1>All URLs</h1>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Resource URL</th>
					<th>Action</th>
				</tr>
			</thead>

			<!--<c:forEach var="message" items="${message}">-->
				<tr>
					<td>
						1
					</td>
					<td>http://wsmhd-1423.netcracker.com:8080/dashboard</td>					
					<td>
						<!--<spring:url value="" var="userUrl" />
						<spring:url value="" var="deleteUrl" /> 
						<spring:url value="" var="updateUrl" />>-->

						<button class="btn btn-info" onclick="location.href=''">Query</button>
						<button class="btn btn-primary" onclick="location.href=''">Update</button>
						<button class="btn btn-danger" onclick="this.disabled=true;post('')">Delete</button></td>
				</tr>
			<!--</c:forEach>-->
		</table>

	</div>

	<jsp:include page="footer.jsp" />

</body>
</html>