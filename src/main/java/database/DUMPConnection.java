package database;

import java.beans.Statement;
import java.io.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Ivan on 17.05.2017.
 */
public class DUMPConnection {
    static {
        try {
            Driver driver = new org.postgresql.Driver();
            DriverManager.registerDriver(driver);

        } catch (SQLException e) {
            System.out.println("*** Error : " + e.toString());
            System.out.println("*** ");
            System.out.println("*** Error : ");
            e.printStackTrace();
        }

    }

    private static final String URL = "jdbc:postgresql://localhost/";
    private static final String USER = "postgres";
    private static final String PASSWORD = "postgres";

    public  void resetDatabase() throws SQLException, IOException {
        String s;
        StringBuilder sb = new StringBuilder();

        /*try {*/
            FileReader fr = new FileReader(new File("src\\main\\java\\database\\test.sql"));

            BufferedReader br = new BufferedReader(fr);

            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            br.close();

            String[] inst = sb.toString().split(";");

            Connection connection = DriverManager.getConnection(URL,USER,PASSWORD);
            java.sql.Statement statement = connection.createStatement();

            for (int i = 0; i < inst.length; i++) {
                if (!inst[i].trim().equals("")) {
                    statement.executeUpdate(inst[i]);
                    if(inst[i].equals("CREATE DATABASE test")){
                        connection =  DriverManager.getConnection("jdbc:postgresql://localhost/test",USER,PASSWORD);
                        statement = connection.createStatement();
                    }
                    System.out.println(">>" + inst[i]);
                }
            }


       /* } catch (Exception e) {
            System.out.println("*** Error : " + e.toString());
            System.out.println("*** ");
            System.out.println("*** Error : ");
            e.printStackTrace();
            System.out.println("################################################");
            System.out.println(sb.toString());
        }*/
    };


}
