package org.example;

import java.sql.*;
import java.util.logging.Logger;

public class AdminEntity {
    private static final Logger logger = Logger.getLogger(AdminEntity.class.getName());

    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    String  role;
    String housing;
    String tenant;
    String owner;
    private static final String STRING = "owner";

    public String checkValues(String userName, String passWord) throws SQLException {
        Statement statement = null;
        try(Connection connection = DriverManager.getConnection(url, username, password))
        {   statement = connection.createStatement();int flag = 0;
            String query = "SELECT * FROM login where username='" + userName + "' and password='" + passWord + "'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {flag = 1;
                if (resultSet.getString(3).equals("tenant")) {role = "tenant";
                } else if (resultSet.getString(3).equals("admin")) {role = "admin";} else if (resultSet.getString(3).equals(STRING)) {role = STRING;} else {role = "null";}}
            if (flag == 0) {role = "null";}
            resultSet.close();statement.close();}
        finally {assert statement!=null;statement.close();}return role;}

    public boolean pendingHousings() throws SQLException {
        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            statement = connection.createStatement();
            String query = "SELECT * FROM housing where accept = 'false'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String oPrint = "Owner : " + resultSet.getString(STRING) + "\n";
                String deName = "Department Name : " + resultSet.getString(10) + "\n";
                String idPrint = "ID : " + resultSet.getString(8) + "\n";
                String nFloor = "number of floors: " + resultSet.getString(9) + "\n";
                String pic = "Picture : " + resultSet.getString(1) + "\n";
                String price = "Price : " + resultSet.getString(2) + "\n";
                String location = "Location : " + resultSet.getString(3) + "\n";
                String services = "Services : " + resultSet.getString(4) + "\n";
                String accept = "Acceptance : " + resultSet.getString("accept") + "\n";
                logger.info(oPrint);
                logger.info(idPrint);
                logger.info(deName);
                logger.info(nFloor);
                logger.info(pic);
                logger.info(price);
                logger.info(location);
                logger.info(services);
                logger.info(accept);
            }
            resultSet.close();
            statement.close();
        }finally {assert statement!=null;statement.close();
        }
        return true;

    }

    public boolean acceptRejectHousing(String id, String yn) throws SQLException {
        Statement statement = null;
        try(Connection connection = DriverManager.getConnection(url, username, password)) {
            statement = connection.createStatement();
            String query;
            String t = "true";
            if (yn.equals("Yes")) {
                query = "UPDATE housing SET accept = '" + t + "' WHERE id = '" + id + "'";
                statement.executeUpdate(query);
            } else {
                return true;
            }
            statement.close();
        }finally {assert statement!=null;statement.close();}
        return true;
    }

    public boolean showReservations() throws SQLException {
        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            statement = connection.createStatement();
            String query = "SELECT * from booking";
            ResultSet resultSet = statement.executeQuery(query);
            logger.info("Reservations :\n");
            while (resultSet.next()) {
                housing = resultSet.getString("houseID");
                tenant = resultSet.getString("tenantUserName");
                owner = resultSet.getString("Owner");
                String hID = ("House ID : " + resultSet.getString("houseID")) + "\n";
                String tUser = "tenant : " + resultSet.getString("tenantUserName") + "\n";
                String oUser = "Owner : " + resultSet.getString("Owner") + "\n";
                logger.info(hID);
                logger.info(tUser);
                logger.info(oUser);
            }
            logger.info("Tenant information" + "\n");
            String query3 = "SELECT * from tenant where username = '" + tenant + "'";
            ResultSet resultSet3 = statement.executeQuery(query3);
            while (resultSet3.next()) {
                String tenName = "Name : " + resultSet3.getString(1) + " " + resultSet3.getString(2) + " " + resultSet3.getString(3) + "\n";
                logger.info(tenName);
                String phoneNumber = "Phone Number : " + resultSet3.getString(4) + "\n";
                logger.info(phoneNumber);
                String email = "Email : " + resultSet3.getString(5) + "\n";
                logger.info(email);
                String age = "Age : " + resultSet3.getString(6) + "\n";
                logger.info(age);
                String regNum = "Registration Number : " + resultSet3.getString(7) + "\n";
                logger.info(regNum);
                String major = "Major : " + resultSet3.getString(8) + "\n";
                logger.info(major);
            }
            String query2 = "SELECT * from Owner where username = '" + owner + "'";
            ResultSet resultSet2 = statement.executeQuery(query2);
            logger.info("Owner information" + "\n");
            while (resultSet2.next()) {
                String oName = "Owner name : " + resultSet2.getString(1) + " " + resultSet2.getString(2) + " " + resultSet2.getString(3) + "\n";
                logger.info(oName);
                String oEmail = "Owner email : " + resultSet2.getString(6) + "\n";
                logger.info(oEmail);
                String oPH = "Owner Phone number : " + resultSet2.getString(5) + "\n";
                logger.info(oPH);
            }
            logger.info("Housing information \n");
            String query4 = "SELECT * from housing where id = '" + housing + "'";
            ResultSet resultSet4 = statement.executeQuery(query4);
            while (resultSet4.next()) {
                String id = "ID : " + resultSet4.getString(8) + "\n";
                logger.info(id);
                String service = "Services : " + resultSet4.getString(4) + "\n";
                logger.info(service);
                String picture = "Picture : " + resultSet4.getString(1) + "\n";
                logger.info(picture);
                String loc = "Location : " + resultSet4.getString(3) + "\n";
                logger.info(loc);
                String price = "Price : " + resultSet4.getString(2) + "\n";
                logger.info(price);
                String numOfPeople = "Number of people lived in : " + resultSet4.getString(11) + "\n";
                logger.info(numOfPeople);
                String floorNum = "Floor Number: " + resultSet4.getString(9) + "\n";
                logger.info(floorNum);
                String departmentName = "Department Name : " + resultSet4.getString(10) + "\n";
                logger.info(departmentName);
                String end = "_____________________________________________" + "\n";
                logger.info(end);
            }
            resultSet.close();
            resultSet2.close();
            resultSet3.close();
            resultSet4.close();
            statement.close();
            return true;

        }finally {assert statement!=null;statement.close();}
    }
}
