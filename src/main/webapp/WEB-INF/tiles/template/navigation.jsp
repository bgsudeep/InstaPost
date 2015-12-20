<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<li><a href="<spring:url value="/welcome"/>">Home</a></li>
<li><a href="<spring:url value="/news/list"/>">News</a></li>
<security:authorize access="hasRole('ROLE_USER')">
<li><a href="<spring:url value="/magazine/"/>">Magazine</a></li>
</security:authorize>
<security:authorize access="hasRole('ROLE_ADMIN')">
<li><a href="<spring:url value="/category/"/>">Category</a></li>
</security:authorize>
<security:authorize access="hasRole('ROLE_ADMIN')">
<li><a href="<spring:url value="/user/list/"/>">Users</a></li>
</security:authorize>
<li><a href="<spring:url value="/user/edit"/>">Edit Profile</a></li>
<li><a href="<spring:url value="/doLogout"/>">Logout</a></li>

