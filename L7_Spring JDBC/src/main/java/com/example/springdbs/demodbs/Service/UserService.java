package com.example.springdbs.demodbs.Service;

import com.example.springdbs.demodbs.DBUtils.DbOperations;
import com.example.springdbs.demodbs.Model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    DbOperations connection;

//    public UserService() throws SQLException {
//        logger.info("Ok!! I am gonna create user table now!!");
//        connection.getConnection();
//    }

    // Constructor dependency injection
    public UserService(DbOperations operations,
                       @Value("${test.my_prop}")
                       String my_prop){
        this.connection = operations;
        logger.info("prop is {}", my_prop);
    }

    // default port of mysql - 3306
    // postgres - 5432
    // Java database connectivity

    // Hibernate - create, read, update, delete // efficient

    public void insertUser(User user) throws SQLException {

        // insert into user(name, country, age) VALUES (user.getName(), )
        String sql = "insert into user(name, country, age) VALUES (\"" + user.getName() + "\", \"" + user.getCountry() + "\", " + user.getAge() + ")";

        Statement statement = connection.getConnection().createStatement();
        int rows_modified = statement.executeUpdate(sql);

        logger.info("No of users inserted : {}", rows_modified);
    }

    public List<User> getUsers() throws SQLException {

        String sql = "select * from user";

        Statement statement = connection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<User> userList = new ArrayList<>();

        while(resultSet.next()){

            int id = resultSet.getInt(1); // resultSet.getInt("id")
            String name = resultSet.getString(2);
            String country = resultSet.getString(3);
            int age = resultSet.getInt(4);

            User user = new User(id, name, country, age);
            userList.add(user);
        }

        return userList;

    }

    public User getUser(int id) throws Exception {

        String sql = "select * from user where id = " + id;

        Statement statement = connection.getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){

            int record_id = resultSet.getInt(1); // resultSet.getInt("id")
            String name = resultSet.getString(2);
            String country = resultSet.getString(3);
            int age = resultSet.getInt(4);

            User user = new User(record_id, name, country, age);

            return user;
        }

        logger.error("No user found for id {}", id);
//
//        return null;

        throw new Exception("No user found");

    }


}
