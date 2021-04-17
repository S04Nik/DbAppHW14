<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/17/2021
  Time: 11:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
</head>
<h1>Menu</h1>
<body>
<form action="/insert.jsp">
    <input type="submit" name="submit" value="Insert">
</form>
<form action="/home" method="get">
    <input type="submit" name="submit" value="Select All">
    <br>
    <input type="submit" name="submit" value="Select Manufactures">
    <br>
    <input type="submit" name="submit" value="Select Cars Count">
</form>

</body>
</html>
