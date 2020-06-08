<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
        
        <h1>Register Form</h1>
        
            <div class="alert alert-success center" role="alert">
				<p>${NOTIFICATION}</p>
			</div>
			

              
                    
                    
                    <form action="<%=request.getContextPath()%>/register" method="post">
                    
                    
                    <div class="form-group">
                    
                    <label for="uname">FirstName</label><input type="text" class="form-control" id="fname" placeholder="firstName" name="firstName" required>
                    
                    </div>
                    
                    
                    <div class="form-group">
                    
                    <label for="uname">LastName</label><input type="text" class="form-control" id="lname" placeholder="lastName" name="lastName" required>
                    
                    </div>
                    
                    
                    <div class="form-group">
                    
                    <label for="uname">UserName</label><input type="text" class="form-control" id="uname" placeholder="userName" name="userName" required>
                    
                    </div>
                    
                    <div class="form-group">
                    
                    <label for="uname">Password</label><input type="password" class="form-control" id="password" placeholder="password" name="password" required>
                    
                    </div>
                    
                    
                    <button type="submit" class="btn btn-primary">Register</button>
                    
                    
                    
                    
                    </form>
                    
                    
                    <div class="container col-md-8 col-md-offset-3">
    
           <button id="myButton" class="float-left submit-button" >Already  registered?</button>
    
    
                  </div>
    
            <script type="text/javascript">
         document.getElementById("myButton").onclick = function () {
            location.href = "<%=request.getContextPath()%>/login/login.jsp";
          };
			</script>
        
        
        
</body>
</html>