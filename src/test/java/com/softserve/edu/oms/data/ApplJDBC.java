package com.softserve.edu.oms.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ApplJDBC {
	private static Connection con = null;
	private static String username = "db207";
	private static String password = "db207";

	private static String URL =
			"jdbc:jtds:sqlserver://127.0.0.1/Lv207OMS;instance=SQLEXPRESS;";

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Start...");

		DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());

		con = DriverManager.getConnection(URL, username, password);
		if (con != null) {
			System.out.println("Connection Successful! \n");
		} else {
			System.out.println("Connection fail \n");
			System.exit(0);
		}
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select Login, FirstName, LastName, Password, Email, RegionRef, RoleRef from Users;");
		int columnCount = rs.getMetaData().getColumnCount();
		while (rs.next()) {
			for (int i = 1; i <= columnCount; i++) {
				System.out.print(rs.getString(i) + "\t");
			}
			System.out.println();
		}
		System.out.println();
		if (rs != null) {
			rs.close();
		}
		if (st != null) {
			st.close();
		}
		if (con != null) {
			con.close();
		}
	}
}
