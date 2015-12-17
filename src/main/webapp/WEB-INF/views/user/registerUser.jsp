<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:url var="saveAction" value="/register"></c:url>

	<c:set var="addEdit" value="Add a new " />

	<c:if test="${!empty mode}">
		<c:set var="addEdit" value="Edit " />
	</c:if>

	<section>
	<div class="jumbotron">
		<div class="container">
			<h1 class="panel-title">${addEdit}User</h1>
			<p>
		</div>
	</div>
	</section>
	<section class="container"> <form:form modelAttribute="user"
		action="${saveAction}" class="form-horizontal">
		<fieldset>
			<c:if test="${empty user.firstName}">
				<legend>New User</legend>
			</c:if>


			<form:input type="hidden" path="id" name="id" />
			<%-- <form:errors path="*" cssClass="alert alert-danger" element="div" /> --%>

			<div class="form-group">
				<label class="control-label col-lg-2" for="firstName">First
					Name</label>
				<div class="col-lg-10">
					<form:input id="firstName" path="firstName" type="text"
						class="form:input-large" />
					<form:errors path="firstName" cssClass="text-danger" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="lastName">Last
					Name</label>
				<div class="col-lg-10">
					<div class="form:input-prepend">
						<form:input id="lastName" path="lastName" type="text"
							class="form:input-large" />
						<form:errors path="lastName" cssClass="text-danger" />
					</div>
				</div>
			</div>
			<c:if test="${!empty mode}">
				<c:set var="readOnly" value="true" />
			</c:if>


			<div class="form-group">
				<label class="control-label col-lg-2" for="Email">Email</label>
				<div class="col-lg-10">
					<div class="form:input-prepend">
						<form:input id="email" path="email" type="text"
							class="form:input-large" readonly="${readOnly}" />
						<form:errors path="email" cssClass="text-danger" />
					</div>
				</div>
			</div>

			<form:input id="enabled" path="enabled" type="hidden" value="true" />

			<div class="form-group">
				<label class="control-label col-lg-2" for="Password">Password</label>
				<div class="col-lg-10">
					<div class="form:input-prepend">
						<form:input id="password" path="password" type="password"
							class="form:input-large" />
						<form:errors path="password" cssClass="text-danger" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="Role">Role</label>
				<div class="col-lg-10">
					<div class="form:input-prepend">

						<form:select path="role.id">
							<form:option value="NONE"> --SELECT--</form:option>
							<form:options items="${roles}" itemLabel="name" itemValue="id" />
						</form:select>
						<form:errors path="role.id" cssClass="text-danger" />
					</div>
				</div>
			</div>


			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="Save" />
				</div>
			</div>

		</fieldset>
	</form:form> </section>

</body>
</html>