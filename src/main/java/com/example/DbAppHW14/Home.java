package com.example.DbAppHW14;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "Home", value = "/home")
public class Home extends HttpServlet {
    public static Connection connection;
    public static Statement statement;
    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver"); // определяет драйвер СУБД
        connection= DriverManager.getConnection("jdbc:mysql://localhost:3308/vehicles", "root","root");
        statement=connection.createStatement();
    }
    public static void closeConnection() throws SQLException {
        connection.close();
    }
    public static void insert(Car car) throws SQLException {
        statement.executeUpdate("insert into `car` (name,manufacture,V,year,color,type)" +
                "values ('"+car.Name+"','"+car.Manufacture+"','"+car.V+"','"+car.Year+"','"+car.Color+"','"+car.Type+"')");
        System.out.println("<-- Insert Completed -->");
    }
    public static ResultSet selectAll() throws SQLException {
        ResultSet result=statement.executeQuery("select * from `car`");
        return result;
    }
    public static ResultSet selectManufactures() throws SQLException {
        ResultSet result=statement.executeQuery("select car.manufacture from `car`");
        return result;
    }
    public static ResultSet selectManufacturesCount() throws SQLException {
        ResultSet result=statement.executeQuery("select car.manufacture,count(car.manufacture) as Counts" +
                " from `car` group by car.manufacture");
        return result;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        connect();
        switch(request.getParameter("submit")){
            case "Select All": request.setAttribute("result", selectAll());
            request.setAttribute("type", 1);break;
            case "Select Manufactures":request.setAttribute("result", selectManufactures());
                request.setAttribute("type", 2);break;
            case "Select Cars Count":request.setAttribute("result",selectManufacturesCount());
                request.setAttribute("type", 3);break;
            default: {
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.forward(request,response);
            }
        }
        }catch(Exception ex){ex.printStackTrace();}
        RequestDispatcher rd=request.getRequestDispatcher("viewSelect.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            System.out.println(request.getParameter("submit"));
            Car tmp=new Car(request.getParameter("name"),
            request.getParameter("manufacture"),
            request.getParameter("V"),
            request.getParameter("year"),
            request.getParameter("color"),
            request.getParameter("type"));
            connect();
            insert(tmp);
            closeConnection();
            RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
            rd.forward(request,response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
