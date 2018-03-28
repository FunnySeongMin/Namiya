package com.namiya.controller.reply;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namiya.controller.Controller;
import com.namiya.model.NamiyaAnswerVO;
import com.namiya.model.NamiyaDAO;
import com.namiya.model.NamiyaPostVO;
import com.namiya.model.NamiyaUserVO;

public class CreateReplyController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//답변을 등록시키고 그 글의 번호를 반환받아 보여주는 컨트롤러
		String pTitle=request.getParameter("");
		String pContent=request.getParameter("");
		HttpSession session=request.getSession(false);
		NamiyaUserVO userVO=(NamiyaUserVO) session.getAttribute("");
		NamiyaAnswerVO answerVO=new NamiyaAnswerVO(pTitle, pContent, userVO);
		NamiyaDAO.getInstance().createReply(answerVO);
		return null;
	}

}
