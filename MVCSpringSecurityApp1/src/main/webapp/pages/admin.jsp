<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

  <h1 style='color:red;text-align:center'>Admin page </h1>
  
  username :: <%=request.getUserPrincipal().getName() %> <br>
  
  <br>
   <a href="../j_spring_security_logout">LogOut</a>

</body>
</html>