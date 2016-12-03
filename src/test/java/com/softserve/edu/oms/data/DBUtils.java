package com.softserve.edu.oms.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtils implements IExternalData {
	private static final String SQL_EXCEPTION_FOUND = "SQL Exception found";
	//private static final String SQL_SELECT_USERS = "select top 3 Login, FirstName, LastName, Password, Email, RegionRef, RoleRef from Users;";
	private static final String SQL_SELECT_USERS = "select Users.Login, Users.FirstName, Users.LastName,"
			+ " Users.Password, Users.Email, Regions.RegionName, Roles.RoleName"
			+ " from (Users join Regions on Users.RegionRef = Regions.ID)"
			+ " join Roles on Users.RoleRef = Roles.ID;";

	private static final String SQL_DELETE_USERS_FIRSTNAME =  "DELETE FROM Users WHERE FirstName='rrd'";
	private static final String SQL_SELECT_COLUMN_LASTNAME = "SELECT LastName FROM Users WHERE IsUserActive=1 AND LastName LIKE 'none%'";
	private static final String SQL_SELECT_COLUMN_LOGIN = "SELECT Login FROM Users WHERE IsUserActive=1 AND Login LIKE '%none%'";
	//	private static final String SQL_SELECT_COLUMN_ROLE = "SELECT r.RoleName FROM Users as u JOIN Roles as r on u.RoleRef=r.ID" +
//                                                    "WHERE u.IsUserActive=1 AND r.RoleName not like '%er%'";
	private static final String SQL_SELECT_COLUMN_ROLE = "SELECT r.RoleName FROM Users as u JOIN Roles as r on u.RoleRef=r.ID WHERE u.IsUserActive=1 AND r.RoleName not like '%er%'";
	//
	// TODO This is hardcode. Must be refactor
	// MySQL
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
		// TODO Delete messages
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

	public void deleteUsersFromDB(){
		Connection con = null;
		Statement st = null;

		try {
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
			con = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			throw new RuntimeException(SQL_EXCEPTION_FOUND, e);
		}
		// TODO Delete messages
		if (con != null) {
			System.out.println("+++Connection Successful! \n");
		} else {
			System.out.println("+++Connection fail \n");
			System.exit(0);
		}
		try {
			st = con.createStatement();
			st.execute(SQL_DELETE_USERS_FIRSTNAME);

		} catch (Exception e) {
			throw new RuntimeException(SQL_EXCEPTION_FOUND, e);
		}
	}

	public List<String> getOneColumn(String nameOfColumn) {
		List<List<String>> allCells = new ArrayList<List<String>>();

		List<String> listOfOneColumn = new ArrayList<>();
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
		// TODO Delete messages
		if (con != null) {
			System.out.println("+++Connection Successful! \n");
		} else {
			System.out.println("+++Connection fail \n");
			System.exit(0);
		}
		try {
			st = con.createStatement();
			switch (nameOfColumn) {
				case ("lastName"):  rs = st.executeQuery(SQL_SELECT_COLUMN_LASTNAME);
					break;
				case ("login"):  rs = st.executeQuery(SQL_SELECT_COLUMN_LOGIN);
					break;
				case ("role"):  rs = st.executeQuery(SQL_SELECT_COLUMN_ROLE);
					break;
			}


			//rs = st.executeQuery(SQL_SELECT_COLUMN_ROLE);
			//columnCount = rs.getMetaData().getColumnCount();
			//
			while (rs.next()) {
				listOfOneColumn.add(rs.getString(1));
//                rowCells = new ArrayList<String>();
//                for (int i = 1; i <= columnCount; i++) {
//                    rowCells.add(rs.getString(i));
//                    System.out.print("+++\t" + rs.getString(i) + "\t");
//                }
//                allCells.add(rowCells);
				System.out.println(rs.getString(1));
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
		return listOfOneColumn;
	}


}