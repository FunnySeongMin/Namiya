package com.namiya.controller;

public class HandlerMapping {
	private static HandlerMapping instance=new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return instance;
	}
	public Controller create(String command) {
		//dispatcher가 보낸 정보를 기반으로 해당 정보를 처리하기 위한
		//Controller을 호출하여 그 내용을 전달한다.
		//이것을 위해 Controller Interface가 필요하다.
		Controller c=null;
		
		return c;
	}
}
