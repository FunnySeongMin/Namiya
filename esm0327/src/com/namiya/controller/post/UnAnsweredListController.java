package com.namiya.controller.post;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namiya.controller.Controller;
import com.namiya.model.ListVO;
import com.namiya.model.NamiyaDAO;
import com.namiya.model.NamiyaPostVO;
import com.namiya.model.PagingBean;

public class UnAnsweredListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//답변이 달리지 않은 목록을 뽑아낸다. 설명은 겹치는 부분이 많아 생략!
		int totalCount=NamiyaDAO.getInstance().getTotalPostCount();
		String nowPage=request.getParameter("");
		PagingBean pagingBean=null;
		ArrayList<NamiyaPostVO> list=NamiyaDAO.getInstance().unAnswerList(pagingBean);
		ListVO vo=new ListVO(list, pagingBean);
		return null;
	}

}
