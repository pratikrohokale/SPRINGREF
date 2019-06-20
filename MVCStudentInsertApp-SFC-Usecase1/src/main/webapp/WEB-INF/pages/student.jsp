<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

 <form:form method="POST" commandName="stCmd">
  Student Number :: <form:input path="sno"/> <br>
  Student Name :: <form:input path="sname"/> <br>
  Student Addrs :: <form:input path="sadd"/> <br>
   <input type="submit"  value="register"/>
</form:form>    

<%--  <form  method="POST">
  Student Number :: <input type="text" name="sno"/> <br>
  Student Name :: <input type="text" name="sname"/> <br>
  Student Addrs :: <input type="text" name="sadd"/> <br>
   <input type="submit"  value="register"/>
 </form> --%>