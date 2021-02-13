package com.example.springdbs.demodbs.DBUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class DbOperations {

    private static Connection connection;
    private static Logger logger = LoggerFactory.getLogger(DbOperations.class);

    public Connection getConnection() throws SQLException {

        if(connection == null){
            logger.info("Getting the connection from driver manager");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
        }

        createTable();
        return connection;
    }

    public void createTable() throws SQLException {

        String sql = "create table if not exists user(id INT primary key auto_increment, name VARCHAR(30), country VARCHAR(30), age INT)";
        Statement statement = connection.createStatement();

        boolean result = statement.execute(sql);
        logger.info("result of create operation is {}", result);

//        statement.executeQuery(sql);
//        statement.executeUpdate(sql);

    }
}
