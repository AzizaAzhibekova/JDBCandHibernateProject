package com.peaksoft.dao;



import com.peaksoft.model.User;
import com.peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    @Override
    public void createUsersTable() {
        String SQL = " CREATE TABLE IF NOT EXISTS users(" +
                "id BIGSERIAL PRIMARY KEY," +
                "name VARCHAR(200)," +
                "last_name VARCHAR(200)," +
                "age SMALLINT);";
        try (Connection conn = Util.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users;";
        try (Connection conn = Util.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Database dropped successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        String SQL = "INSERT INTO users(name,last_name,age) VALUES(?,?,?);";
        try (Connection conn = Util.connection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void removeUserById(long id) {
        String SQL= "SELECT FROM users WHERE id = ?;";
        try (Connection conn = Util.connection();
             PreparedStatement statement = conn.prepareStatement(SQL)){
            statement.setLong(1, id);
            statement.execute();
            System.out.println("user" + id + "removed from table");
        }catch (SQLException e ){
            e.printStackTrace();

        }

    }

    @Override
    public List<User> getAllUsers() {
        String SQL = "SELECT * FROM users;";
        List<User> users = new ArrayList<>();
        try (Connection conn = Util.connection();
             Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery(SQL)) {
            while (resultSet.next()) {
                User user = new User();
                user.setId( resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setAge( resultSet.getByte("age"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;


    }

    @Override
    public void cleanUsersTable() {
        try (Connection conn = Util.connection()) {
            Statement statement = conn.createStatement();
            String sql="TRUNCATE TABLE users";
            statement.executeUpdate(sql);
        }catch(SQLException  e){
            System.out.println(e);

        }


    }
}
