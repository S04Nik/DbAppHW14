package com.example.DbAppHW14;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Car {
    public String name;
    public String manufacture;
    public String v;
    public String color;
    public String year;
    public String type;
    Car(){}
//    Car(ResultSet resultSet) throws SQLException {
//        while(resultSet.next()){
//            this.Name=resultSet.getString(2);
//            this.Manufacture=resultSet.getString(3);
//            this.V=resultSet.getString(4);
//            this.Color=resultSet.getString(5);
//            this.Type=resultSet.getString(6);
//            this.Year=resultSet.getString(7);
//        }
//    }
    Car(String Name,String Manufacture,String V, String Color,String Year,String Type){
        this.name=Name;
        this.manufacture=Manufacture;
        this.v=V;
        this.color=Color;
        this.type=Type;
        this.year=Year;
    }
    public String getName(){
        return this.name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public String getV() {
        return v;
    }

    public String getColor() {
        return color;
    }

    public String getYear() {
        return year;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "Name='" + name + '\'' +
                ", Manufacture='" + manufacture + '\'' +
                ", V='" + v + '\'' +
                ", Color='" + color + '\'' +
                ", Year='" + year + '\'' +
                ", Type='" + type + '\'' +
                '}';
    }
}
