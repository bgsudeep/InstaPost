<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List Category</title>
</head>
	<body>
		
		<ul>
			<li>
				<a href="<c:url value='/admin/news/list'/>">All</a>
			</li>
			<li>
				<a href="<c:url value='/admin/news/unpublished'/>">Unpublished</a>
			</li>
			<li>
				<a href="<c:url value='/admin/news/published'/>">Published</a>
			</li>
		</ul>
		<div align="right">
			<a href="<spring:url value='add' />" >
				 <b>Add News</b>
			</a>
		</div>
		<hr>
		<div class="list">
				<c:forEach var="news" items="${listNews}">
					<table width=100%>
						<tr>
							<td width="50%">
								<h3>${news.title}</h3>
							</td>
							<security:authentication var="principal" property="principal" />
							<security:authentication var="principal" property="principal" />
							<security:authorize access="hasRole('ROLE_USER')">
							<c:if test="${news.user.email eq principal.username }">
								<td width="30%" align="right">
									<spring:url value="/news/edit/{id}" var="edit">
										<spring:param name="id" value="${news.id}" />
									</spring:url>
				
									<a href="${edit}">Edit</a>&nbsp; &nbsp;
				
									<spring:url value="/news/delete/{id}" var="delete">
										<spring:param name="id" value="${news.id}" />
									</spring:url>
									<a href="${delete}" onclick="return confirm('Are you sure want to delete');">delete</a>								
								</td>							
							</c:if>
							</security:authorize>
							<security:authorize access="hasRole('ROLE_ADMIN')">
								<c:choose >
									<c:when test="${news.publish eq true }">
										<td width="30%" align="right">
											<spring:url value="/admin/news/unpublish/{id}" var="unpublish">
												<spring:param name="id" value="${news.id}" />
											</spring:url>
											<a href="${unpublish}">Un-Publish</a>&nbsp; &nbsp;
										</td>
									</c:when>
									<c:otherwise>
										<td width="30%" align="right">
											<spring:url value="/admin/news/publish/{id}" var="publish">
												<spring:param name="id" value="${news.id}" />
											</spring:url>
											<a href="${publish}">Publish</a>&nbsp; &nbsp;
										</td>
									</c:otherwise>								
								</c:choose>
							</security:authorize>	
						</tr>
						<tr>
					
							<td colspan="2">${news.description}</td>
							
						</tr>
					</table>
					<hr/>
				</c:forEach>
		</div>
	</body>
</html>