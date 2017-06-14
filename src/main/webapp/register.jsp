<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Registration Form </title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="css/datepicker.css"> -->
<!-- <link rel="stylesheet" href="css/registration-form-with-bootstarp.css"> -->
</head>
<body>
   <div class="container">
   <h1><a href="index.jsp" style="text-decoration: none;">Prayaas</a></h1>
   
      <div class="row">
        <div class="page-header">
  		  <h2>Registration Form </h2>
	    </div>
        <form:form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/register" modelAttribute="usertable">
 		  
          <div class="form-group">
   			  <label for="firstName" class="col-sm-2 control-label">Name:</label>
    	    <div class="col-sm-6">
              <input type="text" name="user_Name" class="form-control" id="firstName" placeholder="First Name" required="required" pattern="^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$">
            </div>
          </div>
          
          <div class="form-group">
   			  <label for="lastName" class="col-sm-2 control-label">City:</label>
    	    <div class="col-sm-6">
              <input type="text" name="user_City" class="form-control" id="city" placeholder="City" required="required"	pattern="^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$">
            </div>
          </div>
          <div class="form-group">
             <label for="passwd" class="col-sm-2 control-label">Email:</label>
           <div class="col-sm-6">
      		 <input type="email" name="user_Email" class="form-control" id="email" placeholder="Email" required="required">
           </div>
         </div>
          
           <div class="form-group">
             <label for="" class="col-sm-2 control-label">Gender:</label> 
           <div class="col-sm-6">
             <label class="radio-inline">
  				<input type="radio" name="gender" id="gender" value="male" required="required">Male
			 </label>
			<label class="radio-inline">
  				<input type="radio" name="gender" id="gender" value="female" required="required">Female
			</label>
			
           </div>
        </div>
      
          
          <div class="form-group">
   			  <label for="userName" class="col-sm-2 control-label">Mobile No:</label>
    	    <div class="col-sm-6">
              <input type="text" name="mobile_No" class="form-control" id="mobileno" place holder="Mobile No" required="required" pattern="[789][0-9]{9}">
            </div>
          </div>
  
         <div class="form-group">
             <label for="passwd" class="col-sm-2 control-label">Password:</label>
           <div class="col-sm-6">
      		 <input type="password" name="user_Password" class="form-control" id="passwd" placeholder="Password" required="required" pattern="(?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$">
           </div>
         </div>
          
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary" id="register">Register</button>
          </div>
       </div>
	
     </form:form>
         
      </div><!-- end for class "row" -->
   </div><!-- end for class "container" -->
   
   <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <!--  <script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
   <script type="text/javascript" src="js/registration-form-with-bootstarp.js"></script> -->
   
   
</body>
</html>  





</div> <!-- end of the margin:... -->
             
             
                </div>
                      
                </div>
