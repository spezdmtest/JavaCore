package com.spezdmtest.javacore.JDBC.Examples;

import java.sql.*;

public class UpdateTableJdbc {
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/PROSELYTE_JDBC_DB?serverTimezone=Europe/Kiev";
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    static final String USER = "nexdim";
    static final String PASSWORD = "asdqwe123";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;

        try {
            System.out.println("Registering JDBC driver...");
            Class.forName(JDBC_DRIVER);

            System.out.println("Creating connection to database...");
            connection = DriverManager.getConnection(DATABASE_URL,USER,PASSWORD);

            System.out.println("Getting records...");
            statement = connection.createStatement();

            String SQL = "SELECT * FROM developers";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String specialty = resultSet.getString(3);
                int salary = resultSet.getInt(4);


                System.out.println("id: " + id);
                System.out.println("Name:" + name);
                System.out.println("Specialty: " + specialty);
                System.out.println("Salary: " + salary);
                System.out.println("=====================\n");

                System.out.println("\n******************************\n");
            }

            System.out.println("Increasing salary for all  developers (+ $500");
            System.out.println("Getting updates records...");

            resultSet = statement.executeQuery(SQL);
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String specialty = resultSet.getString(3);
                int salary = resultSet.getInt(4) + 500;

                System.out.println("id: " + id);
                System.out.println("Name: " + name);
                System.out.println("Specialty: " + specialty);
                System.out.println("Salary: " + salary);
                System.out.println("=================\n");
            }
        }finally {
            if(statement != null) {
                statement.close();
            }
            if(connection != null) {
                connection.close();
            }
        }
    }
}
