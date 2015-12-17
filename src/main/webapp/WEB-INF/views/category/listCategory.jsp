
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Category</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript"
	src="<spring:url value="/resource/js/ajax.js"/>"></script>

</head>
<body>
	<a href="?language=en">English</a>|
	<a href="?language=ne">Nepali</a>
	<div>
		<%-- <a href="<spring:url value='/addCategory' />">
			<spring:message code="category.addCategory.internationalization" />
		</a> --%>
		<input type="button"
			value="<spring:message code="category.addCategory.internationalization" />"
			onclick="make_visible('formInput');return false;">

	</div>
	<div class="list">
		<table id="categoryTable">
			<tr>
				<th><spring:message code="category.id.internationalization" /></th>
				<th><spring:message
						code="category.categorytitle.internationalization" /></th>
				<th><spring:message code="category.edit.internationalization" /></th>
				<th><spring:message code="category.delete.internationalization" /></th>
			</tr>
			<c:forEach var="category" items="${category}">
				<tr id="${category.id}">
					<td>${category.id}</td>
					<td>${category.title}</td>
					<spring:url value="edit/{id}" var="edit">
						<spring:param name="id" value="${category.id}" />
					</spring:url>

					<td><a href="${edit}">Edit</a></td>

					<%-- <spring:url value="/category_delete/{id}" var="delete">
						<spring:param name="id" value="${category.id}" />
					</spring:url> --%>
					<td><a href="#"
						onclick="deleteCategory(${category.id})">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
	</div>

	<!-- Success - or Validation errors -->
	<div id="result" style="display: none; width: 300px; padding:10px; background-color:blue; height: 110px; margin-left: 500px;">
		<p id="result-header"></p>
		<p id="success"></p>
		<p id="errors"></p>
	</div>

	<div id="formInput" style="display: none; background-color: red; width: 300px; padding:10px; margin-left: 500px;">

		<h3 align="center">Category</h3>

		<!-- No action method handled by AJAX-->
		<form id="categoryForm" method="post">

			<p>
				<label for="title"><spring:message
						code="category.categorytitle.internationalization" /></label> <input
					type="text" name="title" id="title" value="" />
			</p>



			<input type="button"
				value="<spring:message code="category.addCategory.internationalization" />"
				onclick="categorySubmit();return false;">

		</form>
		<h4 align="center">
			<a href="#"
				onclick="make_hidden('formInput'); make_hidden('result');resetForm('categoryForm');">
				<b>EXIT</b>
			</a>
		</h4>

	</div>
</body>
</html>