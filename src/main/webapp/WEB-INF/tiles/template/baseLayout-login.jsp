<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<style type="text/css">@import url("<c:url value="/resource/css/instapost.css"/>");</style>

<title><tiles:insertAttribute name="title" /></title>

</head>

<body>

	<div class="container">
		<div class="header">
			<div class="header-title">
				<img src="resource/images/LOGO.png" width="70px">
				
			</div>
			<div class="header-title"><h1>InstaPost</h1></div>
			<div class="header-sub">
				<%-- <ul class="">
					<tiles:insertAttribute name="navigation" />
				</ul> --%>
			</div>

		</div>

		<div class="main">
			<tiles:insertAttribute name="body" />
		</div>
		
		<hr>

		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>

	</div>
</body>
</html>
