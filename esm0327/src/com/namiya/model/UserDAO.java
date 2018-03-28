package com.namiya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public class UserDAO {
	private static UserDAO instance=new UserDAO();
	private DataSourceManager db;
	private DataSource dataSource;
	private UserDAO() {
		db=DataSourceManager.getInstance();
		dataSource=db.getDataSource();
	}
	public static UserDAO getInstance() {
		return instance;
	}
	public NamiyaUserVO login(String id, String password) throws SQLException {
		NamiyaUserVO vo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT nickname, grade");
			sql.append("FROM namiya_user");
			sql.append("WHERE id = ? AND PASSWORD = ?");
			/*
			SELECT nickname, grade
			FROM namiya_user
			WHERE id = 'test@naver.com' AND PASSWORD = '123'
			*/
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new NamiyaUserVO();
				vo.setId(id);
				vo.setNickName(rs.getString(1));
				vo.setGrade(rs.getString(2));
			}
		} finally {
			db.closeAll(rs, pstmt, con); 
		}
		return vo;
	}
}
