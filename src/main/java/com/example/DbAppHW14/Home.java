package com.example.DbAppHW14;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

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
                "values ('"+car.name+"','"+car.manufacture+"','"+car.v+"','"+car.year+"','"+car.color+"','"+car.type+"')");
        System.out.println("<-- Insert Completed -->");
    }
    public static HashSet<Car> selectAll() throws SQLException {
        ResultSet result=statement.executeQuery("select * from `car`");
        HashSet<Car> arr=new HashSet<Car>();
        while(result.next()){
            arr.add(new Car(result.getString(2),
                    result.getString(3),
                    result.getString(4),
                    result.getString(5),
                    result.getString(6),
                    result.getString(7)));
        }
        return arr;
    }
    public static ArrayList selectManufactures() throws SQLException {
        ResultSet result=statement.executeQuery("select car.manufacture from `car`");
        ArrayList arr= new ArrayList();
        while(result.next()){
            arr.add(result.getString(1));
        }
        return arr;
    }
    public static HashMap<String, String> selectManufacturesCount() throws SQLException {
        ResultSet result=statement.executeQuery("select car.manufacture,count(car.manufacture) as Counts" +
                " from `car` group by car.manufacture");
        HashMap<String,String> arr= new HashMap<String,String>();
        while(result.next()){
            arr.put(result.getString(1),result.getString(2));
        }

        return arr;
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        connect();
        switch(request.getParameter("submit")){
            case "Select All": request.setAttribute("cars", selectAll());
            request.setAttribute("type", 1);break;
            case "Select Manufactures":request.setAttribute("result",selectManufactures());
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
