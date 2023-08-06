package org.example;

import java.sql.*;

public class LoginEntity {


    boolean reg = false;


    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username1 = "root";
    String password1 = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    String role;
    String owner = "owner";
    String tenant="tenant";
    String admin="admin";
    private static final String AGE = "21";

    public  String checkValues(String userName,String password) throws SQLException {

        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(url, username1, password1)) {
            statement = connection.createStatement();
            role="null";
            if (!userName.isEmpty() && !password.isEmpty()) {

                String query = "SELECT * FROM login where username='" + userName + "' and password='" + password + "'";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {

                    if (resultSet.getString(3).equalsIgnoreCase(tenant)) {
                        role = tenant;
                    } else if (resultSet.getString(3).equalsIgnoreCase(admin)) {
                        role = admin;
                    } else if (resultSet.getString(3).equalsIgnoreCase(owner)) {
                        role = owner;
                    }
                }
                resultSet.close();
            }

        } finally {
            assert statement != null;
            statement.close();
        }
        return role;
    }

    public boolean printOwner(String fName, String mName, String lName, String phone, String owEmail, String owUser, String owPass) throws SQLException {
        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(url, username1, password1)) {
            statement = connection.createStatement();
            String query2 = "insert into login (username, password, role) values ('" + owUser + "', '" + owPass + "', '" + owner + "')";
            statement.executeUpdate(query2);
            String query3 = "insert into owner (first_name, second_name, last_name, phonenumber, email, age, username, password, role) values ('" + fName + "', '" + mName + "', '" + lName + "', '" + phone + "', '" + owEmail + "', '" +AGE+ "', '" + owUser + "', '" + owPass + "', '" + owner + "')";
            statement.executeUpdate(query3);
            statement.close();
        } finally {

            assert statement != null;
            statement.close();
        }
        return true;
    }

    public boolean printTenant( String ffName, String mmName, String llName, String pPhone, String tenEmail, String tenUser, String tenPass) throws SQLException {
        Statement statement = null;
        String mJor = "Computer Engineering";
        String rNum = "12028797";
        try (Connection connection = DriverManager.getConnection(url, username1, password1)) {
            statement = connection.createStatement();
            String query3 = "insert into login (username, password, role) values ('" + tenUser + "','" + tenPass + "', '" + tenant + "')";
            statement.executeUpdate(query3);
            String query4 = "insert into tenant (first_name, second_name, last_name, phonenumber, email, age, reg_num, major, username, password, role) values ('" + ffName + "', '" + mmName + "', '" + llName + "', '" + pPhone + "', '" + tenEmail + "', '" +AGE+ "', '" +rNum+ "', '"+mJor+"', '" + tenUser + "','" + tenPass + "', '" + tenant + "')";
            statement.executeUpdate(query4);
            statement.close();
        } finally {
            assert statement != null;
            statement.close();

        }
        return true;
    }

    public boolean failureReg(String tenUser, String tenPass) throws SQLException {

        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(url, username1, password1)) {
            statement = connection.createStatement();
            String query = "select * from login where username = '" + tenUser + "'and password = '" + tenPass + "'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                reg = true;
            }
            resultSet.close();
        } finally {
            assert statement != null;

            statement.close();
        }
        return reg;
    }
}

