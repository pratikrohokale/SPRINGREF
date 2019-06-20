<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

<h1 style="color:red;text-align:center">Naukri.com Registration Page2</h1>

<form:form method="post" commandName="regCmd">
    Domain ::: <form:input path="domain"/> <br>
    Experience ::: <form:input path="experience"/> <br>
    <input type="submit"  value="previous" name="_target0">
    <input type="submit"  value="next" name="_target2">
    <input type="submit"  value="cancel" name="_cancel">
</form:form>    
