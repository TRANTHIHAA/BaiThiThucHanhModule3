<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27/07/2022
  Time: 7:46 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Create new Product</h1>
<form  method="post">
    <table>
        <tr>
            <td><label for="name">Name</label></td>
            <td><input type="text" name="name" id="name"></td>
        </tr>
        <tr>
            <td><label for="price">price</label></td>
            <td><input type="text" name="price" id="price"></td>
        </tr>
        <tr>
            <td><label for="amount">amount</label></td>
            <td><input type="text" name="amount" id="amount"></td>
        </tr>
        <tr>
            <td><label for="color">color</label></td>
            <td><input type="text" name="color" id="color"></td>
        </tr>
        <tr>
            <td><label for="describe">describe</label></td>
            <td><input type="text" name="describe" id="describe"></td>
        </tr>
        <tr>
            <td><label for="category">Category</label></td>
            <td>
                <select name="category" id="category">
                    <c:forEach items="${categories}" var="c">
                        <option value="${c.getId()}">${c.getName()}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <button type="submit">Create</button>
            </td>
        </tr>
    </table>
</form>
<p>${messenger}</p>
</body>
</html>
