package database;

import org.postgresql.*;
import org.postgresql.util.PSQLException;

import java.io.IOException;
import java.sql.*;
import java.sql.Driver;
import java.util.ArrayList;

/**
 * Created by Ivan on 07.05.2017.
 */
public class ManageSQL {

    private static final String URL = "jdbc:postgresql://localhost/test";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";
    private static Connection connection;
    private static int iter = 0;
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
        try {
            if(iter ==0) {
                DUMPConnection dumpConnection = new DUMPConnection();
                dumpConnection.resetDatabase();
                iter++;
            }
        }catch (SQLException e){
            connection = getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /*public static void main(String[] args) throws SQLException {
        ManageSQL manageSQL = new ManageSQL();
        Statement statement =  manageSQL.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM phonebook");
        while (resultSet.next()){
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(2));
            System.out.println(resultSet.getString(3));
        }
    }*/

    public  Connection getConnection() throws SQLException {
        return connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }


    public void deleteIng(String[] strings) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
        for(int i = 0; i < strings.length; i++){
            preparedStatement.setString(i+1,strings[i]);
        }

        preparedStatement.execute();
        preparedStatement.close();
        connection.close();
    }

    public  void updateIng(String[] strings) throws SQLException {

        PreparedStatement preparedStatement = getConnection().prepareStatement(UPDATE);
        for(int i = 0; i < strings.length; i++){
            preparedStatement.setString(i+1,strings[i]);
        }
        preparedStatement.execute();
    }

    public  ArrayList<String[]> getSelect(String SELECT) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(SELECT);
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

    public  void addingSQL(String adding[]) throws SQLException {
        PreparedStatement preparedStatement = getConnection().prepareStatement(ADD);
        for(int i = 0; i < adding.length; i++){
            preparedStatement.setString(i+1, adding[i]);
        }
        preparedStatement.execute();
    }
}
