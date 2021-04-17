<%@ page import="java.sql.ResultSet" %><%--
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
</head>
<body>
<h2>View <--</h2>
<p>
    <% ResultSet result= (ResultSet) request.getAttribute("result");
        if((int)request.getAttribute("type")==1) {
            while (result.next()) {
                out.println(result.getString(2));
                out.println("<br>");
                out.println(result.getString(3));
                out.println("<br>");
                out.println(result.getString(4));
                out.println("<br>");
                out.println(result.getString(5));
                out.println("<br>");
                out.println(result.getString(6));
                out.println("<br>");
                out.println(result.getString(7));
                out.println("<br>");
                out.println("------------------->");
                out.println("<br>");
            }
        }else if((int)request.getAttribute("type")==2)
        {
            while (result.next()) {
                out.println(result.getString(1));
                out.println("<br>");
                out.println("------------------->");
                out.println("<br>");
            }
        }else if((int)request.getAttribute("type")==3){
            while(result.next()){
                out.println(result.getString(1)+" : "+result.getString(2));
                out.println("<br>");
                out.println("------------------->");
                out.println("<br>");
            }

        }


    %>
</p>
</body>
</html>
