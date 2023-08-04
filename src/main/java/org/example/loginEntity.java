package org.example;

import java.sql.*;
import java.util.logging.*;

public class loginEntity {
    private static final Logger logger = Logger.getLogger(loginEntity.class.getName());

    boolean Owner = false;
    boolean reg = false;
    boolean Tenant = false;
    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    String owner = "owner";

    String role;

    public  String checkValues(String UserName,String Password) {

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
                int flag = 0;
                String query = "SELECT * FROM login where username='"+UserName+"' and password='"+Password+"'";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    flag = 1;
                    if (resultSet.getString(3).equalsIgnoreCase("tenant")) {role="tenant";} else if (resultSet.getString(3).equalsIgnoreCase("admin")) {role="admin";} else if (resultSet.getString(3).equalsIgnoreCase("owner")) {role="owner";}
                }
                if (flag == 0) {
                    role="null";}return role;} catch (Exception ex) { logger.info("An exception occurred: " + ex.getMessage());}
        return null;
    }

    public boolean printOwner(String fName, String mName, String lName, String Phone, String owEmail, String age, String owUser, String owPass) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement2 = connection.createStatement();
            String query2 = "insert into login (username, password, role) values ('"+owUser+"', '"+owPass+"', '"+owner+"')";statement2.executeUpdate(query2);Statement statement3 = connection.createStatement();String query3 = "insert into owner (first_name, second_name, last_name, phonenumber, email, age, username, password, role) values ('"+fName+"', '"+mName+"', '"+lName+"', '"+Phone + "', '"+owEmail+"', '"+age+"', '"+owUser+"', '"+owPass+"', '"+owner+"')";statement3.executeUpdate(query3);Owner = true; statement3.close(); statement2.close();} catch (SQLException e) {logger.info("An exception occurred : " + e.getMessage());}
        return Owner;
    }

    public boolean printTenant( String ffName, String mmName, String llName, String PPhone, String tenEmail, String Age, String Reg_num, String major, String tenUser, String tenPass) {
        String tenant = "tenant";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement3 = connection.createStatement();
            String query3 = "insert into login (username, password, role) values ('"+tenUser+"','"+tenPass+"', '"+tenant+"')";statement3.executeUpdate(query3);Statement statement4 = connection.createStatement();String query4 = "insert into tenant (first_name, second_name, last_name, phonenumber, email, age, reg_num, major, username, password, role) values ('"+ffName+"', '"+mmName+"', '"+llName+"', '"+PPhone+"', '"+tenEmail+"', '"+Age+"', '"+Reg_num+"', '"+major+"', '"+tenUser+"','"+tenPass+"', '"+tenant+"')";statement4.executeUpdate(query4);Tenant = true; statement3.close(); statement4.close();
        } catch (SQLException e) {logger.info("An exception occurred: " + e.getMessage());}
        return Tenant;
    }

    public boolean failureReg(String tenUser, String tenPass) {

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query = "select * from login where username = '"+tenUser+"'and password = '"+tenPass+"'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                reg = true;
            }
        } catch (SQLException e){logger.info("An exception occurred: " + e.getMessage());
        }
        return reg;
    }
}

