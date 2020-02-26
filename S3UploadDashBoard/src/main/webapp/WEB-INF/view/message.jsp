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
	<div class ="manageS3">
		<form:form action="upload" method="post" enctype="multipart/form-data">
		<label for="file">Select Resoures :</label>
		<input type="file" id="file" name="file" multiple></input><br><br>
		<input type="submit" value="+" id="addURL" class="btn btn-primary">&nbsp;&nbsp;&nbsp;
		<input type="button" value="Show Resources" id="show_resource" class="btn btn-primary" >
			<br>
			<br>
			 <p id="show_p" class ="noMessage">The Resource Added to AmazonS3 Bucket ::</p><p style="color:blue;"><c:out value="${fileURL}" /></p>
			<p style="color:red;"><c:out value="${errorMsg}" /></p>
			<!--  <input type="submit"  onclick="location.href='addMessage'" value="Add URL">-->
		</form:form>
		</div>
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
</body>
</html>