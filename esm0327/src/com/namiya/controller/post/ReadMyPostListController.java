package com.namiya.controller.post;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namiya.controller.Controller;
import com.namiya.model.ListVO;
import com.namiya.model.NamiyaDAO;
import com.namiya.model.NamiyaPostVO;
import com.namiya.model.PagingBean;

public class ReadMyPostListController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//내가 작성한 글의 리스트를 뽑아내기 위해서 우선 내가 작성한 글의 총 개수를 구하고
		//내가 작성한 글을 리스트에 저장한다.
		int totalCount=NamiyaDAO.getInstance().readMyPostCount();
		String nowPage=request.getParameter("");
		PagingBean pagingBean=null;
		ArrayList<NamiyaPostVO> list=NamiyaDAO.getInstance().readPostList(pagingBean);
		ListVO vo=new ListVO(list, pagingBean);
		return null;
	}

}
