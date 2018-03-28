package com.namiya.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namiya.controller.Controller;
import com.namiya.model.NamiyaUserDAO;

public class DeleteUserController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//회원탈퇴 
		String id=request.getParameter("");
		NamiyaUserDAO.getInstance().deleteUser(id);
		return null;
	}

}
