<%@ page language="java" isELIgnored="false"  pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 
<h1 style="color:red;text-align:center">Choose file to download Page </h1>

<c:choose>
  <c:when test="${!empty listFiles }">
    <table border="1">
     <tr><th> file name </th><th>Operation</th></tr>
     <c:forEach var="file" items="${listFiles}">
       <tr>
        <td>${file}</td>
        <td><a href="download.htm?fname=${file}">dowloand</a></td>
        </tr>
     </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    <h1> No Files found</h1>
  </c:otherwise>
</c:choose>

