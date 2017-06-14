<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html>
<title>Prayaas</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script>
/* function diffDate(){
	//var startdate = Reverse(document.getElementById('startdate'));
	//document.write(startdate);
	//document.write("hello");
	var startdate = reverse(document.getElementById('startdate').innerHTML);
	var enddate = reverse(document.getElementById('enddate').innerHTML);
	alert(enddate);
//var date1 = new Date();
//var date2 = new Date(enddate);
var timeDiff = Math.abs(date2.getTime() - date1.getTime());
var diffDays = Math.ceil(timeDiff / (1000 * 3600 * 24)); 
 document.getElementById('date').innerHTML=diffDays;
  alert(diffDays);
document.getElementById('startdate').innerHTML=startdate;
document.getElementById('enddate').innerHTML=enddate;  
 alert(date1.getDate());
alert(enddate.toString());
alert(diffDays);
 
}
 function reverse(s){
    return( s.split("").reverse().join(""));
}*/  
</script>


<style>
body,h1,h2,h3,h4,h5 {font-family: "Raleway", sans-serif}
</style>
<body class="w3-light-grey">





<%-- <nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="${pageContext.request.contextPath}">Auxilii</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}">Home</a></li>
        <li><a href="${pageContext.request.contextPath}/support">About</a></li>
        <li><a href="#">Projects</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
        <c:if test="${requestScope.notLogin eq 'null'}">
        <li><a  href="user/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </c:if>
        <c:if test="${sessionScope.checkLogin eq 'login'}">
        <li>
         <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">${sessionScope.user.name}<span class="caret"></span></button>
    			<ul class="dropdown-menu">
     			<li><a href="${pageContext.request.contextPath}/user/moredetails">Edit Profile</a></li>
      			<li><a href="${pageContext.request.contextPath }/project/myprojects">My Projects</a></li>
     			 <li><a href="${pageContext.request.contextPath }/user/logout">Logout</a></li>
     			 
    			</ul>
    	</li>
    	</c:if>
      </ul>
     </div>
  </div>
</nav> --%>
  
 
 
 
 

<!-- w3-content defines a container for fixed size centered content, 
and is wrapped around the whole page content, except for the footer in this example -->
<div class="w3-content"  style="max-width:1400px">

<!-- Header -->
<header class="w3-container w3-center w3-padding-32"> 
  <h1><b>${sessionScope.activityInfo.activity_Name }</b></h1>
  <%-- <p>by <span class="w3-tag">${sessionScope.user.name}</span></p> --%>
  <%-- <h4>${requestScope.tx_status }</h4> --%>
</header>

<!-- Grid -->
<div class="w3-row" style="text-align:center;">

<!-- Blog entries -->
<div class="w3-col l8 s12" style="text-align:center;" >
  <!-- Blog entry -->
  <div class="w3-card-4 w3-margin w3-white" style="text-align:center;">
  	<div class="col-md-6">
    <img src="data:image/jpeg;base64,${sessionScope.activityInfo.image }" style="width:100%">
    </div>
    <div class="col-md-6">
    <div class="w3-container w3-padding-8">
      <h3><b>${sessionScope.activityInfo.activity_Name }</b></h3>
      <h5>Activity Date, <span class="w3-opacity">${sessionScope.activityInfo.activity_Startdate}</span></h5>
      <h5>Activity Time, <span class="w3-opacity">${sessionScope.activityInfo.activity_Time}</span></h5>
    </div>

    <div class="w3-container">
      <p>${sessionScope.activityInfo.activity__Description }</p>	
      <div class="w3-row">
      <form action="registeractivity" method="post">
      <input type="submit" value="Register" class="btn btn-primary"/>
      </form>

      </div>
    </div>
    </div>
  </div>
  <hr>

  <!-- Blog entry -->
 <!-- END BLOG ENTRIES -->
</div>

<!-- Introduction menu -->
<div class="w3-col l4">
  <!-- About Card -->
  <div class="w3-card-2 w3-margin w3-margin-top">
  
    <div class="w3-container w3-white">
     
	  
	  
	  
<%-- 	  <p class="col-md-25 hidden-xs">
				
                    <a href="${pageContext.request.contextPath}/donate/donateform"><button class="btn btn-primary btn-lg" style="background-color:skyblue;width:80%;" >
                        <h3>REGISTER</h3>
                    </button>
					</a>
                </p> --%>
	  
               


<!-- 				<p class="col-md-25 hidden-xs">
                   <a href="http://www.facebook.com" target="_new" ><button class="btn btn-primary btn-lg" style="background-color:skyblue;width:80%;" >
                        <h3>Spread Word <i class="fa fa-facebook"></i></h3>
                    </button></a>
                </p>
	   -->
			
			<%-- <i class="fa fa-inr" style="font-size:48px;color:cyan">${sessionScope.projectdetails.collectedAmount}</i> --%>
			
			<%-- <h5>raised of ${sessionScope.projectdetails.goal}  goal</h5>
			<h4>Views : ${sessionScope.projectdetails.views}</h4>
			 --%>
		
  
  <div class="row">
    
 <!--    <div class="col-sm-1" style="background-color:lavenderblush;">Days Left</div> -->
   			<%-- <h4 id="date">days Left</h4>
   			<h4 id="startdate">${sessionScope.projectdetails.dateOfFundRaising}</h4>
   			<h4 id="enddate">${sessionScope.projectdetails.endDate}</h4> --%>
   			
   
 
</div>
			
			
      
    </div>
  </div><hr>
  
  <!-- Posts -->

 
  <!-- Labels / tags -->
 
  
<!-- END Introduction Menu -->
</div>

<!-- END GRID -->
</div><br>

<!-- END w3-content -->
</div>


</body >
</html>
