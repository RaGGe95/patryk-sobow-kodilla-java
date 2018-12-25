package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {

        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQueryCreateTable = "CREATE TABLE IF NOT EXISTS USERS(" +
                "ID SERIAL PRIMARY KEY," +
                "FIRSTNAME VARCHAR(100)," +
                "LASTNAME VARCHAR(100)" +
                ");";

        String sqlQuery = "SELECT * FROM USERS";

        Statement statement1 = dbManager.getConnection().createStatement();
        Statement statement2 = dbManager.getConnection().createStatement();

        statement1.executeUpdate(sqlQueryCreateTable);

        ResultSet rs = statement2.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement1.close();
        statement2.close();
        //Assert.assertEquals(0, counter);


    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {

        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQueryCreateTable = "CREATE TABLE IF NOT EXISTS ISSUES\n" +
                "(\n" +
                "    ID  SERIAL PRIMARY KEY,\n" +
                "ISSUESLIST_ID BIGINT UNSIGNED NOT NULL,\n" +
                "USER_ID_ASSIGNEDTO BIGINT UNSIGNED NOT NULL,\n" +
                "SUMMARY VARCHAR(100),\n" +
                "DESCRIPTION VARCHAR(1000) CHARSET utf8,\n" +
                " \n" +

                "FOREIGN KEY (USER_ID_ASSIGNEDTO) REFERENCES USERS(ID)\n" +
                ");";

        String sqlQuery = "select U.firstname, U.lastname, COUNT(*) as NUMBER_OF_TASKS_ASSIGNED\n" +
                "FROM ISSUES I, USERS U\n" +
                "where U.ID = I.USER_ID_ASSIGNEDTO\n" +
                "group by U.ID\n" +
                "HAVING COUNT(*) >= 2";

        Statement statement1 = dbManager.getConnection().createStatement();
        Statement statement2 = dbManager.getConnection().createStatement();

        statement2.executeUpdate(sqlQueryCreateTable);
        ResultSet rs = statement1.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME") + ", " +
                    rs.getInt("NUMBER_OF_TASKS_ASSIGNED"));
            counter++;
        }
        rs.close();
        statement1.close();
        statement2.close();
        //Assert.assertEquals(0, counter);

    }

}