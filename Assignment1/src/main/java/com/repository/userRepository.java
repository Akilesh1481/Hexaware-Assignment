package com.repository;

import com.enums.Role;
import com.model.user;
import com.util.DBConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class userRepository {

    DBConnection dbConnection = new DBConnection();
    public List<user> getAllUser() {
        List<user> list = new ArrayList<>();
        Connection connection = dbConnection.dbConnect();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL get_all_users()}");
            ResultSet rst = callableStatement.executeQuery();
            while(rst.next()) {
                int id = rst.getInt("id");
                String email = rst.getString("email");
                String name = rst.getString("name");
                String password = rst.getString("password");
                int phone = rst.getInt("phone");
                Role role = Role.valueOf(
                        rst.getString("role")
                );
                user obj = new user(
                        id, email, name, password, phone, role
                );
                list.add(obj);
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbConnection.dbClose();
        return list;
    }

    public List<user> getUserByRole(String roleInput) throws SQLException {
        List<user> list = new ArrayList<>();
        Connection connection = dbConnection.dbConnect();
        CallableStatement callableStatement = connection.prepareCall("{CALL get_users_by_role(?)}");
        callableStatement.setString(1, roleInput);
        ResultSet rs = callableStatement.executeQuery();
        while(rs.next()) {
            int id = rs.getInt("id");
            String email = rs.getString("email");
            String name = rs.getString("name");
            String password = rs.getString("password");
            int phone = rs.getInt("phone");
            Role role = Role.valueOf(rs.getString("role")
            );
            user obj = new user(
                    id,
                    email,
                    name,
                    password,
                    phone,
                    role
            );
            list.add(obj);
        }
        dbConnection.dbClose();
        return list;
    }
    public void insertUser(user obj) {
        Connection connection = dbConnection.dbConnect();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL insert_user(?,?,?,?,?)}");
            callableStatement.setString(1, obj.getEmail());
            callableStatement.setString(2, obj.getName());
            callableStatement.setString(3, obj.getPassword());
            callableStatement.setInt(4, obj.getPhone());
            callableStatement.setString(5, obj.getRole().name());
            callableStatement.executeUpdate();
            System.out.println("User Inserted Successfully");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbConnection.dbClose();
    }
    public void deleteUser(int id) {
        Connection connection = dbConnection.dbConnect();
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL delete_user(?)}");
            callableStatement.setInt(1, id);
            callableStatement.executeUpdate();
            System.out.println("User Deleted Successfully");
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        dbConnection.dbClose();
    }
}