<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">
	function deleteConfirm() {
		if (confirm("게시글을 삭제하시겠습니까?")) {
			location.href = "${pageContext.request.contextPath}/dispatcher?command=DeletePost&pNo=${requestScope.postVO.pNo}";
		} else {
			location.href = "${pageContext.request.contextPath}/dispatcher?command=ReadPostInfo&pNo=${requestScope.postVO.pNo}";
		}
	}
	function updateConfirm() {
		if (confirm("게시글을 수정하시겠습니까?")) {
			location.href = "${pageContext.request.contextPath}/dispatcher?command=UpdatePostView&pNo=${requestScope.postVO.pNo}";
		} else {
			location.href = "${pageContext.request.contextPath}/dispatcher?command=ReadPostInfo&pNo=${requestScope.postVO.pNo}";
		}
	}
</script>
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
			<button type="button" class="btn btn-danger btn-sm" onclick="location.href='#'">답변하기</button>
		</c:if>

</div>

<br>
<br>
<br>
