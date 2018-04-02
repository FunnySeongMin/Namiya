package com.namiya.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException{
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close(); 
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException{
		if(rs!=null)
			rs.close();
		closeAll(pstmt,con);
	}	

	//게시글 등록 메서드
	public void createPost(NamiyaPostVO postVO) {
		
	}//method

	//답변 등록 메서드
	public void createReply(NamiyaAnswerVO answerVO) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql=null;
		try {
			con=dataSource.getConnection();
			sql="UPDATE namiya_post SET reply = 1 WHERE p_no = ?";
			pstmt=con.prepareStatement(sql);
			pstmt.executeUpdate();
			pstmt.close();
			sql="insert into namiya_answer(p_no,a_title,a_content) valuse(?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, answerVO.getpNo());
			pstmt.setString(2, answerVO.getaTitle());
			pstmt.setString(3, answerVO.getaContent());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
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
	public NamiyaAnswerVO readReply(int pno) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		NamiyaAnswerVO vo=new NamiyaAnswerVO();
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT a.p_no, a.a_title, a.a_content, to_char(a.a_date,'yyyy.mm.dd') ");
			sql.append("FROM namiya_answer a, namiya_post p ");
			sql.append("WHERE a.p_no = p.p_no and a.p_no=? ");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, pno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo=new NamiyaAnswerVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}//method

	//게시글의 내용을 수정하는 메서드
	public void updatePost(int pno) {
		
	}//method

	//답변의 내용을 수정하는 메서드
	public void updateReply(int pno, String aTitle, String aContent) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		try {
			con=dataSource.getConnection();
			String sql="update namiya_answer set a_title=?,a_content=? where p_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, aTitle);
			pstmt.setString(2, aContent);
			pstmt.setInt(3, pno);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}//method

	//게시글을 삭제하는 메서드
	public void deletePost(int pno) {
		
	}//method

	//답변을 삭제하는 메서드
	public void deleteReply(int pno) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		String sql=null;
		try{
			con=dataSource.getConnection();
			sql="update namiya_post set reply=0 where p_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pno);
			pstmt.executeUpdate();
			pstmt.close();
			sql="delete from namiya_answer where p_no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, pno);
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}//method
	
	//총 게시물 수를 반환하는 메서드
	public int getTotalPostCount() {
		
		return 0;
	}//method

	//답변이 없는 게시글의 목록을 가져오는 메서드
	public ArrayList<NamiyaPostVO> unAnsweredList(PagingBean pagingBean) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ArrayList<NamiyaPostVO> list=new ArrayList<NamiyaPostVO>();
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("select p.p_no,p.p_title,p.timeposted,p.p_lock,u.nickname ");
			sql.append("from (select row_number() over(order by p_no desc) as rnum,p_no,p_title,p_lock,reply, ");
			sql.append("id,to_char(p_date,'yyyy.mm.dd') timeposted from namiya_post) p ");
			sql.append(", namiya_user u where u.id=p.id and p.reply=0 and rnum between ? and ? ");
			pstmt=con.prepareStatement(sql.toString());
			//pstmt.setInt(1, pagingBean.getStartRowNumber());
			//pstmt.setInt(2, pagingBean.getEndRowNumber());
			pstmt.setInt(1, 1);
			pstmt.setInt(2, 5);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				NamiyaUserVO vo=new NamiyaUserVO();
				vo.setNickName(rs.getString(5));
				NamiyaPostVO pvo=new NamiyaPostVO();
				pvo.setpNo(rs.getInt(1));
				pvo.setpTitle(rs.getString(2));
				pvo.setpDate(rs.getString(3));
				pvo.setLock(rs.getString(4));
				pvo.setUserVO(vo);
				list.add(pvo);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return list;
	}//method
	
	//아이디 체크 메서드
	public String checkId(String id) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String flag=null;
		try {
			con=dataSource.getConnection();
			String sql="select id from namiya_user where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				flag=rs.getString(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return flag;
	}//method

	//답변없는 게시물의 총 숫자
	public int getUnAnsweredPostCount() throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int count=0;
		try {
			con=dataSource.getConnection();
			String sql="select count(*) from namiya_post where reply=0";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count=rs.getInt(1);
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}

	public NamiyaAnswerVO getUpdateAnswerView(int pno) throws SQLException {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		NamiyaAnswerVO vo=new NamiyaAnswerVO();
		try {
			con=dataSource.getConnection();
			StringBuilder sql=new StringBuilder();
			sql.append("SELECT a.a_title, a.a_content, to_char(a.a_date,'yyyy.mm.dd') ");
			sql.append("FROM namiya_answer a, namiya_post p ");
			sql.append("WHERE a.p_no = p.p_no and a.p_no=?");
			pstmt=con.prepareStatement(sql.toString());
			pstmt.setInt(1, pno);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				vo.setpNo(pno);
				vo.setaTitle(rs.getString(1));
				vo.setaContent(rs.getString(2));
				vo.setaDate(rs.getString(3));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}

	
}
