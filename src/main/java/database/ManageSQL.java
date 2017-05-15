package database;

import org.postgresql.*;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.sql.Driver;
import java.util.ArrayList;

/**
 * Created by Ivan on 07.05.2017.
 */
public class ManageSQL {

    private static final String URL = "jdbc:postgresql://localhost:5432/test";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static int iter = 0;
    private static Connection connection;
    private static final String ADD = "INSERT INTO phonebook (first_name, second_name, third_name, city, street, number_of_home, number_of_phone_one, number_of_phone_two, number_of_phone_three)" +
            "VALUES (?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE = "UPDATE phonebook SET first_name = (?), second_name = (?)," +
            "third_name = (?), city = (?), street= (?), number_of_home = (?), number_of_phone_one = (?), " +
            "number_of_phone_two = (?), number_of_phone_three = (?)  WHERE first_name = (?) AND second_name = (?) AND " +
            "third_name = (?) AND city = (?) AND street= (?) AND number_of_home = (?) AND number_of_phone_one = (?) AND " +
            "number_of_phone_two = (?) AND number_of_phone_three = (?)";
    private static final String DELETE = "DELETE FROM phonebook WHERE first_name=(?) AND second_name=(?) AND third_name=(?) AND city=(?) AND " +
            "  street=(?) AND number_of_home=(?) AND number_of_phone_one=(?) AND number_of_phone_two=(?) AND " +
            "  number_of_phone_three=(?)";

    public ManageSQL() throws SQLException {
        if(iter==0) {
            createDbUserTable();
        }
    }




    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        return connection;
    }

    private static void createDbUserTable() throws SQLException {
        Driver driver = new org.postgresql.Driver();
        DriverManager.registerDriver(driver);

        Connection dbConnection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", USERNAME,PASSWORD);
        Statement statement = dbConnection.createStatement();
        try {
            statement.execute("CREATE DATABASE test");
            dbConnection = getConnection();
            String createTableSQL = "CREATE TABLE phonebook\n" +
                    "(\n" +
                    "    id SERIAL NOT NULL PRIMARY KEY ,\n" +
                    "    first_name TEXT NOT NULL,\n" +
                    "    second_name TEXT,\n" +
                    "    third_name TEXT,\n" +
                    "    city TEXT,\n" +
                    "    street TEXT,\n" +
                    "    number_of_home VARCHAR(10),\n" +
                    "    number_of_phone_one VARCHAR(15) NOT NULL,\n" +
                    "    number_of_phone_two VARCHAR(15),\n" +
                    "    number_of_phone_three VARCHAR(15)\n" +
                    ");";
            statement = dbConnection.createStatement();
            statement.execute(createTableSQL);
        }catch (SQLException e){
            //e.printStackTrace();
        }finally {
            iter++;
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static void deleteIng(String[] strings) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        for(int i = 0; i < strings.length; i++){
            preparedStatement.setString(i+1,strings[i]);
        }

        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public static void updateIng(String[] strings) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
        for(int i = 0; i < strings.length; i++){
            preparedStatement.setString(i+1,strings[i]);
        }
        preparedStatement.execute();
    }

    public static ArrayList<String[]> getSelect(String SELECT) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT);
        ResultSet resultSet = preparedStatement.executeQuery();
        ArrayList<String[]> arrayList = new ArrayList<String[]>();
        while (resultSet.next()){
            String[] strings = new String[9];
            strings[0] = resultSet.getString("first_name");
            strings[1] = resultSet.getString("second_name");
            strings[2] = resultSet.getString("third_name");
            strings[3] = resultSet.getString("city");
            strings[4] = resultSet.getString("street");
            strings[5] = resultSet.getString("number_of_home");
            strings[6] = resultSet.getString("number_of_phone_one");
            strings[7] = resultSet.getString("number_of_phone_two");
            strings[8] = resultSet.getString("number_of_phone_three");
            arrayList.add(strings);
        }
        return arrayList;
    }

    public static void addingSQL(String adding[]) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(ADD);
        for(int i = 0; i < adding.length; i++){
            preparedStatement.setString(i+1, adding[i]);
        }
        preparedStatement.execute();
    }
}
