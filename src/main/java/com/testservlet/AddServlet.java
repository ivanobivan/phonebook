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


public class AddServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String page="index.jsp";
            ManageSQL manageSQL = new ManageSQL();
            ManagmentRecords managmentRecords = new ManagmentRecords();
            ArrayList<String[]> arrayList;
            String first_name = request.getParameter("first_name");
            String second_name = request.getParameter("second_name");
            String third_name = request.getParameter("third_name");
            String city = request.getParameter("city");
            String street = request.getParameter("street");
            String number_of_home = request.getParameter("number_of_home");
            String number_of_phone_one = request.getParameter("number_of_phone_one");
            String number_of_phone_two = request.getParameter("number_of_phone_two");
            String number_of_phone_three = request.getParameter("number_of_phone_three");
            String[] strings = managmentRecords.addingManageRecords(first_name,second_name,third_name,
                    city,street,number_of_home,number_of_phone_one,number_of_phone_two,
                    number_of_phone_three);
            manageSQL.addingSQL(strings);
            arrayList = manageSQL.getSelect("SELECT * FROM phonebook");
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
