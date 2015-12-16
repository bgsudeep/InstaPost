<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">@import url("<c:url value="/resource/instapost.css"/>");</style>
<link rel="stylesheet" type="text/css" href="resource/css/instapost.css">
<title>Add Category</title>
</head>
<body>
	<div class="addform">
	<h1>Add the Category</h1>
		<form:form modelAttribute="addCategoryForm" Method="POST">
			<div>
				<label for="categoryTitle">Category Title:</label>
				<form:input type="text" path="title" />
				<form:errors path="title" cssClass="error"/>
				<br />
			</div>

			<input type="submit" value="Add Category" />

		</form:form>
	</div>

	
</body>
</html>