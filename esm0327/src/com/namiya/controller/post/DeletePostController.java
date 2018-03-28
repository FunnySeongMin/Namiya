package com.namiya.controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namiya.controller.Controller;
import com.namiya.model.NamiyaDAO;

public class DeletePostController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//게시글 삭제
		int pno=Integer.parseInt(request.getParameter(""));
		NamiyaDAO.getInstance().deletePost(pno);
		return null;
	}

}
