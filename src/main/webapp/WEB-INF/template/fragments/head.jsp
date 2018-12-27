<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>Address Book - ${param.page}</title>
<link
	href="${pageContext.request.contextPath}/assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/css/main.css"
	rel="stylesheet">
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand" href="${pageContext.request.contextPath}"><i class="far fa-address-book"></i> Address
			Book</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="${pageContext.request.contextPath}"><i class="fas fa-home"></i> Home<span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"><i class="fas fa-phone"></i> Contacts</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown">
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/contacts?action=list"><i class="fas fa-list-ul"></i> List</a>
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/contacts?action=new"><i class="fas fa-plus"></i> New</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="#"><i class="fas fa-list-ol"></i> Todo List</a>
				</li>
			</ul>
		</div>
	</nav>

	<div class="container">