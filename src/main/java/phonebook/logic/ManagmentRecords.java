package phonebook.logic;

import database.ManageSQL;


import java.sql.SQLException;



public class ManagmentRecords {

    private static String SELECT = "SELECT * FROM phonebook WHERE ";

    public ManagmentRecords() throws SQLException {

    }
    public String select(String first_name, String second_name, String number_of_phone_one) {
        String select_con = "";

            if ((first_name.equals("")) && (second_name.equals("")) && (number_of_phone_one.equals(""))) {
            select_con = SELECT.substring(0, 23);
            }
            else if ((!first_name.equals("")) && (second_name.equals("")) && (number_of_phone_one.equals(""))) {
                select_con = SELECT.concat("first_name=" + "'" + first_name + "'");
            }

            else if ((first_name.equals("")) && (!second_name.equals("")) && (number_of_phone_one.equals(""))) {
                select_con = SELECT.concat("second_name=" + "'" + second_name + "'");

            }
            
            else if ((first_name.equals("")) && (second_name.equals("")) && (!number_of_phone_one.equals(""))) {
                select_con = SELECT.concat("number_of_phone_one=" +
                        "'" + number_of_phone_one + "'");
            }

            else if ((!first_name.equals("")) && (!second_name.equals("")) && (number_of_phone_one.equals(""))) {
                select_con = SELECT.concat("first_name=" + "'" + first_name + "'");
                select_con = select_con.concat(" AND " + "second_name=" + "'" + second_name + "'");
            }

            else if ((!first_name.equals("")) && (second_name.equals("")) && (!number_of_phone_one.equals(""))) {
                select_con = SELECT.concat("first_name=" + "'" + first_name + "'");
                select_con = select_con.concat(" AND " + "number_of_phone_one=" +
                        "'" + number_of_phone_one + "'");
            }

            else if ((first_name.equals("")) && (!second_name.equals("")) && (!number_of_phone_one.equals(""))) {
                select_con = SELECT.concat("second_name=" + "'" + second_name + "'");
                select_con = select_con.concat(" AND " + "number_of_phone_one=" +
                        "'" + number_of_phone_one + "'");
            }

            else if ((!first_name.equals("")) && (!second_name.equals("")) && (!number_of_phone_one.equals(""))) {
                select_con = SELECT.concat("first_name=" + "'" + first_name + "'");
                select_con = select_con.concat(" AND " + "second_name=" + "'" + second_name + "'");
                select_con = select_con.concat(" AND " + "number_of_phone_one=" +
                        "'" + number_of_phone_one + "'");
            }

        return select_con;
    }

    public String[] addingManageRecords(String first_name,String second_name, String third_name,String city,
                           String street,String number_of_home,String number_of_phone_one,
                           String number_of_phone_two, String number_of_phone_three){
       String[] strings = new String[9];
       strings[0] = first_name;
       strings[1] = second_name.equals("") ? "-" : second_name;
       strings[2] = third_name.equals("") ? "-" : third_name;
       strings[3] = city.equals("") ? "-" : city;
       strings[4] = street.equals("") ? "-" : street;
       strings[5] = number_of_home.equals("") ? "-" : number_of_home;
       strings[6] = number_of_phone_one;
       strings[7] = number_of_phone_two.equals("") ? "" : number_of_phone_two;
       strings[8] = number_of_phone_three.equals("") ? "" : number_of_phone_three;
      return strings;
    }


}
