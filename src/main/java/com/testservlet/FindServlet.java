package com.testservlet;

import database.ManageSQL;
import phonebook.logic.ManagmentRecords;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet("/s")
public class FindServlet extends HttpServlet {

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {

            super.doPost(request, response);
        }

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            try {
                String page="index.jsp";
                ManageSQL.getConnection();
                ManagmentRecords managmentRecords = new ManagmentRecords();
                ArrayList<String[]> arrayList;
                String first_name = request.getParameter("first_name");
                String second_name = request.getParameter("second_name");
                String number_of_phone_one = request.getParameter("number_of_phone_one");
                String SELECT = managmentRecords.select(first_name,second_name,number_of_phone_one);
                arrayList = ManageSQL.getSelect(SELECT);
                RequestDispatcher dispatcher;
                request.setAttribute("data",arrayList);
                dispatcher  = request.getRequestDispatcher(page);
                if (dispatcher != null) {
                    dispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
