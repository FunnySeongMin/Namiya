package com.namiya.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namiya.controller.Controller;
import com.namiya.model.NamiyaUserDAO;
import com.namiya.model.NamiyaUserVO;

public class CreateUserController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//회원가입 처리 컨트롤러
		String id=request.getParameter("");
		String nickName=request.getParameter("");
		String password=request.getParameter("");
		NamiyaUserVO vo=new NamiyaUserVO(id, nickName, password);
		NamiyaUserDAO.getInstance().createUser(vo); 
		return "index.jsp";
	}
}
