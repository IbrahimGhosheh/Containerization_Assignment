package com.assignment.SQLdb.resource;

import java.sql.*;
import java.util.ArrayList;

public class DBModel {
    private final String DB_URL = "jdbc:mysql://host.docker.internal:3306/assignment";
    private final String USER = "root";
    private final String PASS = "Ibrahim_1";
    private Connection connection;

    public DBModel()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");


            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void storeAge(int age) {

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection
                    .prepareStatement("insert into ages(ages) values(?)");
            preparedStatement.setInt(1, age);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public ArrayList<Integer> getAges(){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        ArrayList<Integer> ages = new ArrayList<>();
        try {
            preparedStatement = connection
                    .prepareStatement("select * from ages");
             resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                ages.add(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ages;

    }
}
