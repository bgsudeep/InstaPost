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
<title>List Category</title>
</head>
<body>

	<ul>
		<li><a href="<c:url value='/admin/news/list'/>">All</a></li>
		<li><a href="<c:url value='/admin/news/unpublished'/>">Unpublished</a>
		</li>
		<li><a href="<c:url value='/admin/news/published'/>">Published</a>
		</li>

		<c:forEach var="magazine" items="${listMagazines}">


			<li><spring:url value="/magazine/{id}/news" var="viewMagazine">
					<spring:param name="id" value="${magazine.id}" />
				</spring:url> <a href="${viewMagazine}">${magazine.title}</a></li>
		</c:forEach>

	</ul>
	<security:authorize access="hasRole('ROLE_USER')">
		<div align="right">
			<a href="<spring:url value='add' />"> <b>Add News</b>
			</a>
		</div>
	</security:authorize>
	<hr>
	<div class="list">
		<c:forEach var="news" items="${listNews}">
			<table width=100%>
				<tr>
					<td width="50%">
						<h3>${news.title}</h3>

					</td>

					<security:authentication var="principal" property="principal" />

					<security:authorize access="hasRole('ROLE_USER')">
						<c:if test="${news.user.email eq principal.username }">

							<%-- <form:form action="/magazine/news/add" modelAttribute="magazine">
								<form:input type="hidden" path="id" id="${news.id}" />
								<form:input type="hidden" path="title" id="${news.title}" />
								<form:input type="hidden" path="description" id="${news.description}" />
								<form:input type="hidden" path="isPublish" id="${news.publish}" />
								<form:input type="hidden" path="publishDate" id="${news.publishDate}" />
								<form:input type="hidden" path="category.id" id="${news.category.id}" />
								<form:input type="hidden" path="user.id" id="${news.user.id}" />

								<form:select path="id">
									<form:option value="NONE"> --SELECT--</form:option>
									<form:options items="${listMagazines}" itemLabel="title" itemValue="id" />
								</form:select>

								<input type="submit" value="Add">
							</form:form> --%>


							<%-- <select name="magazineId">
								<c:forEach items="${listMagazines}" var="magazine">
									<option value="${magazine}"
										${magazine == selectedMagazine ? 'selected' : ''}>${magazine.title}
										<spring:url value="/magazine/{id}/news/{mag}"
										var="viewMagazine">
										<spring:param name="id" value="${news.id}" />
										<spring:param name="mag" value="${magazine.title}" />

									</spring:url>
										</option>

									
								</c:forEach>
							</select> --%>
							
						
					<%-- <h1>m</h1>${viewMagazine} --%>
							

							<form:form method="POST" action="/InstaPost/magazine/news/add">
								<input type="hidden" name="newsId" value='${news.id}' />
								<select
									name="magazineId">
									<c:forEach items="${listMagazines}" var="magazine">
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

					<security:authorize access="hasRole('ROLE_ADMIN')">
						<c:choose>
							<c:when test="${news.publish eq true }">
								<td width="30%" align="right"><spring:url
										value="/admin/news/unpublish/{id}" var="unpublish">
										<spring:param name="id" value="${news.id}" />
									</spring:url> <a href="${unpublish}">Un-Publish</a>&nbsp; &nbsp;</td>
							</c:when>
							<c:otherwise>
								<td width="30%" align="right"><spring:url
										value="/admin/news/publish/{id}" var="publish">
										<spring:param name="id" value="${news.id}" />
									</spring:url> <a href="${publish}">Publish</a>&nbsp; &nbsp;</td>
							</c:otherwise>
						</c:choose>
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