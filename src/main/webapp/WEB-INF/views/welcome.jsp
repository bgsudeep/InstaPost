<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<h1>Welcome to InstaPost</h1> 
		</div>	
	</section>
	
	<security:authorize access="isAuthenticated()">
		Welcome  <security:authentication property="principal.username" />
		Welcome  <security:authentication property="principal" />
		<a href="<spring:url value='/doLogout' />" class="btn btn-default pull-right"> Logout</a>
	</security:authorize>
	
	
	
</body>
</html>
