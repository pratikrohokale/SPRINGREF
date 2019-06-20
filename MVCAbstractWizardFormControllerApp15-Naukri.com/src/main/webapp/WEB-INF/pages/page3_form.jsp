<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<h1 style="color:red;text-align:center">Naukri.com Registration Page2</h1>

<form:form method="post" commandName="regCmd">
    Expected Salary ::: <form:input path="expectedSalary"/> <br>
    Preffered Location ::: <form:input path="prefferedLocation"/> <br>
    <input type="submit"  value="previous" name="_target1">
    <input type="submit"  value="finish" name="_finish">
    <input type="submit"  value="cancel" name="_cancel">
</form:form>    
