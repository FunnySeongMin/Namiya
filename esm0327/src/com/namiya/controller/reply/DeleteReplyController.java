package com.namiya.controller.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namiya.controller.Controller;
import com.namiya.model.NamiyaDAO;

public class DeleteReplyController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//답변 삭제
		int pno=Integer.parseInt(request.getParameter(""));
		NamiyaDAO.getInstance().deleteReply(pno);
		return null;
	}

}
