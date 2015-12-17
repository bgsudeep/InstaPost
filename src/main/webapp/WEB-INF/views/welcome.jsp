<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	
	<security:authorize access="isAuthenticated()">
		<h2>Welcome  ${user.firstName},</h2>
		Welcome to InstaPost. Post a news as you see. Post and share the worlds moments. Enjoy InstaPosting :)
	</security:authorize>
	
	
	
</body>
</html>
