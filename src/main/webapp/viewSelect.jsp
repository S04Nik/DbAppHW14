<%@ page import="java.sql.ResultSet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="result" type="com.example.DbAppHW14.Home"--%>
<%--@elvariable id="type" type="com.example.DbAppHW14.Home"--%>
<%--@elvariable id="cars" type="jdk.internal.icu.lang.UCharacter"--%>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 4/17/2021
  Time: 11:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="./css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<h2>View</h2>
<p>
    <table>
        <c:if test="${type==1}">
            <tr>
                <th>Name</th>
                <th>Manufacture</th>
                <th>V</th>
                <th>Color</th>
                <th>Year</th>
                <th>Type</th>
            </tr>
                <c:forEach var="item" items="${cars}">
                    <tr>
                        <td><c:out value="${item.name}"/></td>
                        <td><c:out value="${item.manufacture}"/></td>
                        <td><c:out value="${item.v}"/></td>
                        <td><c:out value="${item.color}"/></td>
                        <td><c:out value="${item.year}"/></td>
                        <td><c:out value="${item.type}"/></td>
                    </tr>
                    <tr></tr>
                </c:forEach>
        </c:if>
        <c:if test="${type==2}">
            <h3>Manufactures</h3>
            <c:forEach var="item" items="${result}">
                <tr><td><c:out value="${item}"/></td></tr>
            </c:forEach>
        </c:if>
        <c:if test="${type==3}">
            <tr>
                <th>Manufacture</th>
                <th>Count of Cars</th>
            </tr>
            <c:forEach var="item" items="${result}">
                <tr><td><c:out value="${item.key}"/></td>
                    <td><c:out value="${item.value}"/></td></tr>
            </c:forEach>
        </c:if>
</table>
</p>
</body>
</html>
