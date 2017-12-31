<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Top Mountains in the world</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp" />
	<!-- <div id="wrapper">
		<div id="header">
			<h1>Top Mountains in the World</h1>
		</div>
	</div> -->

	<div id="container">
		<div id="content">

			<!-- put a new button - Add Mountain -->
			<input type="button" value="Add Mountain info"
				onclick="window.location.href='showFormForAdd';" class="add-button" />

			<!-- Add html table here -->
			<table>
				<tr>
					<th></th>
					<th>Name</th>
					<th>Rank</th>
					<th>Known as</th>
					<th>Location</th>
					<th>Height</th>
					<th>First Ascent</th>
					<th>Action</th>
				</tr>

				<!-- loop over and print customers -->
				<c:forEach var="tempMountain" items="${mountains}">

					<!-- Create Update link -->
					<c:url var="updateLink" value="/mountain/showFormForUpdate">
						<c:param name="rank" value="${tempMountain.rank}" />
					</c:url>

					<!-- Create Update link -->
					<c:url var="deleteLink" value="/mountain/delete">
						<c:param name="rank" value="${tempMountain.rank}" />
					</c:url>

					<tr>
						<td><img src="${tempMountain.imageUrl}" width="70"
							height="60" /></td>
						<td><a href="${updateLink}">${tempMountain.name}</a></td>
						<td class="rank">${tempMountain.rank}</td>
						<td>${tempMountain.knownAs}</td>
						<td>${tempMountain.location}</td>
						<td>${tempMountain.height}</td>
						<td>${tempMountain.firstAscent}</td>
						<td><a href="${updateLink}">Update</a><br> <a
							href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this mountain info?'))) return false;">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	
	<h6 id="sub-footer">*Information collected from
		Wikipedia[https://en.wikipedia.org/wiki/List_of_highest_mountains_on_Earth]</h6>
	<jsp:include page="/WEB-INF/view/footer.jsp" />
	<!-- <div id="footer">
		<h6 id="sub-footer">*Information collected from Wikipedia[https://en.wikipedia.org/wiki/List_of_highest_mountains_on_Earth]</h6>
		<h5>Copyright © 2017</h5>
	</div> -->

</body>
</html>