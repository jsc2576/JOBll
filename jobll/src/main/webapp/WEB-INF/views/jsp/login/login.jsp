<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <link href="/resources/css/login/login.css" rel="stylesheet">
  <title>Login</title>
  
</head>

<body>
<c:url value="/authLogin.do" var="actionUrl"/>
<form action="${actionUrl}" method="post">       
	<c:if test="${param.error != null}">        
		<p>
			Invalid username and password.
		</p>
	</c:if>
	<c:if test="${param.logout != null}">       
		<p>
			You have been logged out.
		</p>
	</c:if>

<div class="login">
      <div class="login-screen">

         <div class="login-form">
            <div class="control-group">
            <input type="text" class="login-field" value="" placeholder="username" id="username">
            <label for="username" class="login-field-icon fui-user">Username</label>
            </div>

            <div class="control-group">
            <input type="password" class="login-field" value="" placeholder="password" id="password" >
            <label class="login-field-icon fui-lock" for="password">Password</label>

            </div>

            <a class="btn btn-primary btn-large btn-block" href="#">login</a>
            <a class="login-link" href="#">Lost your password?</a>
          	<p>
          		<label for="username">Username</label>
				<input type="text" id="username" name="username"/>	
			</p>
			<p>
				<label for="password">Password</label>
				<input type="password" id="password" name="password"/>	
			</p>
		
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button type="submit" class="btn">Log in</button>
         </div>
      </div>
   </div>
   
	
</form>
</body>
</html>