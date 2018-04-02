package com.namiya.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namiya.model.NamiyaAnswerVO;
import com.namiya.model.NamiyaDAO;

public class UpdateReplyViewController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		int pno=Integer.parseInt(request.getParameter("pno"));
		NamiyaAnswerVO vo=NamiyaDAO.getInstance().getUpdateAnswerView(pno);
		request.setAttribute("avo", vo);
		request.setAttribute("url", "/reply/replyupdateview.jsp");
		return "home.jsp";
	}

}
