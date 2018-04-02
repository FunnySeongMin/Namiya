package com.namiya.controller.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namiya.controller.Controller;
import com.namiya.model.ListVO;
import com.namiya.model.NamiyaDAO;
import com.namiya.model.NamiyaPostVO;
import com.namiya.model.NamiyaUserVO;
import com.namiya.model.PagingBean;

public class MyPostList implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null){
			return "redirect:index.jsp";
		}
		NamiyaUserVO vo=(NamiyaUserVO) session.getAttribute("userVO");
		String id=vo.getId();
		int myPostCount=NamiyaDAO.getInstance().readMyPostCount(id);
		String nowPage=request.getParameter("pageNo");
		PagingBean pagingBean=null;
		if(nowPage==null){
			pagingBean=new PagingBean(myPostCount);
		}else{
			pagingBean=new PagingBean(myPostCount,Integer.parseInt(nowPage));
		}
		ArrayList<NamiyaPostVO> list=NamiyaDAO.getInstance().myPostList(id,pagingBean);
		ListVO lvo=new ListVO(list, pagingBean);
		request.setAttribute("", lvo);
		request.setAttribute("url", "");
		return "home.jsp";
	}

}
