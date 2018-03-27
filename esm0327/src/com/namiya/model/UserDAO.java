package com.namiya.model;

public class UserDAO {
	private static UserDAO instance=new UserDAO();
	private UserDAO() {}
	public static UserDAO getInstance() {
		return instance;
	}
}
