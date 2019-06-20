<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
  <c:when test="${!empty listEmps}">
    <table border="1" bgcolor="cyan">
      <tr style="color:red"><th>emp no</th><th>emp name</th><th>emp job</th><th>emp salary</th><th>Mgr No</th><th>Dept No</th></tr>
      <c:forEach var="dto"  items="${listEmps}">
        <tr style="color:blue">
         <td>${dto.eno}</td>
         <td>${dto.ename}</td>
         <td>${dto.desg}</td>
         <td>${dto.salary}</td>
         <td>${dto.mgrNo}</td>
         <td>${dto.deptNo}</td>
        </tr>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    Records not found..
  </c:otherwise>
</c:choose>    
<br><br>
<a href="home.htm">home</a>


    
