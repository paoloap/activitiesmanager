<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
	<title> Activities Manager - Welcome</title>
	<spring:url value="/resources/css/login.css" var="loginCss" />
	<link href="${loginCss}" rel="stylesheet" />
	
	<spring:url value="/resources/images/logo.jpg" var="logo" />
</head>

<body>
	<div id="divLogo">
		<img alt="Logo" src="${logo}"/>
	</div>
	<div id="divLogin">
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2> Activities Manager - Welcome, ${pageContext.request.userPrincipal.name}</h2>
		</c:if>
 
 		Qua si implementa il resto

		<h3>
			<a href="<c:url value="/logout" />">ESCI</a>
		</h3>
	</div>
	 
	
</body>
</html>

