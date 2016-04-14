<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page session="true"%>
<html>
<head>
	<title>TITOLO</title>
	<spring:url value="/resources/css/login.css" var="loginCss" />
	<link href="${loginCss}" rel="stylesheet" />
	
	<spring:url value="/resources/images/logo.png" var="logo" />
</head>

<body>
	<div id="divLogo"><img alt="Logo" src="${logo}"/> <h4>Not Authorized</h4></div>
	<h2>qui c'era "${errorMessage}"</h2>
	<h3>
		<a href="<c:url value="/welcome" />">Come back to access page</a><br/>
		<a href="<c:url value="/logout" />">Logout</a>
	</h3>
</body>
</html>
