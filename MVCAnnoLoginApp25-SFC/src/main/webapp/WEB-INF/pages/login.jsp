<%@ page language="java" isELIgnored="false"  pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>    

<h1 style="color:red;text-align:center">Login Page </h1>

<form:form method="post" commandName="userCmd">
   <form:errors path="*"/> <br>
  username :: <form:input path="uname"/> <br>
  Password :: <form:input path="pwd"/> <br>
  Domains :: <form:checkboxes items="${domains}" path="dmns"/> <br>
  DOB ::<form:input path="dob"/>(dd-MM-yyyy) <br>
  <input type="submit" value="login"/>
</form:form>

${resultMsg}
    
