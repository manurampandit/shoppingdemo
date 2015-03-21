<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title> User List</title>
<style>
body {
 font-size: 20px;
 color: teal;
 font-family: Calibri;
}

td {
 font-size: 15px;
 color: black;
 width: 100px;
 height: 22px;
 text-align: center;
}
.heading {
 font-size: 18px;
 color: white;
 font: bold;
 background-color: orange;
 border: thick;
}
</style>
</head>
<body>
 <center>
  
 
 
 <b>Item Details.. !!! </b>
   
  <table border="1">
    <tr>
     <td>Item Details and Pic here
     <img src="C:\\Users\\Saurabh\\Desktop\\metromap.jpg" />
     </td>
<%--      <td><a href="delete?id=${itemId}">OrderNow</a></td> --%>
	 <td><a href="order?itemId=10">OrderNow</a></td>
    </tr>
  </table>

 </center>
</body>
</html>
