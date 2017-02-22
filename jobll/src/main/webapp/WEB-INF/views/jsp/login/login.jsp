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
<script>
 // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // The response object is returned with a status field that lets the
    // app know the current login status of the person.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      // Logged into your app and Facebook.
      testAPI();
    } else if (response.status === 'not_authorized') {
      // The person is logged into Facebook, but not your app.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into this app.';
    } else {
      // The person is not logged into Facebook, so we're not sure if
      // they are logged into this app or not.
      document.getElementById('status').innerHTML = 'Please log ' +
        'into Facebook.';
    }
  }

  // This function is called when someone finishes with the Login
  // Button.  See the onlogin handler attached to it in the sample
  // code below.
  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
  FB.init({
    appId      : '366772880369736',
    cookie     : true,  // enable cookies to allow the server to access 
                        // the session
    xfbml      : true,  // parse social plugins on this page
    version    : 'v2.8' // use graph api version 2.8
  });

  // Now that we've initialized the JavaScript SDK, we call 
  // FB.getLoginStatus().  This function gets the state of the
  // person visiting this page and can return one of three states to
  // the callback you provide.  They can be:
  //
  // 1. Logged into your app ('connected')
  // 2. Logged into Facebook, but not your app ('not_authorized')
  // 3. Not logged into Facebook and can't tell if they are logged into
  //    your app or not.
  //
  // These three cases are handled in the callback function.

  FB.getLoginStatus(function(response) {
    statusChangeCallback(response);
  });

  };

  // Load the SDK asynchronously
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

  // Here we run a very simple test of the Graph API after login is
  // successful.  See statusChangeCallback() for when this call is made.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
    });
  }
  function facebooklogin() {
  FB.login(function(response) {
	  if (response.status === 'connected') {
		  /*
		  var fbname;
		      var accessToken = response.authResponse.accessToken;
		      FB.api(‘/me’, function(user) {
		                 fbname = user.name;
		         userid = user.id;
		     });
		*/
	    // Logged into your app and Facebook.
	  } else if (response.status === 'not_authorized') {
	    // The person is logged into Facebook, but not your app.
	  } else {
	    // The person is not logged into Facebook, so we're not sure if
	    // they are logged into this app or not.
	  }
	});
  }

  </script>


<c:url value="/authLogin.do" var="actionUrl"/>
       
	<div class="login">
      <div class="login-screen">
      <form role="form" action="${actionUrl}" method="post">
         <div class="login-form form-group">
          	<p>
          		<label for="username">Username</label>
				<input type="text" id="username" name="username"/>	
			</p>
			<p>
				<label for="password">Password</label>
				<input type="password" id="password" name="password"/>
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
				<a class="login-link" href="#">Lost your password?</a>
				<a class="login-link" href="/usrInfoJoin">Join Us</a>
			</p>
		
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<button type="submit" class="btn">Log in</button>
         </div>
      </form>
	         <div class="form-group">
		         <form action="/signin/facebook" method="POST">
		         	<a class="SNS-login"><img onclick="submit()" class="img-responsive SignWithSNS" alt="Signup with Facebook" src="/resources/images/SignFacebook.jpg"></a>
		         </form>
		         	<a class="SNS-login" href="#"><img class="img-responsive SignWithSNS" alt="Signup with Twitter" src="/resources/images/SignTwitter.jpg"></a>
		         	<a class="SNS-login" href="#"><img class="img-responsive SignWithSNS" alt="Signup with Google" src="/resources/images/SignGoogle.jpg"></a>
	         </div>
      </div>
   </div>
   <form action="/logout.do" method="POST">
   </form>
</body>
</html>