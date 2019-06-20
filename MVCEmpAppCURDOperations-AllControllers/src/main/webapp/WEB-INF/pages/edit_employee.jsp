<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib uri="http://www.springframework.org/tags/form"   prefix="form"%>    

   <h1 style="color:red;text-align:center">Edit Empoyee Details</h1>
   
   <form:form method="post"  commandName="empCmd">
    <p style="color:red">
       <form:errors path="*"/>
    </p>
     Employee Number :: <form:input path="eno" disabled="true"/> <br>
     Employee Name :: <form:input path="ename"/> <br>
     Employee Desg :: <form:input path="desg"/> <br>
     Employee Salary :: <form:input path="salary"/> <br>
     <input type="submit"  value="edit Employee">
     </form:form>
   
  