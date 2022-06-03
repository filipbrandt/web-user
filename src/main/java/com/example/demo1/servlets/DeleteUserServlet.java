package com.example.demo1.servlets;

import com.example.demo1.controllers.UserController;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.naming.NamingException;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteUserServlet", value = "/delete-user")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int isDeleted = new UserController().deleteUserById(Integer.parseInt(request.getParameter("id")));
            if (isDeleted > 0) {
                response.sendRedirect("/views/all-users.jsp");
            } else {
                System.out.println("Person NOT updated");
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
    }
}
