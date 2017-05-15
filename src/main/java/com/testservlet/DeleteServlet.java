package com.testservlet;

import database.ManageSQL;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;


public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String page="index.jsp";
            ManageSQL.getConnection();
            ArrayList<String[]> arrayList;
            String first_name = request.getParameter("first_name_delete");
            String second_name = request.getParameter("second_name_delete");
            String third_name = request.getParameter("third_name_delete");
            String city = request.getParameter("city_delete");
            String street = request.getParameter("street_delete");
            String number_of_home = request.getParameter("number_of_home_delete");
            String number_of_phone_one = request.getParameter("number_of_phone_one_delete");
            String number_of_phone_two = request.getParameter("number_of_phone_two_delete");
            String number_of_phone_three = request.getParameter("number_of_phone_three_delete");
            ManageSQL.deleteIng(new String[] {first_name,second_name,third_name,city,street,number_of_home,number_of_phone_one,
                    number_of_phone_two,number_of_phone_three});
            ManageSQL.getConnection().close();
            ManageSQL.getConnection();
            RequestDispatcher dispatcher;
            arrayList = ManageSQL.getSelect("SELECT * FROM phonebook");
            request.setAttribute("data",arrayList);
            dispatcher  = request.getRequestDispatcher(page);
            if (dispatcher != null) {
                dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
