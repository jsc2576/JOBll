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
  
  <!--styles-->
   <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
  <link href="/resources/css/login/login.css" rel="stylesheet">
  
  <title>Login</title>
  
</head>

<body>
<c:url value="/authLogin.do" var="actionUrl"/>
<form role="form" action="${actionUrl}" method="post">       
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
         <div class="login-form form-group">
          	<p>
          		<label for="username">Username</label>
				<input type="text" id="username" name="username"/>	
			</p>
			<p>
				<label for="password">Password</label>
				<input type="password" id="password" name="password"/>	
				<a class="login-link" href="#">Lost your password?</a>
				<a class="login-link" href="/usrInfoJoin">Join Us</a>
			</p>
		
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button type="submit" class="btn">Log in</button>
         </div>
         <center>
         <div class="form-group">
         	<a class="SNS-login" href="#"><img class="img-responsive SignWithSNS" alt="Signup with Facebook" src="/resources/images/SignFacebook.jpg"></a>
         	<a class="SNS-login" href="#"><img class="img-responsive SignWithSNS" alt="Signup with Twitter" src="/resources/images/SignTwitter.jpg"></a>
         	<a class="SNS-login" href="#"><img class="img-responsive SignWithSNS" alt="Signup with Google" src="/resources/images/SignGoogle.jpg"></a>
         </div>
         </center>
      </div>
   </div>
   
	
</form>
</body>
</html>