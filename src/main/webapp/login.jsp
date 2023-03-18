<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="Css/login.css">
<script src="Javascript/login.js"></script>
</head>
<body>
	<div class="login-container">
		<div class="login-body-container">
			<span id="close">x</span> <img src="Image/login_image.png">
			<!-- invoke function validateFromSubmid()  -->
			<form name="login-form"
				action="/PRJ321x_Assignment_1_sonfx17102/login"
				 method="post">
				<span>Username</span> <input class="input-box" type="text"
					name="username"> <span>Password</span> <input
					class="input-box" type="password" name="password"> <input
					class="submit-button" type="submit" onclick = "validateFormSubmit()"value="LOGIN">
				<div>
					<input type="checkbox" name="rememberme"> <label
						for="rememberme">Remember me</label>
				</div>
			</form>
		</div>
		<div class="login-footer-container clearfix">
			<input type="button" value="Cancel"> <a href="#">Forgot
				password?</a>
		</div>
	</div>

</body>

</html>