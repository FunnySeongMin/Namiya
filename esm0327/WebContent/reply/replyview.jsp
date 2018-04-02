<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	$(document).ready(function(){
		$("#update").click(function(){
			location.href="dispatcher?command=UpdateReplyView&pno="+${requestScope.avo.pNo};
		});
		$("#delete").click(function(){
			location.href="dispatcher?command=DeleteReply&pno="+${requestScope.avo.pNo};
		});
	});
</script>
<table>
	<tr>
		<th colspan="2">제목 :  ${requestScope.avo.aTitle }		등록일 : ${requestScope.avo.aDate }</th>
	</tr>
	<tr>
		<th>내용</th>
		<th><pre>${requestScope.avo.aContent }</pre></th>
	</tr>
</table>
<br><br>
<input type="button" id="update" value="수정">	<input type="button" id="delete" value="삭제">