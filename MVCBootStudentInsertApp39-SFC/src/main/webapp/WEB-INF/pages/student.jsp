<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form:form method="POST" commandName="stCmd">
  Student  name :: <form:input path="sname"/> <br>
  Student  addrs :: <form:input path="sadd"/> <br>
  <input type="submit" value="register">
</form:form>    
<br><br>
 <b> ${resMsg } </b>
