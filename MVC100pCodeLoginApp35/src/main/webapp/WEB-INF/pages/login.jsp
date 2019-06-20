<%@page language="java"   contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    
 <%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>   

<h1 style="color:red;text-align:center">Login page</h1>

<form:form  method="POST" commandName="userCmd">
  Login username :: <form:input path="uname"/> <br>
  Login password :: <form:input path="pwd"/> <br>
  <input type="submit"  value="login">
</form:form>
<br><br>
${resMsg}
