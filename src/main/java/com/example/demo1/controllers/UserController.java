package com.example.demo1.controllers;

import com.example.demo1.Database;
import com.example.demo1.models.User;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserController {

    public int insertUser(User user_) throws SQLException, NamingException {
        Connection connection = Database.getConnection();

        String sql = "INSERT INTO persons (name, email) VALUES (?, ?);";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, user_.getName());
        preparedStatement.setString(2, user_.getEmail());

        int executeReturn = preparedStatement.executeUpdate();
        connection.close();
        return executeReturn;
    }

    public ArrayList<User> getAllUsers() throws SQLException, NamingException {
        ArrayList<User> users = new ArrayList<>();

        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM persons ORDER BY id DESC";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            users.add(new User(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email")
            ));
        }
        connection.close();
        return users;
    }

    public User getUserById(int id_) throws SQLException, NamingException {
        User user = null;

        Connection connection = Database.getConnection();

        String sql = "SELECT * FROM persons WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id_);

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()){
            user = new User(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getString("email")
            );
        }
        connection.close();

        return user;
    }

    public int deleteUserById(int id_) throws SQLException, NamingException {
        Connection connection = Database.getConnection();

        String sql = "DELETE FROM persons WHERE ID = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id_);

        int executeReturn = preparedStatement.executeUpdate();
        connection.close();
        return executeReturn;
    }

    public void updatePerson(User user_) throws SQLException, NamingException {
        System.out.println(user_.getId());
        System.out.println(user_.getName());
        System.out.println(user_.getEmail());

        Connection connection = Database.getConnection();

        String sql = "UPDATE persons SET name = ?, email = ? WHERE id = ?;";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, user_.getName());
        preparedStatement.setString(2, user_.getEmail());
        preparedStatement.setInt(3, user_.getId());

        preparedStatement.executeUpdate();
        connection.close();
    }
}
