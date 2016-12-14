package com.softserve.edu.oms.data;

import com.softserve.edu.oms.enums.SQLQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class  DBUtils implements IExternalData {
	private static final String SQL_EXCEPTION_FOUND = "SQL Exception found";
//	private static final String SQL_SELECT_USERS = "select Users.Login, Users.FirstName, Users.LastName,"
//			+ " Users.Password, Users.Email, Regions.RegionName, Roles.RoleName"
//			+ " from (Users join Regions on Users.RegionRef = Regions.ID)"
//			+ " join Roles on Users.RoleRef = Roles.ID;";
//	private static final String SQL_SELECT_USER_BY_LOGIN = "select Users.Login, Users.FirstName, Users.LastName,"
//			+ " Users.Password, Users.Email, Regions.RegionName, Roles.RoleName"
//			+ " from (Users join Regions on Users.RegionRef = Regions.ID)"
//			+ " join Roles on Users.RoleRef = Roles.ID"
////			+ " where Users.login=";
//	private static final String SQL_DELETE_USERS_FIRSTNAME =  "DELETE FROM Users WHERE FirstName='rrd'";
//	private static final String SQL_SELECT_COLUMN_LASTNAME = "SELECT LastName FROM Users WHERE IsUserActive=1 AND LastName LIKE 'none%'";
//	private static final String SQL_SELECT_COLUMN_LOGIN = "SELECT Login FROM Users WHERE IsUserActive=1 AND Login LIKE '%none%'";
//	private static final String SQL_SELECT_COLUMN_ROLE = "SELECT r.RoleName FROM Users as u JOIN Roles as r on u.RoleRef=r.ID WHERE u.IsUserActive=1 AND r.RoleName not like '%er%'";
	
//	private static final String SQL_DELETE_USER_LOGIN = "DELETE FROM Users WHERE Login=";
//    private static final String SQL_COUNT_ALL_USERS = "SELECT count (*) FROM Users WHERE IsUserActive=1";

//    private static final String SQL_SELECT_COLUMN_USER_FIVE_VALUES = "select TOP 5 Users.Login, Users.FirstName, Users.LastName,Users.Password, Users.Email, Regions.RegionName, Roles.RoleName from (Users join Regions on Users.RegionRef = Regions.ID) join Roles on Users.RoleRef = Roles.ID ORDER BY RoleRef";
//    private static final String SQL_SELECT_COLUMN_NOTEXISTED_LOGIN = "SELECT * FROM Users WHERE Login=";


	private String username = "db207";
	private String password = "db207";
	private String url = "jdbc:jtds:sqlserver://127.0.0.1/Lv207OMS;instance=SQLEXPRESS;";
	
	
	private Connection createConnection(){
        Connection con;
        try {
            DriverManager.registerDriver(new net.sourceforge.jtds.jdbc.Driver());
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            throw new RuntimeException(SQL_EXCEPTION_FOUND, e);
        }
        return con;
    }

    
    private void closeConnection(Connection con, Statement st) throws Exception{
            closeConnection(con, st, null);
    }
    
    
    private void closeConnection(Connection con, Statement st, ResultSet rs) throws Exception {
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

    
	public List<List<String>> getAllCells(String absoluteFilePath, String name) {
		List<List<String>> allCells = new ArrayList<List<String>>();
		List<String> rowCells = null;
		Statement st = null;
		ResultSet rs = null;
		int columnCount = 0;
		Connection con = createConnection();
      
		try {
			st = con.createStatement();
			rs = st.executeQuery(SQLQueries.SQL_SELECT_USERS.getQuery());
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
			closeConnection(con, st, rs);
		} catch (Exception e) {
			throw new RuntimeException(SQL_EXCEPTION_FOUND, e);
		}
		return allCells;
	}

	public void deleteUsersFromDB(){
		Statement st = null;
		Connection con = createConnection();
 
		try {
			st = con.createStatement();
			st.execute(SQLQueries.SQL_DELETE_USERS_FIRSTNAME.getQuery());
		    closeConnection(con, st);
		} catch (Exception e) {
			throw new RuntimeException(SQL_EXCEPTION_FOUND, e);
		}
	}

	public List<String> getOneColumn(String nameOfColumn) {
 		List<String> listOfOneColumn = new ArrayList<>();	 
		Statement st = null;
		ResultSet rs = null;
		Connection con = createConnection();
		try {
			st = con.createStatement();
			switch (nameOfColumn) {
				case ("lastName"):  rs = st.executeQuery(SQLQueries.SQL_SELECT_COLUMN_LASTNAME.getQuery());
					break;
				case ("login"):  rs = st.executeQuery(SQLQueries.SQL_SELECT_COLUMN_LOGIN.getQuery());
					break;
				case ("role"):  rs = st.executeQuery(SQLQueries.SQL_SELECT_COLUMN_ROLE.getQuery());
					break;
			}

			while (rs.next()) {
				listOfOneColumn.add(rs.getString(1));
			}
		  closeConnection(con, st, rs);
		} catch (Exception e) {
			throw new RuntimeException(SQL_EXCEPTION_FOUND, e);
		}
		return listOfOneColumn;
	}

	public User getUserByLogin(String login) {
		User user = null;
		Statement st = null;
		ResultSet rs = null;
		int columnCount;
		Connection con = createConnection();
	 
		try {
			st = con.createStatement();
			String query=SQLQueries.SQL_SELECT_USER_BY_LOGIN.getQuery() +"\'"+ login+"\';";
			System.out.println(query);
			rs = st.executeQuery(query);
			columnCount = rs.getMetaData().getColumnCount();
			while (rs.next()) {
				user = new User("", "", "", "", "", "", "");
				for (int i = 1; i <= columnCount; i++) {
					switch (i) {
						case 1:
							user.setLoginname(rs.getString(i));
							break;
						case 2:
							user.setFirstname(rs.getString(i));
							break;
						case 3:
							user.setLastname(rs.getString(i));
							break;
						case 4:
							user.setPassword(rs.getString(i));
							break;
						case 5:
							user.setEmail(rs.getString(i));
							break;
						case 6:
							user.setRole(rs.getString(i));
							break;
						case 7:
							user.setRegion(rs.getString(i));
							break;
					}
				}
			}
		  closeConnection(con, st, rs);
//		} catch (java.sql.SQLException e) {
		}  catch (Exception e) {
			throw new RuntimeException(SQL_EXCEPTION_FOUND, e);
		}
		return user;
	}

	
    public List<String> getLogins(String sqlQuery){
        List<String> logins = new ArrayList<>();
        Statement st = null;
        ResultSet rs = null;
        Connection con = createConnection();
        
        try {
            st = con.createStatement();
            rs = st.executeQuery(sqlQuery);
            while (rs.next()) {
                logins.add(rs.getString("Login"));
                //System.out.println("getting "+rs.getString("login"));
            }
          closeConnection(con, st, rs);
        } catch (Exception e) {
            throw new RuntimeException(SQL_EXCEPTION_FOUND, e);
        }
        return logins;
    }
    
    public void deleteUserFromDB(String userLogin) {

        Statement st;
        Connection con = createConnection();

        try {
            st = con.createStatement();
            st.execute(SQLQueries.DELETE_FROM_USERS_WHERE_LOGIN_EQUALS.getQuery()
                    + "\'" + userLogin + "\'");
            closeConnection(con, st);
        } catch (Exception e) {
            throw new RuntimeException(SQL_EXCEPTION_FOUND, e);
        }
    }

    public int countAllUsers(){ 

        Statement st = null;
        ResultSet rs = null;
        int userCount = 0;

        Connection con = createConnection();

        try {
            st = con.createStatement();
            rs = st.executeQuery(SQLQueries.SQL_COUNT_ALL_USERS.getQuery());
            
            rs.next();
            userCount = rs.getInt(1);
            closeConnection(con, st, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        return userCount;
    }

    public List<User> getTopFiveUsers() {

        List<User> users = new ArrayList<>();
        Statement st;
        ResultSet rs;

        Connection con = createConnection();

        try {
            st = con.createStatement();
            rs = st.executeQuery(SQLQueries.SQL_SELECT_COLUMN_USER_FIVE_VALUES.getQuery());

            while (rs.next()) {
                User user = new User(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)
                        );
                users.add(user);
            }
            closeConnection(con, st,rs);

        } catch (Exception e) {
            throw new RuntimeException(SQL_EXCEPTION_FOUND, e);
        }

        return users;
    }

    public boolean verifyThatUserIsInDB(String loginOfUser){ 

        Statement st;
        ResultSet rs;
        boolean userIsInDB = false; 
        Connection con = createConnection();

        try{
            st = con.createStatement();
            rs = st.executeQuery(SQLQueries.SQL_SELECT_COLUMN_NOTEXISTED_LOGIN.getQuery() + "\'" + loginOfUser + "\'");
            userIsInDB = rs.next();
            closeConnection(con, st,rs);
        }catch (Exception e) {
            e.printStackTrace();
        }
        
        return userIsInDB;
    }
}