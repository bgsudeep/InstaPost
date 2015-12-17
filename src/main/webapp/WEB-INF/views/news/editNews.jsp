<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="resource/css/instapost.css">
<title>Insert title here</title>
</head>
<body>
	<div class="addform">
	<h1>Add News</h1>
		<form:form modelAttribute="newNews" Method="POST" >
				<form:input type="hidden" path="id"/>
		
		<table>
			<tr>
				<td>&nbsp;</td>
				<td>
					<form:errors path="*" />
				</td>
			</tr>
		    <tr>
		        <td><label for="title"></label>Title:</td>
		        <td>
		            <form:errors path="title" cssClass="error" />
		            <form:input path="title" id="title" />
		        </td>
		    </tr>
		    <tr>
		        <td><label for="description"></label>Description:</td>
		        <td>
		            <form:errors path="description" cssClass="error" />
		            <form:textarea path="description" id="description"  rows="5" cols="30" />
		            
		        </td>
		    </tr>
		    <tr>
		        <td><label for="category"></label>Category:</td>
		        <td>
		            <form:errors path="category" cssClass="error" />
		
		            <form:select id="category" path="category.id">
		                <form:option value="0" label="--Select Category--"/>
		                <form:options items="${categories}" itemLabel="title" itemValue="id"/>
		            </form:select>
		        </td>
		    </tr>
		    
		     <tr>
		        <td>&nbsp;</td>
		        <td>
		            <input type="submit" value="Post" />
		        </td>
		    </tr>		
		</table>
			

		</form:form>
	</div>
	
</body>
</html>