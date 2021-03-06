<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Users</title>
</head>
<body>
	<h1>List of Users</h1>
		<c:forEach var="user" items="${listUser}">
			${user.firstName} ${user.lastName}
			
			<spring:url value="/user/delete/{id}" var="deleteUser">
					<spring:param name="id" value="${user.id}" />
				</spring:url> <a href="${deleteUser}">Delete</a></br>
		</c:forEach>
</body>
</html>