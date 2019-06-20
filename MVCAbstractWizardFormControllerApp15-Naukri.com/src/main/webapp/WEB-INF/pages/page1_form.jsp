<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<h1 style="color:red;text-align:center">Naukri.com Registration Page1</h1>

<form:form method="post" commandName="regCmd">
    Name ::: <form:input path="name"/> <br>
    Address ::: <form:input path="addrs"/> <br>
    age ::: <form:input path="age"/> <br>
    <input type="submit"  value="next" name="_target1">
    <input type="submit"  value="cancel" name="_cancel">
</form:form>    
