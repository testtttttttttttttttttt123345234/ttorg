package org.example;

import java.sql.*;
import java.util.Scanner;

public class adminEntity {
    String host = "localhost";
    int port = 3306;
    String database = "Sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    String  Role, housing, tenant, owner;

    public String checkValues(String UserName, String Password) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            if (UserName.isEmpty() == true || Password.isEmpty() == true) {
            } else {
                int flag = 0;
                String query = "SELECT * FROM login where username='" + UserName + "' and password='" + Password + "'";
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    flag = 1;
                    if (resultSet.getString(3).equals("tenant")) {Role = "tenant";
                    } else if (resultSet.getString(3).equals("admin")) {Role = "admin";} else if (resultSet.getString(3).equals("owner")) {Role = "owner";} else {Role = "null";
                    }
                }
                if (flag == 0) {Role = "null";
                }
            }
        } catch (Exception ex) {
        }
        return Role;
    }

    public boolean pendingHousings() throws SQLException
    {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String Query = "SELECT * FROM housing where accept = 'false'";
            ResultSet resultSet = statement.executeQuery(Query);
            while (resultSet.next()) {
                System.out.println("Owner : " +resultSet.getString("owner"));
                System.out.println("ID : " + resultSet.getString(8));
                System.out.println("Department Name : " +resultSet.getString(10));
                System.out.println("number of floors: " +resultSet.getString(9));
                System.out.println("Picture : " +resultSet.getString(1));
                System.out.println("Price : " +resultSet.getString(2));
                System.out.println("Location : " +resultSet.getString(3));
                System.out.println("Services : " +resultSet.getString(4));
                System.out.println("Acceptance : " +resultSet.getString("accept")+"\n");
            }return true;
        }catch (Exception ex) {}return false;
    }

    public boolean acceptRejectHousing(String id, String YN) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String Query;
            String t = "true";
            if(YN.equals("Yes")) {
                Query = "UPDATE housing SET accept = '"+t+"' WHERE id = '"+id+"'";
                statement.executeUpdate(Query);
            }else {
                return true;
            }
            return true;
        } catch (SQLException e) {throw new RuntimeException(e);}
    }

    public boolean showReservations(){
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String Query = "SELECT * from booking";
            ResultSet resultSet= statement.executeQuery(Query);
            System.out.println("Reservations: ");
            while(resultSet.next())
            {
                housing = resultSet.getString("houseID");
                tenant = resultSet.getString("tenantUserName");
                owner = resultSet.getString("Owner");
                System.out.println("House ID : " +resultSet.getString("houseID"));
                System.out.println("tenant : " +resultSet.getString("tenantUserName"));
                System.out.println("Owner : " +resultSet.getString("Owner")+"\n");
            }
            System.out.println("Tenant information");
            String Query3 = "SELECT * from tenant where username = '"+tenant+"'";
            ResultSet resultSet3= statement.executeQuery(Query3);
            while(resultSet3.next()) {
                System.out.println("Name : " + resultSet3.getString(1) + " " + resultSet3.getString(2) + " " + resultSet3.getString(3));
                System.out.println("Phone Number : " + resultSet3.getString(4));
                System.out.println("Email : " + resultSet3.getString(5));
                System.out.println("Age : " + resultSet3.getString(6));
                System.out.println("Registration Number : " + resultSet3.getString(7));
                System.out.println("Major : " + resultSet3.getString(8)+"\n");
            }
            String Query2 = "SELECT * from Owner where username = '"+owner+"'";
            ResultSet resultSet2= statement.executeQuery(Query2);
            System.out.println("Owner information");
            while(resultSet2.next())
            {
                System.out.println("Owner name : " + resultSet2.getString(1));
                System.out.print(resultSet2.getString(2));
                System.out.print(resultSet2.getString(3));
                System.out.println("Owner email : " + resultSet2.getString(6));
                System.out.println("Owner Phone number : " + resultSet2.getString(5)+"\n");
            }
            System.out.println("Housing information");
            String Query4 = "SELECT * from housing where id = '"+housing+"'";
            ResultSet resultSet4= statement.executeQuery(Query4);
            while(resultSet4.next()) {
                System.out.println("ID : " + resultSet4.getString(8));
                System.out.println("Picture : " + resultSet4.getString(1));
                System.out.println("Price : " + resultSet4.getString(2));
                System.out.println("Location : " + resultSet4.getString(3));
                System.out.println("Services : " + resultSet4.getString(4));
                System.out.println("Number of people lived in : " + resultSet4.getString(11));
                System.out.println("Floor Number: " + resultSet4.getString(9));
                System.out.println("Department Name : " + resultSet4.getString(10));
                System.out.println("_____________________________________________");}return true;
        } catch (SQLException e) {throw new RuntimeException(e);}
    }

}