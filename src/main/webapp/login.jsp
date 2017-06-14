<!DOCTYPE html>
<html lang="en">
    <head>
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  		<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="css/login.css" rel="stylesheet">
        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">

		<script>
			function loginValid()
		        {
		        	var user_Email = document.getElementById('user_Email').value;
		            var user_Password = document.getElementById('user_Password').value;
		            var error = document.getElementById('error');
	
		            
			           	error.innerHTML = "";
			           	var request=new XMLHttpRequest();
			           	request.onreadystatechange= function()
			           	{
			               	if(request.readyState==4)
			               	{  //wait for response
			                   	var resp=request.responseText;
			                   	if(resp=="success")
			                       	window.open("Activity.jsp","_self")
			                   	else if(resp == "admin" )
				                   	window.open("uploadactivity.jsp", "_self");
		                   		else
			               		{
		                   			error.innerHTML = "Invalid Username or Password";
		                       		error.style.color = "red";
			               		}
			               	}
		           		};
		                request.open("POST","loginCheck?user_Email="+user_Email+"&user_Password="+user_Password,true);
		                request.send();
		                   
		        }	        
	       </script>
    </head>
    <body>
        <!-- <div class="login">
            <h2>Login</h2>
            <div>
                <input type="text" required name="emailId" id="user_Email" placeholder="Enter Username"><br><br>
                <input type="password" required name="password" id="user_Password" placeholder="Enter Password"><br><br>
                <input type="submit" onclick="loginValid()" value="Login">
                <p id="error"></p>
            </div>
        </div> -->
        
        
<div class="container">
<h1><a href="index.jsp" style="text-decoration: none;">Prayaas</a></h1>
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
            <h4>Welcome Back</h4>
            <input type="email" class="form-control input-sm chat-input" placeholder="Username" id="user_Email" required="required"/>
            </br>
            <input type="password" class="form-control input-sm chat-input" placeholder="Password" id="user_Password" required="required" />
            </br>
            <div class="wrapper">
            <span class="group-btn">     
                <!-- <a href="#" class="btn btn-primary btn-md">Login<i class="fa fa-sign-in"></i></a> -->
                <input type="submit" value="Login" class="btn btn-primary btn-md" onclick="loginValid()"/>
            </span>
            </div>
            <br>
            <br>
            <p id="error"></p>
            </div>
        </div>
    </div>
</div>
    </body>
</html>
