<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!-- saved from url=(0014)about:internet -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Please sign in</title>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<link
	href="https://getbootstrap.com/docs/4.0/examples/signin/signin.css"
	rel="stylesheet"
	integrity="sha384-oOE/3m0LUMPub4kaC09mrdEhIc+e3exm4xOGxAmuFXhBNF4hcg/6MiAXAf5p0P56"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form class="form-signin" method="post"
			action="/register/add">
			<h2 class="form-signin-heading">Please sign in</h2>
			<p>
				<label for="username" class="sr-only">UserName</label> <input
					type="text" id="userName" name="userName" class="form-control"
					placeholder="UserName" required>
			</p>
			<p>
				<label for="email" class="sr-only">email</label> <input
					type="email" id="userEmail" name="userEmail" class="form-control"
					placeholder="Email" required>
			</p>
			<p>
				<label for="password" class="sr-only">Password</label> <input
					type="password" id="userPassword" name="userPassword" class="form-control"
					placeholder="Password" required>
			</p>
			<p>
				<label for="Age" class="sr-only">Age</label> <input
					type="number" id="userAge" name="userAge" class="form-control"
					placeholder="Age" required>
			</p>
		<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
				<p><a href="/login">Login</a>
		</form>
	</div>
</body>
</html>