package productioncode;

import java.sql.*;
import java.util.logging.Logger;

public class HousingEntity {
    String host = "localhost";
    int port = 3306;
    String database = "sakancom";
    String username = "root";
    String password = "password";
    String url = "jdbc:mysql://" + host + ":" + port + "/" + database;
    Logger logger = Logger.getLogger(HousingEntity.class.getName());
String wid="' where id='";

    public int showAvailable() throws SQLException {

        int counter = 1;
        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            statement = connection.createStatement();

            String query = "Select * from housing where available='Yes' and accept='true'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String scounter = counter + "-";
                String id1 = "ID : {}" + resultSet.getString(8);
                String picture = "Picture : {}" + resultSet.getString(1);
                String price = "Price : {}" + resultSet.getString(2);
                String location = "Location : {}" + resultSet.getString(3);
                String service = "Services : {}" + resultSet.getString(4);
                String number = "Number of people lived in : {}" + resultSet.getString(11);
                String floor = "Floor Number: {}" + resultSet.getString(9);
                String departmentName = "Department Name : {}" + resultSet.getString(10);
                logger.info(scounter);
                logger.info(id1);
                logger.info(picture);
                logger.info(price);
                logger.info(location);
                logger.info(service);
                logger.info(number);
                logger.info(floor);
                logger.info(departmentName);
                counter++;
                logger.info("_____________________________________________");


            }
            resultSet.close();
        } finally {
            assert statement != null;
            statement.close();
        }
        return counter;
    }

    public boolean availableWithID(String id) throws SQLException {


        boolean flag = false;
        Statement statement = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {


            statement = connection.createStatement();

            String query = "Select * from housing where id='" + id + "' and available='Yes'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                flag = true;
            }
            resultSet.close();
        } finally {
            assert statement != null;
            statement.close();
        }
        return flag;

    }

            public boolean booking(String id,String userName) throws SQLException{
        int flag1=0;

        boolean rflag=false;
                try {
                    Integer.parseInt(id);
                    flag1 = 1;
                } catch (Exception ex) {logger.info("wrong input");}
                if (flag1 == 1 ) {

                    Statement statement1 = null;
                    Statement statement = null;
                    Statement statement2 = null;
                    try (Connection connection = DriverManager.getConnection(url, username, password)) {

                        statement = connection.createStatement();
                        statement1 = connection.createStatement();
                        statement2 = connection.createStatement();

                        String query = "select * from housing where id='" + id + "'and available ='Yes'";
                        ResultSet res = statement.executeQuery(query);

                        while (res.next()) {
                            int num = Integer.parseInt(res.getString(11));

                            if (num < 4) {
                                num++;
                                String n = Integer.toString(num);
                                if (num == 4) {
                                    query = "update housing set peopleNum='" + n + "',available='No',tenant='" + userName + wid + id + "'";
                                    statement1.executeUpdate(query);


                                } else {
                                    query = "update housing set peopleNum='" + n + "',tenant='" + userName + wid + id + "'";
                                    statement1.executeUpdate(query);

                                }
                                query = "insert into booking (tenantUserName,houseID,Owner) value ('" + userName + "','" + id + "','" + res.getString(6) + "')";

                                statement1.executeUpdate(query);
                                query = "insert into Tenants_Housing (tenantUserName,HouseID) value ('" + userName + "','" + id + "')";
                                statement2.executeUpdate(query);
                                rflag = true;
                            } else {

                                query = "update housing set available='No',peopleNum='+" + num + "',tenant='" + userName + wid + id + "'";
                                statement1.executeUpdate(query);
                                rflag = true;
                            }

                        }


                        res.close();
                    } finally {
                        assert statement1 != null;
                        assert statement != null;
                        assert statement2 != null;
                        statement1.close();
                        statement.close();
                        statement2.close();
                    }
                }
           return rflag;
}

}