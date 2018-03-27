package com.namiya.model;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DataSourceManager {
	//DB에 연결해주는 클래스
	private static DataSourceManager instance=new DataSourceManager();
	private DataSource ds;
	private DataSourceManager() {
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@127.0.0.1:1521:xe");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		ds=dataSource;
	}
	public static DataSourceManager getInstance() {
		return instance;
	}
	public DataSource getDataSource() {
		return ds;
	}
}
