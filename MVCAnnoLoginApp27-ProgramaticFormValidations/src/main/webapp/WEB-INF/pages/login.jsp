<%@ page language="java" isELIgnored="false"  pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    

<h1 style="color:red;text-align:center">Login Page </h1>

<form:form method="post" commandName="userCmd">
   <p style="color:red"><form:errors path="*"/></p> <br>
  username :: <form:input path="uname"/> <br>
  Password :: <form:input path="pwd"/> <br>
  <input type="submit" value="login"/>
</form:form>

${resultMsg}
    
