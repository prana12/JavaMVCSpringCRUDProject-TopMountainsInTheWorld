<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Save Mountain</title>
<link type="text/css" 
		rel="stylesheet" 
		href="${pageContext.request.contextPath}/resources/css/style.css">
<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-mountain-style.css"/>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />
	<!-- <div id="wrapper">
		<div id="header">
			<h1>Top Mountains in the World</h1>
		</div>
	</div> -->
	
	<div id="container">
		<h3>Add Mountain</h3>
		
		<!-- Div for displaying all errors -->
		<div class="error">
			<form:errors path="mountain.*" />
		</div>
		
		
		<form:form action="saveMountain" method="POST" modelAttribute="mountain">
			<table>
				<tbody>
					<tr>
						<td><label>Name*:</label></td>
						<td><form:input path="name" /></td>
					</tr>
					<tr>
						<td><label>Rank*:</label></td>
						<td><form:input path="rank" disabled="${disable}" /></td>
					</tr>
					<tr>
						<td><label>Known As:</label></td>
						<td><form:input path="knownAs"/></td>
					</tr>
					<tr>
						<td><label>Location*:</label></td>
						<td><form:input path="location" /></td>
					</tr>
					<tr>
						<td><label>Height*:</label></td>
						<td><form:input path="height" /></td>
					</tr>
					<tr>
						<td><label>First Ascent:</label></td>
						<td><form:input path="firstAscent" /></td>
					</tr>
					<tr>
						<td><label>Image URL:</label></td>
						<td><form:input path="imageUrl" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save"/></td>
					</tr>
				</tbody>
			</table>
		</form:form>
		
		<p>
			<a href="${pageContext.request.contextPath}/mountain/list" >Back to List</a>
		</p>
	</div>
	
	<jsp:include page="/WEB-INF/view/footer.jsp" />
</body>
</html>