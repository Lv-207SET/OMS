package com.softserve.edu.oms.tests.createuser;

public class TsetVars {
	
	private static String username = System.getenv("db_username");
	private static String password = System.getenv("db_password");
	private static String url = System.getenv("db_url");
	private static String url_oms = System.getenv("oms_loginPageUrl");
	
	
	public static void main(String[] args){
		System.out.println(System.getenv("db_username"));
		System.out.println(password);
		System.out.println(url);
		System.out.println(url_oms);
	}

}
