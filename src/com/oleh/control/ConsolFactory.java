package com.oleh.control;

public class ConsolFactory {
	
	private static String ADMIN = "admin";
	private static String USER = "user";
	public static Console getConsol(String name) {
		if(ADMIN.equalsIgnoreCase(name)) {
			return new AdminConsol();
		} else if (USER.equalsIgnoreCase(name)) {
			return new UserConsol();
		} else {
			return new UserConsol();
		}
		
	}
}
