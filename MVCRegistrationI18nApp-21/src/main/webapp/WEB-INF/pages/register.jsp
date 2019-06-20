<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags"  prefix="spring"%>

<h1 style="color:red;text-align:center">Registration page </h1>

&nbsp;&nbsp;&nbsp; <a href="?language=de">German</a>
                   <a href="?language=fr">French</a>
                   <a href="?language=hi">Hindi</a>
                   <a href="?language=en">English</a>
                   
<form  method="post">
  <spring:message code="reg.label1"/><input type="text" name="t1"><br>
  <spring:message code="reg.label2"/><input type="text" name="t2"><br>
  <spring:message code="reg.label3"/><input type="text" name="t3"><br>
  <input type="submit"  value="register"/>
</form>


    
