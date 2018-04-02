package com.namiya.controller;

import com.namiya.controller.post.CreatePostController;
import com.namiya.controller.post.DeletePostController;
import com.namiya.controller.post.ReadMyPostListController;
import com.namiya.controller.post.ReadPostInfoController;
import com.namiya.controller.post.ReadPostListController;
import com.namiya.controller.post.UpdatePostController;
import com.namiya.controller.reply.CreateReplyController;
import com.namiya.controller.reply.DeleteReplyController;
import com.namiya.controller.reply.ReadReplyController;
import com.namiya.controller.reply.UnAnsweredListController;
import com.namiya.controller.reply.UpdateReplyController;
import com.namiya.controller.reply.UpdateReplyViewController;
import com.namiya.controller.user.CheckIdController;
import com.namiya.controller.user.CreateUserController;
import com.namiya.controller.user.DeleteUserController;
import com.namiya.controller.user.LoginController;
import com.namiya.controller.user.TotalUserCountController;
import com.namiya.controller.user.UpdateUserController;

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
		if(command.equals("Login")) {
			c=new LoginController();
		}else if(command.equals("CheckId")) {
			c=new CheckIdController();
		}else if(command.equals("CreateUser")) {
			c=new CreateUserController();
		}else if(command.equals("UpdateUser")) {
			c=new UpdateUserController();
		}else if(command.equals("DeleteUser")) {
			c=new DeleteUserController();
		}else if(command.equals("TotalUserCount")) {
			c=new TotalUserCountController();
		}else if(command.equals("CreatePost")) {
			c=new CreatePostController();
		}else if(command.equals("CreateReply")) {
			c=new CreateReplyController();
		}else if(command.equals("ReadPostList")) {
			c=new ReadPostListController();
		}else if(command.equals("ReadMyPostList")) {
			c=new ReadMyPostListController();
		}else if(command.equals("ReadPostInfo")) {
			c=new ReadPostInfoController();
		}else if(command.equals("ReadReply")) {
			c=new ReadReplyController();
		}else if(command.equals("UpdatePost")) {
			c=new UpdatePostController();
		}else if(command.equals("UpdateReplyView")) {
			c=new UpdateReplyViewController();
		}else if(command.equals("UpdateReply")) {
			c=new UpdateReplyController();
		}else if(command.equals("DeletePost")) {
			c=new DeletePostController();
		}else if(command.equals("DeleteReply")) {
			c=new DeleteReplyController();
		}else if(command.equals("UnansweredList")) {
			c=new UnAnsweredListController();
		}
		return c;
	}
}
