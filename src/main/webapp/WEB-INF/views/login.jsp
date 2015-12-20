<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript"
	src="<spring:url value="/resource/js/ajax.js"/>"></script>
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
							<div class="invalid alert alert-danger">
								Invalid email or password
								<br />
							</div>
						</c:if>
						<form action="<spring:url value="/postLogin"></spring:url>"
							method="post">
							<fieldset>
								<div class="form-group">
									<input class="form:input-large" placeholder="Email"
										name='email' type="text">
										<form:errors path="email" cssClass="text-danger" />
								</div>
								<div class="form-group">
									<input class=" form:input-large" placeholder="Password"
										name='password' type="password" value="">
										<form:errors path="password" cssClass="text-danger" />
								</div>
								<div class="btn-signin">
									<input class="btn btn-lg btn-success btn-mini" type="submit"
										value="Login"></br>
								</div>

								<div class="signup">
									No account? <a href="<c:url value='/register'/>">Register
										here.</a>
								</div>

							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%-- 
	<section class="container">
    <div class="login">
      <h1>Login to Web App</h1>
      <form method="post" action="index.html">
        <p><input type="text" name="login" value="" placeholder="Username or Email"></p>
        <p><input type="password" name="password" value="" placeholder="Password"></p>
        <p class="remember_me">
          <label>
            <input type="checkbox" name="remember_me" id="remember_me">
            Remember me on this computer
          </label>
        </p>
        <p class="submit"><input type="submit" name="commit" value="Login"></p>
      </form>
    </div>

    <div class="login-help">
      <p>Forgot your password? <a href="index.html">Click here to reset it</a>.</p>
    </div>
  </section>

  <section class="about">
    <p class="about-links">
      <a href="http://www.cssflow.com/snippets/login-form" target="_parent">View Article</a>
      <a href="http://www.cssflow.com/snippets/login-form.zip" target="_parent">Download</a>
    </p>
    <p class="about-author">
      &copy; 2012&ndash;2013 <a href="http://thibaut.me" target="_blank">Thibaut Courouble</a> -
      <a href="http://www.cssflow.com/mit-license" target="_blank">MIT License</a><br>
      Original PSD by <a href="http://www.premiumpixels.com/freebies/clean-simple-login-form-psd/" target="_blank">Orman Clark</a>
  </section>
  
   --%>



	<%-- <form action="<spring:url value="/j_spring_security_check" /> method="post">
		<div class="form-group">
			<input placeholder="User Name" name='j_username' type="text">
			<input placeholder="Password" name='j_password' type="password"
				value="">
		</div>
		<input type="submit" value="Login">
	</form> --%>

</body>