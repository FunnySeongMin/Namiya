package com.namiya.controller.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namiya.controller.Controller;
import com.namiya.model.NamiyaAnswerVO;
import com.namiya.model.NamiyaDAO;

public class CreateReplyController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//답변을 등록시키고 그 글의 번호를 반환받아 보여주는 컨트롤러
		int pNo=Integer.parseInt(request.getParameter(""));
		String pTitle=request.getParameter("");
		String pContent=request.getParameter("");
		NamiyaAnswerVO answerVO=new NamiyaAnswerVO(pNo,pTitle, pContent);
		NamiyaDAO.getInstance().createReply(answerVO);
		return "home.jsp";
	}

}
