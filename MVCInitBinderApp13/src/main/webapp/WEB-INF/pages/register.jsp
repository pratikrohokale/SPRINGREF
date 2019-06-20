<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    

<h1 style="color:red;text-align:center">Registration Page </h1>    

<form:form method="POST" commandName="regCmd">
   <form:errors path="*"/>
  number :: <form:input path="no"/> <br>
  name :: <form:input path="name"/> <br>
  DOB(Data of Birth) :: <form:input path="dob"/> (dd-MM-yyyy)<br>
  DOJ(Data of Joining) :: <form:input path="doj"/>(dd-MM-yyyy) <br>
  DOM(Data of Marriage) :: <form:input path="dom"/>(dd-MM-yyyy) <br>
  <input type="submit"  value="register">
</form:form>