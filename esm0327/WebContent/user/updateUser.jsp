<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="row updateForm">
	<div class="col-sm-offset-2 col-sm-7 text-center animated fadeInDown">
		<div class="panel panel-primary" id="panels" data-effect="helix">
			<div class="panel-heading">개인정보 수정</div>
			<div class="panel-body">
				<form class="form-horizontal"
					action="${pageContext.request.contextPath }/dispatcher"
					method="post" onsubmit="">
					<div class="form-group">
						<label for="inputEmail" class="col-sm-offset-1 col-sm-3 control-label">이메일</label>
						<div class="col-sm-4 input-group">
							<span class="input-group-addon"><i class="fas fa-envelope"></i></span>
							<input type="text" class="form-control" name ="id" value="${userVO.id }"
								placeholder="이메일" readonly>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-sm-offset-1 col-sm-3 control-label">닉네임</label>
						<div class="col-sm-4 input-group">
							<span class="input-group-addon"><i class="fas fa-user"></i></span>
							<input type="text" class="form-control" name="nickName" value="${userVO.nickName }"
								placeholder="닉네임" onkeyup="this.value=this.value.replace(/\s/g,'')">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-sm-offset-1 col-sm-3 control-label">비밀번호</label>
						<div class="col-sm-4 input-group">
							<span class="input-group-addon"><i class="fas fa-key"></i></span>
							<input type="password" class="form-control" name ="password" value="${userVO.password }"
								placeholder="비밀번호" onkeyup="this.value=this.value.replace(/\s/g,'')">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-sm-offset-1 col-sm-3 control-label">비밀번호확인</label>
						<div class="col-sm-4 input-group">
							<span class="input-group-addon"><i class="fas fa-key"></i></span>
							<input type="password" class="form-control" id="inputPassword2" value="${userVO.password }"
								placeholder="비밀번호확인" onkeyup="this.value=this.value.replace(/\s/g,'')">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-4">
							<input type="hidden" name="command" value="UpdateUser">
							<button type="submit" class="btn btn-primary btn-block">수정</button>
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-4 col-sm-4">
							<button type="button" id="delBtn" class="btn btn-danger btn-block">회원탈퇴</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script>
	$(document).ready(function() {
		$("#delBtn").click(function() {
			/* location.href = "${pageContext.request.contextPath}/dispatcher?command=DeleteUser&id=${userVO.id }"; */
			BootstrapDialog.show({
				type : "type-danger",
				title : "<i class='fas fa-exclamation-circle'></i> 알림",
				message : "정말로 회원탈퇴 하시겠습니까?",
				closable : false,
				onhidden : function(dialogRef) {
					location.href = "${pageContext.request.contextPath}/dispatcher?command=DeleteUser";
				},
				buttons : [ {
					label : "확인",
					cssClass : "btn-danger",
					hotkey : 13,
					action : function(cancel) {
						cancel.close();
					}
				},{
					label : "취소",
					hotkey : 27,
					action : function(cancel) {
						location.href = "${pageContext.request.contextPath}/index.jsp";
						cancel.close();
					}
				} ]
			}); // BootstrapDialog.show
		}); // click;
	}); // ready;
</script>