<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27/07/2022
  Time: 7:47 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/productServlet?action=searchProductByName" method="post">
        <input type="text" name="search">
        <button type="submit">Search</button>
    </form>
    <p>${messager}</p>
    <%----%>
</div>
<div align="center">
    <h1>List Product</h1>
    <button style="margin-bottom: 10px"><a style="text-decoration: none" href="/productServlet?action=create">Create new product</a></button>
    <table border="1" width="800px">
        <tr>
            <th>STT</th>
            <th>Name</th>
            <th>Category</th>
            <th colspan="3">Action</th>
        </tr>
        <c:forEach items="${products}" var="b">
            <tr>
                <td >${b.getId()}</td>
                <td >${b.getName()}</td>
                <td>${b.getCategory().getName()} </td>
                <td ><button><a style="text-decoration: none" href="/productServlet?action=update&id=${b.getId()}">Update</a></button></td>
                <td ><button><a style="text-decoration: none" href="/productServlet?action=delete&id=${b.getId()}">Delete</a></button></td>
            </tr>
        </c:forEach>
    </table>

</div>


</body>
</html>
