<%@ page contentType="text/html;charset=UTF-8" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="?language=en">English</a>|
	<a href="?language=ne">Nepali</a>
<h2>Edit your category</h2>

<form:form modelAttribute="updateCategory" method="POST">

			<div>
				<label for="categoryTitle"><spring:message code="category.categorytitle.internationalization" /></label>
				<form:input type="text" path="title" />
				<br />
			</div>

			<input type="submit" value="<spring:message code="category.updatecategory.internationalization" />" />

</form:form>
</body>
</html>