package com.oc.programmer.objectives.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * When a connection is created, it is in auto-commit mode. i.e. auto-commit is enabled. This means
 * that each individual SQL statement is treated as a transaction and is automatically committed
 * right after it is completed. (A statement is completed when all of its result sets and update
 * counts have been retrieved.
 *
 * In almost all cases, however, a statement is completed, and therefore committed, right after it
 * is executed.) The way to allow two or more statements to be grouped into a transaction is to
 * disable the auto-commit mode. Since it is enabled by default, you have to explicitly disable it
 * after creating a connection by calling con.setAutoCommit(false);
 */
public class JdbcConnection {

  public static void main(String[] args) {

    try {
      Connection c = DriverManager.getConnection("jdbc:derby://localhost:1527/sample", "app", "app");
      Statement stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery("select * from STUDENT");

      // ResultSetMetaData gives you the information about the result of executing a query
      ResultSetMetaData resultSetMetaData = rs.getMetaData();
      System.out.println(resultSetMetaData.getColumnCount());

      // Note: column index starts from 1 (not 0)
      System.out.println(resultSetMetaData.getColumnName(1));
      System.out.println(resultSetMetaData.getColumnLabel(1));
      System.out.println(resultSetMetaData.getColumnType(1));
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
