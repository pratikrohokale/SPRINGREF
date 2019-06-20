<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>

 <form:form method="POST" commandName="stCmd">
  Student Name :: <form:input path="sname"/> <br>
  Student Addrs :: <form:input path="sadd"/> <br>
   <input type="submit"  value="register"/>
   <input type="hidden"  name="cToken" value="${sToken}"/>
</form:form>    

