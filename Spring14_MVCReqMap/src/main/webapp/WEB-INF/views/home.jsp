<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>



<form action="studentIdOnly" method="get">
	student id : <input type="text" name="studentId">
	<input type="submit" value="submit!">
</form>
<br/>



<form action="studentData" method="get">
	student name : <input type="text" name="name"> <br/>
	student age : <input type="text" name="age"> <br/>
	student grade : <input type="text" name="gradeNum"> <br/>
	student class : <input type="text" name="classNum"> <br/>
	<input type="submit" value="submit!">
</form>
<br/>



</body>
</html>
