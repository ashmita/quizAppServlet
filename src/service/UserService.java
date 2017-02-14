package service;

import domains.User;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shreha on 8/25/2016.
 */
public class UserService {

    public User getUser(String name, String password) {
        User user = null;
        try {
        String query = "select * from user1 where username=? and password=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);


            pstm.setString(1, name);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>();
        try {
            String query = "select * from user1";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);


            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                userList.add(user);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }
}
