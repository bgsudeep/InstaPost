<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<section>
	<div class="jumbotron">
		<div class="container">
			<h1>Add a new User</h1>
			<p>
		</div>
	</div>
	</section>
	<section class="container"> <form:form
		modelAttribute="newEmployee" class="form-horizontal">
		<fieldset>
			<legend>New User</legend>

			<form:errors path="*" cssClass="alert alert-danger" element="div" />
			

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
						<form:input id="lastName" path="firstName" type="text"
							class="form:input-large" />
						<form:errors path="lastName" cssClass="text-danger" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="Email">Email</label>
				<div class="col-lg-10">
					<div class="form:input-prepend">
						<form:input id="City" path="address.city" type="text"
							class="form:input-large" />
						<form:errors path="address.city" cssClass="text-danger" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2" for="State">State</label>
				<div class="col-lg-10">
					<div class="form:input-prepend">
						<form:input id="State" path="address.state" type="text"
							class="form:input-large" />
						<form:errors path="address.state" cssClass="text-danger" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="Add" />
				</div>
			</div>

		</fieldset>
	</form:form> </section>

</body>
</html>