package com.namiya.controller.post;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namiya.controller.Controller;
import com.namiya.model.NamiyaDAO;
import com.namiya.model.NamiyaPostVO;

public class ReadPostInfoController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//글번호에 맞는 게시글의 내용 뽑아내기
		int pno=Integer.parseInt(request.getParameter(""));
		NamiyaPostVO vo=NamiyaDAO.getInstance().readPostInfo(pno);
		return null;
	}

}
