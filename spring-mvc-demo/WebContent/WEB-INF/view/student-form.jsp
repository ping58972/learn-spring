<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Regester Form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student" >
First Name: <form:input path="firstName" />
<br><br>
First Name: <form:input path="lastName" />
<br><br>
<form:select path="country">
<form:options items="${student.countryOptions}" />

</form:select>
<br><br>
Favorite Language:
Java<form:radiobutton path="favoriteLanguage" value="Java"/>
C#<form:radiobutton path="favoriteLanguage" value="C#"/>
Python<form:radiobutton path="favoriteLanguage" value="Python"/>
Javascript<form:radiobutton path="favoriteLanguage" value="Javascript"/>
<br><br>
Operating Systems:
Linux<form:checkbox path="operatingSystems" value="linux"/>
MS Windows<form:checkbox path="operatingSystems" value="MS Windows"/>
Mac OS<form:checkbox path="operatingSystems" value="Mac OS"/>

<br><br>
<input type="submit" value="Submit" />

</form:form>
</body>
</html>