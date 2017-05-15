package com.testservlet;

import database.ManageSQL;
import phonebook.logic.ManagmentRecords;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class EditServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String page="index.jsp";
            ManageSQL.getConnection();
            ArrayList<String[]> arrayList;
            String first_name = request.getParameter("first_name_edit");
            String second_name = request.getParameter("second_name_edit");
            String third_name = request.getParameter("third_name_edit");
            String city = request.getParameter("city_edit");
            String street = request.getParameter("street_edit");
            String number_of_home = request.getParameter("number_of_home_edit");
            String number_of_phone_one = request.getParameter("number_of_phone_one_edit");
            String number_of_phone_two = request.getParameter("number_of_phone_two_edit");
            String number_of_phone_three = request.getParameter("number_of_phone_three_edit");
            String first_name_h = request.getParameter("first_name_edit_hidden");
            String second_name_h = request.getParameter("second_name_edit_hidden");
            String third_name_h = request.getParameter("third_name_edit_hidden");
            String city_h = request.getParameter("city_edit_hidden");
            String street_h = request.getParameter("street_edit_hidden");
            String number_of_home_h = request.getParameter("number_of_home_edit_hidden");
            String number_of_phone_one_h = request.getParameter("number_of_phone_one_edit_hidden");
            String number_of_phone_two_h = request.getParameter("number_of_phone_two_edit_hidden");
            String number_of_phone_three_h = request.getParameter("number_of_phone_three_edit_hidden");

            ManageSQL.updateIng(new String[]{ first_name,second_name,third_name,city,street,number_of_home,number_of_phone_one,
                    number_of_phone_two,number_of_phone_three,first_name_h,second_name_h,third_name_h,city_h,street_h,
                    number_of_home_h,number_of_phone_one_h,number_of_phone_two_h,number_of_phone_three_h});
            arrayList = ManageSQL.getSelect("SELECT * FROM phonebook");
            request.setAttribute("data",arrayList);
            RequestDispatcher dispatcher;
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
