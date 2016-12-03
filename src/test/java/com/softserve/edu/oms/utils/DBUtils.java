package com.softserve.edu.oms.utils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtils {
    private static final String SQL_EXCEPTION_FOUND = "SQL Exception found";
    //private static final String SQL_SELECT_USERS = "select top 3 Login, FirstName, LastName, Password, Email, RegionRef, RoleRef from Users;";
    private static final String SQL_SELECT_USERS = "select Users.Login, Users.FirstName, Users.LastName,"
            + " Users.Password, Users.Email, Regions.RegionName, Roles.RoleName"
            + " from (Users join Regions on Users.RegionRef = Regions.ID)"
            + " join Roles on Users.RoleRef = Roles.ID;";

//	private String username = "root";
//	private String password = "root";
//	private String url = "jdbc:mysql://localhost:1100/users";
    // MS SQL
    private String username = "db207";
    private String password = "db207";
    private String url = "jdbc:jtds:sqlserver://127.0.0.1/Lv207OMS;instance=SQLEXPRESS;";

    public List<List<String>> getAllCells(String absoluteFilePath) {
        List<List<String>> allCells = new ArrayList<List<String>>();
        List<String> rowCells = null;
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        int columnCount = 0;
        //
        try {
            //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(SQL_EXCEPTION_FOUND, e);
        }

        if (con != null) {
            System.out.println("+++Connection Successful! \n");
        } else {
            System.out.println("+++Connection fail \n");
            System.exit(0);
        }
        try {
            st = con.createStatement();
            rs = st.executeQuery(SQL_SELECT_USERS);
            columnCount = rs.getMetaData().getColumnCount();
            //
            while (rs.next()) {
                rowCells = new ArrayList<String>();
                for (int i = 1; i <= columnCount; i++) {
                    rowCells.add(rs.getString(i));
                    System.out.print("+++\t" + rs.getString(i) + "\t");
                }
                allCells.add(rowCells);
                System.out.println();
            }
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(SQL_EXCEPTION_FOUND, e);
        }
        return allCells;
    }

}
