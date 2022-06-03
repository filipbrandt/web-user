package com.example.demo1.servlets;

import com.example.demo1.controllers.UserController;
import com.example.demo1.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "InsertUserServlet", value = "/insert-user")
public class InsertUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(
                request.getParameter("name"),
                request.getParameter("email")
        );

        try {
            if(new UserController().insertUser(user) > 0) {
                System.out.println("User Inserted");
                response.sendRedirect("/views/all-users.jsp");
            } else {
                System.out.println("User NOT Inserted");
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
