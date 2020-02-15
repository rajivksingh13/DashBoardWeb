<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
<jsp:include page="header.jsp" />
<body>
	<div class="container">
		<form:form action="addMessage" method="post">
			<b>Add Resoure URLs:</b>  &nbsp;&nbsp;&nbsp;<input type="text"
				name="message"></input>&nbsp;&nbsp;
			<input type="submit" value="+" id="addURL" class="btn btn-primary">&nbsp;&nbsp;&nbsp;
			<input type="button" value="Show Resources" id="show_resource" class="btn btn-primary" >
			<br>
			<br>
			<p style="color:blue;"><c:out value="${sucessMsg}" /></p>
			<p style="color:red;"><c:out value="${errorMsg}" /></p>
			<!--  <input type="submit"  onclick="location.href='addMessage'" value="Add URL">-->
		</form:form>
		
		<div id="showMessage" class="noMessage"> 
		<h1>All Resource URLs</h1>
        <table class="table table-striped">
			<thead>
				<tr>
					<th>#ID</th>
					<th>Resource URL</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
        <!--  -->
        </div>
	</div>
	<jsp:include page="footer.jsp" />
</body>
</html>