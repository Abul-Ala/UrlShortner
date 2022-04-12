<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>
table, th, td {
  border:1px solid black;
}
</style>
<body>

<h2> your url</h2>

<table style="width:100%">
  <tr>
    <th>long url</th>
    <th>short url</th>
    
  </tr>
 <c:forEach var="item" items="${list}">
   <tr>
    <td>${item.longUrl }</td>
    <td>${item.shortUrl}</td>
  </tr>
  </c:forEach>
 
</table>


</body>
</html>