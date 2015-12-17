<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>About Us</title>
<style type="text/css">
@import
url(
"<c:url value="
/
InstaPost
/resource/css/instapost.css"/>");
</style>

</head>
<body>
	<div id="mainbody">
		<div class="developer-details">
			<div class="developer-description">
				<p>
				<h1>SAGAR GIRI</h1>

				<h3>Python/Django, Java Developer</h3>
				Computer Software <br>Previous Real Solutions Pvt. Ltd., Janaki
				Technology Pvt. Ltd. [ Sparrow SMS, Picovico, SocialAves ]<br>
				Education Maharishi University of Management

				</p>
			</div>
			<p>
				<img width="150px" height="200px"
					src="<spring:url value='/resources/images/developersPhotos/sagar.JPG' />" />
			</p>
		</div>

		<div class="developer-details">
			<div class="developer-description">
				<p>
				<h1>SUNITA POUDEL</h1>
				<h3>Java Software Engineer</h3>
				NepalComputer Software Previous Virtual Web Technology, Radio
				Janani, Pokhara <br>Education Maharishi University of
				Management

				</p>
			</div>
			<p>
				<img width="150px" height="200px"
					src="<spring:url value='/resources/images/developersPhotos/sunita.JPG' />" />
			</p>
		</div>


		<div class="developer-details">
			<div class="developer-description">
				<p>
				<h1>SUNIL GURUNG</h1>
				<h3>Software Engineer</h3>
				NepalNonprofit Organization Management <br>Current: Digital
				Society Research and Development, Dynamic Softech Computer Solution
				<br>Previous: yagiten pvt.ltd Education Gandaki college of
				science and technology

				</p>
			</div>
			<p>
				<img width="150px" height="200px"
					src="<spring:url value='/resources/images/developersPhotos/sunil.JPG' />" />
			</p>
		</div>

		<div class="developer-details">
			<div class="developer-description">
				<p>
				<h1>SUDEEP BAGALE</h1>
				<h3>Software Engineer</h3>
				Student at Maharishi University of Management <br>
				NepalComputer Software <br>Previous: Neolinx Pvt Ltd.<br>
				Education Maharishi University of Management

				</p>
			</div>
			<p>
				<img width="150px" height="200px"
					src="<spring:url value='/resources/images/developersPhotos/sudeep.JPG' />" />
			</p>
		</div>

	</div>

</body>
</html>

