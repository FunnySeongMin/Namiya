package com.namiya.controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namiya.controller.Controller;
import com.namiya.model.NamiyaDAO;
import com.namiya.model.NamiyaPostVO;
import com.namiya.model.NamiyaUserVO;

public class CreatePostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//게시글을 등록시키고 그 글의 번호를 반환받아 보여주는 컨트롤러
		String pTitle=request.getParameter("");
		String pContent=request.getParameter("");
		String lock=request.getParameter("");
		HttpSession session=request.getSession(false);
		NamiyaUserVO userVO=(NamiyaUserVO) session.getAttribute("");
		NamiyaPostVO	postVO=new NamiyaPostVO(pTitle, pContent, lock, userVO);
		NamiyaDAO.getInstance().createPost(postVO);
		return null;
	}

}
