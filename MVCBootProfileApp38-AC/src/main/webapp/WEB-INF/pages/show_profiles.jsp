<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<c:choose>
 <c:when test="${!empty profilesList }">
   <table border="1">
    <tr> <th>ProfileId</th><th>ProfileName</th><th>PostsCount</th><th>FollowersCount</th><th>FriendsCount</th></tr>
     <c:forEach var="dto" items="${profilesList}">
       <tr>
        <td>${dto.profileId}</td>
       <td>${dto.profileName}</td>
       <td>${dto.postsCount}</td>
       <td>${dto.followersCount}</td>
       <td>${dto.friendsCount}</td>
       </tr>
     </c:forEach>
   </table>
 </c:when>
  <c:otherwise>
    <h1>No Profiles are found</h1>
  </c:otherwise>
</c:choose>
<br>
  <a href="home.htm">home</a>

