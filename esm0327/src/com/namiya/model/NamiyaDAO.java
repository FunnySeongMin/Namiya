package com.namiya.model;

public class NamiyaDAO {
	private static NamiyaDAO instance=new NamiyaDAO();
	private NamiyaDAO(){}
	public static NamiyaDAO getInstance() {
		return instance;
	}
}
