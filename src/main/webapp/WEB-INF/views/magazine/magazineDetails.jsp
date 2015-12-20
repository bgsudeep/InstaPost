<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<h2>List of Magazines</h2>
	<div align="right">
			<a href="<spring:url value='add'/>">Add Magazine</a>
		</div>
	
	<table border="1" style="width: 100%; ">
		<tr align="left">
			<th>Title</th>
			<th>Post Date</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach items="${magazineList}" var="magazine">
		
				<spring:url value="{id}/news" var="listNewsOfMagazine">
					<spring:param name="id" value="${magazine.id}" />
				</spring:url>
			<tr>
				<td><a href="${listNewsOfMagazine}">
				${magazine.title}</a></td>
				<td>${magazine.postDate}
				</td>


				<!-- Spring:url for handling Spring template/@PathVariable -->
				<spring:url value="edit/{id}" var="edit">
					<spring:param name="id" value="${magazine.id}" />
				</spring:url>

				<td><a href="${edit}">Edit</a></td>


				<spring:url value="delete/{id}" var="delete">
					<spring:param name="id" value="${magazine.id}" />
				</spring:url>

				<td><a href="${delete}"
					onclick="return confirm('Are you sure want to delete');">Delete</a>
				</td>


			</tr>
		</c:forEach>
	</table>








</body>
</html>