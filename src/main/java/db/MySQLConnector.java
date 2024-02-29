package db;

import settings.ISettings;
import settings.PropertiesReader;



import java.sql.*;
import java.util.Map;

public class MySQLConnector implements IDBConnector {

    private static Connection connection = null;
    private static Statement statement = null;

    public MySQLConnector() {

        connect();
    }

       private void connect() {
           try {
               if (connection == null || connection.isClosed()) {
                   ISettings reader = new PropertiesReader();
                   Map<String, String> settings = reader.read();

                   connection = DriverManager.getConnection(settings.get("url") + "/" + settings.get("db_name"),
                           settings.get("db_username"),
                           settings.get("db_password"));
               }

               if (statement == null || statement.isClosed()) {
                   statement = connection.createStatement();
               }
           }catch (SQLException e) {
           throw  new RuntimeException(e);
           }
       }


    public static void close() {
        try {
            try {
                if (statement != null && !statement.isClosed())
                    statement.close();
                statement = null;
                if (connection != null && !connection.isClosed())
                    connection.close();
                connection = null;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void executeRequest(String response) {
        try {
            statement.execute(response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


@Override
    public  ResultSet executeRequestWithAnswer(String response) {
        try {
            return statement.executeQuery(response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}




