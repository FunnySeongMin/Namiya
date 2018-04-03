<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<style>
a.post {
	text-decoration: none;
	color: black;
}
</style>
<table class="table">
	<tr>
		<td colspan="3">제목: ${requestScope.postVO.pTitle}</td>
	</tr>
	<tr>
		<td>글번호 : ${requestScope.postVO.pNo}</td>
		<td>작성자 : ${requestScope.postVO.userVO.nickName}</td>
		<td>작성시간 : ${requestScope.postVO.pDate}</td>
	</tr>
	<tr>
		<td colspan="3"><pre>${requestScope.postVO.pContent}</pre></td>
	</tr>
</table>
<div class="btnArea">
	<c:if test="${requestScope.postVO.userVO.id==sessionScope.userVO.id}">
		<button type="button" class="btn btn-sm btn-default" onclick="deleteConfirm()">삭제</button>
		<button type="button" class="btn btn-sm btn-default" onclick="updateConfirm()">수정</button>
	</c:if>
	<button type="button" class="btn btn-primary btn-sm"
		onclick="location.href='dispatcher?command=ReadPostList'">목록</button>
		<c:if test="${sessionScope.userVO.grade=='a'}">

			<button type="button" class="btn btn-danger btn-sm"
		onclick="createReply()">답변하기</button>

		</c:if>

</div>
<div class="accordion" id="accordion2">
	<div class="accordion-group">
		<div class="accordion-heading">

			<a class="accordion-toggle" data-toggle="collapse"
				data-parent="#accordion2" href="#collapseOne"> 
				 Collapsible Group Item #1
			</a>
		</div>
		<div id="collapseOne" class="accordion-body collapse">
			<div class="accordion-inner"><c:if test="requestScope.postVO.reply==1">
		<div id="replyview"><!-- 답글 보기 -->
				<c:import url="/reply/replyview.jsp"/>
		</div><!-- 답글 보기 -->
	</c:if>
	</div>
		</div>
	</div>
</div>

		<div id="replyupdateview"><!-- 답글 수정하기 -->
			<c:import url="/reply/replyupdateview.jsp"/>
	</div><!-- 답글 수정하기 -->


<br>
<br>
<br>

<script type="text/javascript">

	$(document).ready(function() {
		$("#replyupdateview").hide(); 
	})
	
	function createReply() {
		$("#replyupdateview").show();
	}
	function deleteConfirm() {
		var url = "${pageContext.request.contextPath}/dispatcher?command=DeletePost&pNo=${requestScope.postVO.pNo}";
		confirmModal("게시글을 삭제하시겠습니까?",url,"danger")
	}
	function updateConfirm() {
		var url = "${pageContext.request.contextPath}/dispatcher?command=UpdatePostView&pNo=${requestScope.postVO.pNo}";
		confirmModal("게시글을 수정하시겠습니까?",url,"success")
	}
	
	function confirmModal(msg,url,css) {
		BootstrapDialog.confirm({
			title : "<i class='fas fa-check-circle'></i> 알림",
            message: msg,
            type : "type-"+css,
            btnCancelLabel: '취소', 
            btnOKLabel: '확인', 
            btnOKClass: 'btn-'+css,
            callback: function(result) {
                if(result) {
                    location.href = url;
                }else {
                	
                }
            }
        });
	}
</script>
