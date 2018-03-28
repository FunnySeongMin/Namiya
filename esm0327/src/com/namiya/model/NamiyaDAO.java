package com.namiya.model;

import java.util.ArrayList;

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

	//게시글 등록 메서드
	public void createPost(NamiyaPostVO postVO) {
		
	}//method

	//답변 등록 메서드
	public void createReply(NamiyaAnswerVO answerVO) {
		
	}//method

	//pagingBean에 따른 row넘버 기준으로 게시물 목록을 반환하는 메서드
	public ArrayList<NamiyaPostVO> readPostList(PagingBean pagingBean) {
		
		return null;
	}//method

	//내가 작성한 글 총 개수를 반환하는 메서드
	public int readMyPostCount() {
		
		return 0;
	}//method

	//전달받은 글번호에 맞는 글의 내용을 반환하는 메서드
	public NamiyaPostVO readPostInfo(int pno) {
		// TODO Auto-generated method stub
		return null;
	}//method
	
	//전달받은 글번호에 맞는 답변의 내용을 반환하는 메서드
	public NamiyaAnswerVO readReply(int pno) {
		// TODO Auto-generated method stub
		return null;
	}//method

	//게시글의 내용을 수정하는 메서드
	public void updatePost(int pno) {
		
	}//method

	//답변의 내용을 수정하는 메서드
	public void updateReply(int pno) {
		
	}//method

	//게시글을 삭제하는 메서드
	public void deletePost(int pno) {
		
	}//method

	//답변을 삭제하는 메서드
	public void deleteReply(int pno) {
		
	}//method
	
	//총 게시물 수를 반환하는 메서드
	public int getTotalPostCount() {
		
		return 0;
	}//method

	//답변이 없는 게시글의 목록을 가져오는 메서드
	public ArrayList<NamiyaPostVO> unAnswerList(PagingBean pagingBean) {
		
		return null;
	}//method
}
