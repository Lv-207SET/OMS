package com.softserve.edu.oms.enums;

public enum SQLQueries {
    ACTIVE_USERS_ORDER_BY_ID("SELECT * FROM Users WHERE IsUserActive=1 ORDER BY ID"),
    ACTIVE_USERS_ORDER_BY_FIRST_NAME_ASC("SELECT * FROM Users WHERE IsUserActive=1 ORDER BY FirstName ASC"),
    ACTIVE_USERS_ORDER_BY_FIRST_NAME_DESC("SELECT * FROM Users WHERE IsUserActive=1 ORDER BY FirstName DESC"),
    ACTIVE_USERS_ORDER_BY_LAST_NAME_ASC("SELECT * FROM Users WHERE IsUserActive=1 ORDER BY LastName ASC"),
    ACTIVE_USERS_ORDER_BY_LAST_NAME_DESC("SELECT * FROM Users WHERE IsUserActive=1 ORDER BY LastName DESC"),
    SELECT_FROM_USERS_WHERE_LOGIN_EQUALS("SELECT * FROM Users WHERE Users.Login="),
    DELETE_FROM_USERS_WHERE_LOGIN_EQUALS("DELETE FROM Users WHERE Users.Login="),
    SQL_SELECT_USERS("select Users.Login, Users.FirstName, Users.LastName,"
            + " Users.Password, Users.Email, Regions.RegionName, Roles.RoleName"
            + " from (Users join Regions on Users.RegionRef = Regions.ID)"
            + " join Roles on Users.RoleRef = Roles.ID;"),
    SQL_SELECT_USER_BY_LOGIN("select Users.Login, Users.FirstName, Users.LastName,"
            + " Users.Password, Users.Email, Regions.RegionName, Roles.RoleName"
            + " from (Users join Regions on Users.RegionRef = Regions.ID)"
            + " join Roles on Users.RoleRef = Roles.ID"
            + " where IsUserActive=1 and Users.login="),
    SQL_COUNT_ALL_USERS("SELECT count (*) FROM Users WHERE IsUserActive=1"),
    SQL_SELECT_COLUMN_USER_FIVE_VALUES("select TOP 5 Users.Login, Users.FirstName, Users.LastName,Users.Password,"
            + " Users.Email, Regions.RegionName, Roles.RoleName from (Users join Regions on Users.RegionRef = Regions.ID)"
            + " join Roles on Users.RoleRef = Roles.ID ORDER BY RoleRef"),
    SQL_SELECT_COLUMN_NOTEXISTED_LOGIN("SELECT * FROM Users WHERE Login="),
    SQL_DELETE_USERS_FIRSTNAME("DELETE FROM Users WHERE FirstName='rrd'"),
    SQL_SELECT_COLUMN_LASTNAME("SELECT LastName FROM Users WHERE IsUserActive=1 AND LastName LIKE 'none%'"),
    SQL_SELECT_COLUMN_LOGIN("SELECT Login FROM Users WHERE IsUserActive=1 AND Login LIKE '%none%'"),
    SQL_SELECT_COLUMN_ROLE("SELECT r.RoleName FROM Users as u JOIN Roles as r on u.RoleRef=r.ID WHERE u.IsUserActive=1 AND r.RoleName not like '%er%'");
    

    private String query;

    public String getQuery() { return query;}

    SQLQueries(String query) { this.query = query; }
}
