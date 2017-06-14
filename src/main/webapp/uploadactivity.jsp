<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Upload Activity</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="css/datepicker.css">
<link rel="stylesheet" href="css/registration-form-with-bootstarp.css">
 -->
</head>

<body>
   <div class="container">
      <div class="row">
      <h1>Prayaas</h1>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10" style="text-align: right;">
            <button type="button" class="btn btn-primary" id="register" value="Logout" onclick="location.href = 'logout';">Logout</button>
          </div>
       </div>
        <div class="page-header">
  		  <h2>Upload Activity</h2>
	    </div>
        <form:form class="form-horizontal" role="form" method="post" action="${pageContext.request.contextPath}/upload" modelAttribute="activitytable" enctype="multipart/form-data">
 		  
          <div class="form-group">
   			  <label for="firstName" class="col-sm-2 control-label">Name:</label>
    	    <div class="col-sm-6">
              <input type="text" name="activity_Name" class="form-control" id="activityName" placeholder="Name of  the activity" required="required" pattern="^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$">
            </div>
          </div>
          <div class="form-group">
   			  <label for="firstName" class="col-sm-2 control-label">Venue:</label>
    	    <div class="col-sm-6">
              <input type="text" name="activity_Address" class="form-control" id="activityName" placeholder="Address of the activity" required="required">
            </div>
          </div>          
          <div class="form-group">
   			  <label for="lastName" class="col-sm-2 control-label">City:</label>
    	    <div class="col-sm-6">
              <input type="text" name="activity_City" class="form-control" id="city" placeholder="City" required="required" pattern="^([A-Za-z]+[,.]?[ ]?|[A-Za-z]+['-]?)+$">
            </div>
          </div>
          <div class="form-group">
             <label for="passwd" class="col-sm-2 control-label">Start Date:</label>
			
           <div class="col-sm-6">
      		<input type="Date" name="activity_Startdate" class="form-control" id="startdate" placeholder="Starting Date" required="required">
		
           </div> 
         </div>
           <div class="form-group">
             <label for="passwd" class="col-sm-2 control-label">End Date:</label>
           <div class="col-sm-6">
      		 <input type="Date" name="activity_Enddate" class="form-control" id="enddate" placeholder="Ending Date" required="required">
           </div>
         </div>
          
          
         <!-- <div class="form-group">
   			  <label for="dob" class="col-sm-2 control-label">DOB:</label>
    	    <div class="col-sm-6">
              <input type="text" name="dob" class="form-control datepicker" id="dob" placeholder=" Date of Birth">
            </div>
          </div>-->
          
          <div class="form-group">
   			  <label for="userName" class="col-sm-2 control-label">Description:</label>
    	    <div class="col-sm-6">
              <input type="text" name="activity__Description" class="form-control" id="description" placeholder="Details" required="required">
            </div>
          </div>
  
         <div class="form-group">
             <label for="passwd" class="col-sm-2 control-label">Time:</label>
           <div class="col-sm-6">
      		 <input type="text" name="Activity_Time" class="form-control" required="required">
           </div>
         </div>
		 
		<div class="form-group" >
		<label class="control-label col-sm-2" for="img">Image:</label>
		<label class="custom-file">
		<div class="col-sm-10">
			<input type="file" id="file" name="file" class="upload-file" data-max-size="2000048" required="required" />
			<span class="custom-file-control"></span>
		</div>
		</label>
		</div>
          
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-primary" id="register">Upload</button>
          </div>
       </div>
		
     </form:form>
        
<!--         <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="button" class="btn btn-primary" id="register" value="Logout" onclick="location.href = 'logout';">Logout</button>
          </div>
       </div> -->
         
      </div><!-- end for class "row" -->
   </div><!-- end for class "container" -->
   
   <script type="text/javascript" src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <!--  <script type="text/javascript" src="js/bootstrap-datepicker.js"></script>
   <script type="text/javascript" src="js/registration-form-with-bootstarp.js"></script> -->
   
   
</body>
</html>  




