package com.namiya.controller.post;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namiya.controller.Controller;
import com.namiya.model.ListVO;
import com.namiya.model.NamiyaDAO;
import com.namiya.model.NamiyaPostVO;
import com.namiya.model.PagingBean;

public class ReadPostListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//화면에 보여질 게시글의 목록을 가져오는 컨트롤러
		int totalCount=NamiyaDAO.getInstance().getTotalPostCount();
		String nowPage=request.getParameter("");
		PagingBean pagingBean=null;
		ArrayList<NamiyaPostVO> list=NamiyaDAO.getInstance().readPostList(pagingBean);
		ListVO vo=new ListVO(list, pagingBean);
		return null;
	}

}
