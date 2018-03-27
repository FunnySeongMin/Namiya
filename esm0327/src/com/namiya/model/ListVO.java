package com.namiya.model;

import java.util.ArrayList;

public class ListVO {
	private ArrayList<NamiyaPostVO> list;
	private PagingBean pagingBean;
	public ListVO() {
		super();
	}
	public ListVO(ArrayList<NamiyaPostVO> list, PagingBean pagingBean) {
		super();
		this.list = list;
		this.pagingBean = pagingBean;
	}
	public ArrayList<NamiyaPostVO> getList() {
		return list;
	}
	public void setList(ArrayList<NamiyaPostVO> list) {
		this.list = list;
	}
	public PagingBean getPagingBean() {
		return pagingBean;
	}
	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}
	@Override
	public String toString() {
		return "ListVO [list=" + list + ", pagingBean=" + pagingBean + "]";
	}
}
