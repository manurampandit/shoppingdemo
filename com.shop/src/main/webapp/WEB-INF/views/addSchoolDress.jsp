<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h1>Add Record to Book Table</h1>
	<form:form action="addSchoolDressToDB" method="post">
      School Title: <form:input path="schoolTitle" />
		<br />
      School Name: <form:input path="schoolName" />
		<br />
      School Description:<br />
		<form:textarea path="schoolDescription" rows="20" />
		<br />
		<input type="reset" />
		<input type="submit" />
	</form:form>
</body>
</html>