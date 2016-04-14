<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
		<title> Activities Manager - Login</title>
		<spring:url value="/resources/css/login.css" var="loginCss" />
		<link href="${loginCss}" rel="stylesheet" />
		
		<spring:url value="/resources/images/logo.jpg" var="logo" />
	</head>
	
	<body>
		<div id="divLogo">
			<img alt="Logo" src="${logo}"/>
		</div>
		<div id="divLogin">
			<h2> Activities Manager - Access</h2>
			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>
	
			<form name='loginForm' action="<c:url value='/login' />" method='POST'>
			    <table>
					<tr>
						<td>Insert username</td>
						<td><input type='text' name='login' value=''></td>
					</tr>
					<tr>
						<td>Insert password</td>
						<td><input type='password' name='password' /></td>
					</tr>
					<tr>
						<td colspan='2' style="height: 50px"></td>
					</tr>
					<tr>
				        <td colspan='2'>
	                    	<input width="80%" name="submit" type="submit" value="Go"/>
	                    </td>
					</tr>
			   </table>
			   <h3>
			   <spring:eval expression="@environment.getProperty('build.environment')" /> <spring:eval expression="@environment.getProperty('build.version')" /></h3>
			   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			</form>
		</div>
	</body>
</html>