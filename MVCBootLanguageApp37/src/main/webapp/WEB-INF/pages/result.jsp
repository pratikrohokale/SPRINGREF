<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:if test="${!empty langList}">
   <h1 style="color:red"> All Languages </h1>
  <c:forEach var="lang" items="${langList}">
      ${lang} <br><br>
  </c:forEach>
</c:if>    

<c:if test="${!empty countryList}">
   <h1 style="color:red"> All Countries </h1>
  <c:forEach var="lang" items="${countryList}">
      ${lang} <br><br>
  </c:forEach>
</c:if>    

<br>
<a href="home.htm">home</a>
