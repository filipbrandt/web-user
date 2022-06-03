package com.example.demo1.servlets;

import com.example.demo1.controllers.UserController;
import com.example.demo1.models.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/update-user")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(
                Integer.parseInt(request.getParameter("id")),
                request.getParameter("name"),
                request.getParameter("email")
        );

        try {
            UserController userController = new UserController();
            userController.updatePerson(user);
            response.sendRedirect("/views/all-users.jsp");
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
