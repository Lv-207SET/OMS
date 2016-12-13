package com.softserve.edu.oms.enums;

public enum SQLQueries {
    ACTIVE_USERS_ORDER_BY_ID("SELECT * FROM Users WHERE IsUserActive=1 ORDER BY ID"),
    ACTIVE_USERS_ORDER_BY_FIRST_NAME_ASC("SELECT * FROM Users WHERE IsUserActive=1 ORDER BY FirstName ASC"),
    ACTIVE_USERS_ORDER_BY_FIRST_NAME_DESC("SELECT * FROM Users WHERE IsUserActive=1 ORDER BY FirstName DESC"),
    ACTIVE_USERS_ORDER_BY_LAST_NAME_ASC("SELECT * FROM Users WHERE IsUserActive=1 ORDER BY LastName ASC"),
    ACTIVE_USERS_ORDER_BY_LAST_NAME_DESC("SELECT * FROM Users WHERE IsUserActive=1 ORDER BY LastName DESC"),
    SELECT_FROM_USERS_WHERE_LOGIN_EQUALS("SELECT * FROM Users WHERE Users.Login="),
    DELETE_FROM_USERS_WHERE_LOGIN_EQUALS("DELETE FROM Users WHERE Users.Login=");



    private String query;

    public String getQuery() { return query;}

    SQLQueries(String query) { this.query = query; }
}
