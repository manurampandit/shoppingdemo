<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<html>  
<head>  
<title>Add Address</title>  
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
 text-align: left;  
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
  
    
   
   
 <b> Address Form </b>   
  
 <div>  
   <form:form method="post" action="/control/successPage" modelAttribute="address">  
   
   
    <table>  
     <tr>  
      <td>Street Name :</td>  
      <td>${map.address.streetName}</td>  
     </tr>  
      
     <tr>  
      <td>City :</td>  
      <td>${map.address.city}</td>  
     </tr>
     
     <tr>  
      <td>State :</td>  
      <td>${map.address.state}</td>  
     </tr> 
     
     <tr>  
      <td>Pin Code:</td>  
      <td>${map.address.pincode}</td>  
     </tr>
     
     <tr>  
      <td>Item Id:</td>  
      <td>${map.item.itemId}</td>  
     </tr>
     
     <tr>  
      <td> </td>  
      <td><input type="submit" value="Confirm" /></td>  
     </tr> 
      
    </table>  
  </form:form>  
  </div>  
   
</body>  
</html>  
