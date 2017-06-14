<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Prayaas</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script
  src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
  <h1>Prayaas</h1>     
  
  <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10" style="text-align: right;">
            <button type="button" class="btn btn-primary" id="register" value="Logout" onclick="location.href = 'logout';">Logout</button>
          </div>
       </div>
       
  <table class="table">
    <thead>
      <tr>
        <th>Event Name</th>
        <th>City</th>
        <th>Date</th>
        <th>Reporting Time</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach var="activity" items="${sessionScope.activityTable}">
    <form action="activityinfo" method="post" >
     <tr>
       
        <td>${activity.activity_Name}</td>
        <td>${activity.activity_City }</td>
        <td>${activity.activity_Startdate }</td>
        <td>${activity.activity_Time}</td>
        <td><input type="hidden" name="activity_Id" value="${activity.activity_Id}"/></td>
        <td><input type="submit" value="View"></td>
        
      </tr>
      </form>
      </c:forEach>
     
    </tbody>
    
  </table>
</div>

</body>
</html>