<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
    <h2>Found School Dress</h2>
 
    <c:forEach var="schooldress" items="${foundschooldressModels}">
        <ul>
          <li>${schooldress.getSchoolTitle()}</li>
          <li>${schooldress.getSchoolName()}</li>
          <li>${schooldress.getSchoolDescription()}</li>
        </ul>
        <hr>
    </c:forEach>
 
</body>
</html>