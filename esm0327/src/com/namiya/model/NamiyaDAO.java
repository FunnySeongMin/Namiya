package com.namiya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class NamiyaDAO {
	private static NamiyaDAO instance = new NamiyaDAO();
	private DataSource dataSource;
	private DataSourceManager db;

	private NamiyaDAO() {
		db = DataSourceManager.getInstance();
		dataSource = db.getDataSource();
	}

	public static NamiyaDAO getInstance() {
		return instance;
	}
}
