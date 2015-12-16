<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Magazine Form</title>
</head>
<body>

	<form:form modelAttribute="magazine" action="add" method="POST">
		<fieldset>
			<legend> Add a Magazine</legend>
			<p>
				<form:errors path="*" cssStyle="color : red;" />
			</p>
			<p>
				<label for="title">Title: </label>
				<form:input path="title" />


				<form:errors path="title" cssStyle="color : red;" />

			</p>
			
			<input type="submit" value ="Add"/>
			
			
		</fieldset>
	</form:form>
</body>
</html>