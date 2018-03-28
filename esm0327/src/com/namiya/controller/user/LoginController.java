package com.namiya.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namiya.controller.Controller;
import com.namiya.model.NamiyaUserDAO;
import com.namiya.model.NamiyaUserVO;

public class LoginController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//로그인 처리 컨트롤러
		String id=request.getParameter("");
		String password=request.getParameter("");
		NamiyaUserVO vo=NamiyaUserDAO.getInstance().login(id, password);
		return null;
	}

}
