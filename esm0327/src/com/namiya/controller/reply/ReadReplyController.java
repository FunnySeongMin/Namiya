package com.namiya.controller.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namiya.controller.Controller;
import com.namiya.model.NamiyaAnswerVO;
import com.namiya.model.NamiyaDAO;
import com.namiya.model.NamiyaPostVO;

public class ReadReplyController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//번호에 해당하는 답변에 내용 가져오기
		int pno=Integer.parseInt(request.getParameter(""));
		NamiyaAnswerVO vo=NamiyaDAO.getInstance().readReply(pno);
		return null;
	}

}
