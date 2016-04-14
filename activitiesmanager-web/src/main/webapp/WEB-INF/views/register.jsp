<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
	<head>
		<title> Activities Manager - Register</title>
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
			<c:if test="${not empty errorr}">
				<div class="errorr">${errorr}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="errord">${errord}</div>
			</c:if>
			<form:form name='user' action="<c:url value='/register' />" method='POST' modelAttribute='user'>
				<table>
					<form:input path='id' hidden='true'/>
					<tr>
						<td>Username</td>
						<td><form:input type='text' name='login' value='' path='login'/></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><form:input type='password' name='password'  path='password'/></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><form:input type='text' name='name' value='' path='name'/></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><form:input type='text' name='address' value='' path='address'/></td>
					</tr>
					<tr>
						<td>Birthday</td>
						<td><form:input type='text' name='birthday' value='' path='birthday'/></td>
					</tr>
					<tr>
						<td>City</td>
						<td><form:input type='text' name='city' value='' path='city'/></td>
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
			</form:form>
		</div>
	</body>
</html>