<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>


 <div class="alert alert-success center" role="alert">
				<p>${NOTIFICATION_From_login}</p>
			</div>

<h2>Login Page</h2>

	<div class="container col-md-8 col-md-offset-3" style="overflow: auto">
      <form action="<%=request.getContextPath()%>/login" method="post">

		<div class="form-group" >
		
		<label for="uname">UserName</label><input type="text" name="username" placeholder="User Name" required/>
		
		</div>
		
		
		<div class="form-group">
		
		<label for="password">Password</label><input type="password" name="password" placeholder="Password"required/>
		
		
		<button type="submit" class="btn btn-primary">Submit</button>
		
		</div>


    </form>
    
    </div>
    
    <div class="container col-md-8 col-md-offset-3">
    
    <button id="myButton" class="float-left submit-button" >Not registered?</button>
    
    
    </div>
    
    <script type="text/javascript">
    document.getElementById("myButton").onclick = function () {
        location.href = "<%=request.getContextPath()%>/register/register.jsp";
    };
   </script>
    
    
    





</body>
</html>









