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

<title>Insert title here</title>
</head>
<body>
	
	<div class="list">
		<c:forEach var="news" items="${magazine.news}">
			<table width=100%>
				<tr>
					<td width="50%">
						<h3>${news.title}</h3>

					</td>

					<security:authentication var="principal" property="principal" />

					<security:authorize access="hasRole('ROLE_USER')">
						<c:if test="${news.user.email eq principal.username }">

							<form:form method="POST" action="/InstaPost/magazine/news/add">
								<input type="hidden" name="newsId" value='${news.id}' />
								<select name="magazineId">
									<c:forEach items="${magazineList}" var="magazine">
										<option value="${magazine.id}"
											${magazine == selectedMagazine ? 'selected' : ''}>${magazine.title}</option>
									</c:forEach>
								</select>
								<input type="submit" value="Add">
							</form:form>

							<td width="30%" align="right"><spring:url
									value="/news/edit/{id}" var="edit">
									<spring:param name="id" value="${news.id}" />
								</spring:url> <a href="${edit}">Edit</a>&nbsp; &nbsp; <spring:url
									value="/news/delete/{id}" var="delete">
									<spring:param name="id" value="${news.id}" />
								</spring:url> <a href="${delete}"
								onclick="return confirm('Are you sure want to delete');">Delete</a>
							</td>
						</c:if>
					</security:authorize>
				</tr>
				<tr>

					<td colspan="2">${news.description}</td>

				</tr>
			</table>
			<hr />
		</c:forEach>
	</div>


</body>
</html>