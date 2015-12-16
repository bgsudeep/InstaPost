
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Category</title>
</head>
<body>
	<a href="?language=en">English</a>|
	<a href="?language=ne">Nepali</a>
	<div>
		<a href="<spring:url value='/addCategory' />">
			<spring:message code="category.addCategory.internationalization" />
		</a>
	</div>
	<div class="list">
		<table>
			<tr>
				<th><spring:message code="category.id.internationalization" /></th>
				<th><spring:message code="category.categorytitle.internationalization" /></th>
				<th><spring:message code="category.edit.internationalization" /></th>
				<th><spring:message code="category.delete.internationalization" /></th>
			</tr>
			<c:forEach var="category" items="${category}">
				<tr>
					<td>${category.id}</td>
					<td>${category.title}</td>
					<spring:url value="/category_edit/{id}" var="edit">
						<spring:param name="id" value="${category.id}" />
					</spring:url>

					<td><a href="${edit}">Edit</a></td>

					<spring:url value="/category_delete/{id}" var="delete">
						<spring:param name="id" value="${category.id}" />
					</spring:url>
					<td><a href="${delete}"
						onclick="return confirm('Are you sure want to delete');">delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>