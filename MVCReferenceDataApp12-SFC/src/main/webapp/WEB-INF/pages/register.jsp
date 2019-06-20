<%@taglib uri="http://www.springframework.org/tags/form"  prefix="form"%>


<h1 style="color:red;text-align:center">Registration page</h1>

<form:form method="post" commandName="rdCmd">
   <p  style="color:red">
     <form:errors path="*"/>
   </p>
  Person name :: <form:input path="name"/><br>
  Person Addrs :: <form:input path="addrs"/><br>
  Country :: <form:select path="country">
                 <form:options items="${countries}"/>
             </form:select> <br>
  Hobies  :: <form:checkboxes items="${hobies}" path="hobies"/> <br>
  
  Courses :: <form:select path="courses" multiple="true">
                  <form:options items="${courses}"/>
             </form:select> <br>
   <input type="submit"  value="register">                         
</form:form>
