<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- <link rel="stylesheet"	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
 -->
<title>Products</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Please sign in</h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<br />
							</div>
						</c:if>
						<form action="<spring:url value="/postLogin"></spring:url>"
							method="post">
							<fieldset>
								<div class="form-group">
									<input class="form:input-large" placeholder="Email"
										name='email' type="text">
								</div>
								<div class="form-group">
									<input class=" form:input-large" placeholder="Password"
										name='password' type="password" value="">
								</div>
								<input class="btn btn-lg btn-success btn-mini" type="submit"
									value="Login">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%-- <form action="<spring:url value="/j_spring_security_check" /> method="post">
		<div class="form-group">
			<input placeholder="User Name" name='j_username' type="text">
			<input placeholder="Password" name='j_password' type="password"
				value="">
		</div>
		<input type="submit" value="Login">
	</form> --%>

</body>