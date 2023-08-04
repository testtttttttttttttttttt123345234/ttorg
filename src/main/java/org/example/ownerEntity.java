package org.example;

import java.sql.*;

import java.util.logging.*;
import static org.junit.Assert.fail;

public class ownerEntity {
    private static final Logger logger = Logger.getLogger(ownerEntity.class.getName());

    boolean ownerFlag = false;
    boolean ownerUsername = false;
    boolean ownerPassword = false;
    String counter = "10";
    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    String UserName,Password,Role;
    String owner_username, description, services, price, balcony, numOfBathrooms, floors, residenceName;

    public boolean addHousing(String ownerUsername) throws SQLException {
        //counter++;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query = "insert into housing (owner, id) values ('"+ownerUsername+"', '"+counter+"')";
            statement.executeUpdate(query);}return true;
    }

    public boolean departmentName(String department){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query = "UPDATE housing SET departmentName = '"+department+"' WHERE id = '"+counter+"'";
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {throw new RuntimeException(e);}
    }

    public boolean addPhoto(String photo){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query = "UPDATE housing SET picture = '"+photo+"' WHERE id = '"+counter+"'";
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {throw new RuntimeException(e);}
    }

    public boolean addLocationInfo(String location){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query = "UPDATE housing SET location = '"+location+"' WHERE id = '"+counter+"'";
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {throw new RuntimeException(e);}
    }
    public boolean addServices(String services){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query = "UPDATE housing SET services = '"+services+"' WHERE id = '"+counter+"'";
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {throw new RuntimeException(e);}
    }
    public boolean addPrice(String price){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String query = "UPDATE housing SET price = '"+price+"' WHERE id = '"+counter+"'";
            statement.executeUpdate(query);
            return true;
        } catch (SQLException e) {throw new RuntimeException(e);}
    }


    public  String checkValues(String UserName,String Password) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            if (UserName.isEmpty() == true || Password.isEmpty() == true) {
            } else {
                int flag = 0;
                String query = "SELECT * FROM login where username='"+UserName+"' and password='"+Password+"'";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    flag = 1;
                    if (resultSet.getString(3).equals("tenant")) {Role="tenant";} else if (resultSet.getString(3).equals("admin")) {Role="admin";} else if (resultSet.getString(3).equals("owner")) {Role="owner";} else {Role="null";}
                }
                if (flag == 0) {Role="null";}
            }
        } catch (Exception ex) {}
        return Role;
    }

    public boolean showHousings(String owner)
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            Statement statement = connection.createStatement();
            String query = "Select * from housing where owner = '"+owner+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("ID : " + resultSet.getString(8));
                System.out.println("Picture : " + resultSet.getString(1));
                System.out.println("Price : " + resultSet.getString(2));
                System.out.println("Location : " + resultSet.getString(3));
                System.out.println("Services : " + resultSet.getString(4));
                System.out.println("Number of people lived in : " + resultSet.getString(11));
                System.out.println("Floor Number: " + resultSet.getString(9));
                System.out.println("Department Name : " + resultSet.getString(10)+"\n");
                System.out.println("Owner information");
                System.out.println("Owner name : " + resultSet.getString(1)+" ");
                System.out.print(resultSet.getString(2)+" ");
                System.out.print(resultSet.getString(3));
                System.out.println("Owner email : " + resultSet.getString(6));
                System.out.println("Owner Phone number : " + resultSet.getString(5));
                return true;
            }
        } catch (SQLException e){throw new RuntimeException(e);}return false;
    }
}