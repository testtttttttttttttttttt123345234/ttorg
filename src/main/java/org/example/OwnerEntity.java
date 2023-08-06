package org.example;

import java.sql.*;

import java.util.logging.*;
import static org.junit.Assert.fail;

public class OwnerEntity {
    private static final Logger logger = Logger.getLogger(OwnerEntity.class.getName());
    String counter = "10";
    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    String role;
    public boolean addHousing(String ownerUsername) throws SQLException {
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
                int flag = 0;
                String query = "SELECT * FROM login where username='"+UserName+"' and password='"+Password+"'";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    flag = 1;
                    if (resultSet.getString(3).equals("tenant")) {role="tenant";} else if (resultSet.getString(3).equals("admin")) {role="admin";} else if (resultSet.getString(3).equals("owner")) {role="owner";} else {role="null";}
                }
                if (flag == 0) {role="null";}
            }
         catch (Exception ignored) {}
        return role;
    }

    public boolean showHousings(String owner)
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            Statement statement = connection.createStatement();
            String query = "Select * from housing where owner = '"+owner+"'";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                String id = "ID : " + resultSet.getString(8)+"\n";
                logger.info(id);
                String price ="Price : " + resultSet.getString(2)+"\n";
                logger.info(price);
                String departmentName = "Department Name : " + resultSet.getString(10)+"\n\n";
                logger.info(departmentName);
                String picture = "Picture : " + resultSet.getString(1)+"\n";
                logger.info(picture);
                String services = "Services : " + resultSet.getString(4)+"\n";
                logger.info(services);
                String location = "Location : " + resultSet.getString(3)+"\n";
                logger.info(location);
                String numOfPeople = "Number of people lived in : " + resultSet.getString(11)+"\n";
                logger.info(numOfPeople);
                String floorNum = "Floor Number: " + resultSet.getString(9)+"\n";
                logger.info(floorNum);
                logger.info("Owner information\n");
                String ownerName = "Owner name : " + resultSet.getString(1)+" "+resultSet.getString(2)+" "+resultSet.getString(3)+"\n";
                logger.info(ownerName);
                String ownerPhoneNumber = "Owner Phone number : " + resultSet.getString(5)+"\n";
                logger.info(ownerPhoneNumber);
                String ownerEmail = "Owner email : " + resultSet.getString(6)+"\n";
                logger.info(ownerEmail);
                return true;
            }
        } catch (SQLException e){throw new RuntimeException(e);}return false;
    }
}