<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<style>
a.post {
	text-decoration: none;
	color: black;
}
</style>
<table class="table table-hover">
	<thead>
		<tr>
			<th>글번호</th>
			<th>진행상황</th>
			<th>글제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td><span class="label label-danger">진행중</span></td>
			<td><a class="post" href="#">여기는 제목1~~~</a></td>
			<td>테스트1</td>
			<td>2018.03.19</td>
		</tr>
		<tr>
			<td>2</td>
			<td><span class="label label-success">완료</span></td>
			<td><a class="post" href="#">여기는 제목2~~~</a></td>
			<td>테스트2</td>
			<td>2018.03.19</td>
		</tr>
		<tr>
			<td>3</td>
			<td><span class="label label-success">완료</span></td>
			<td><a href="#" class="post"><i class="fas fa-lock"></i>&nbsp;이거는 비공개글</a></td>
			<td>테스트3</td>
			<td>2018.03.19</td>
		</tr>
	</tbody>
</table>
<div class="col-sm-10 text-center">
	
	<div class="input-group col-sm-offset-4 col-sm-4">
		
		<!-- 검색메뉴 드랍다운 -->
		<div class="input-group-btn">
			<button id="menuBtn" type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
				제목 <span class="caret"></span>
			</button>
			<ul id="findMenu" class="dropdown-menu">
				<li><a href="#">제목</a></li>
				<li><a href="#">작성자</a></li>
				<li><a href="#">답변여부</a></li>
				<!-- <li class="divider"></li>
				<li><a href="#">Separated link</a></li> -->
			</ul>
		</div>
		
		<!-- 검색폼 -->
		<input type="text" class="form-control">
		<span class="input-group-btn">
			<button class="btn btn-primary" type="button"><i class="fas fa-search"></i></button>
		</span>
	</div>
	
	<script>
		$(document) .ready(function() {
			$("#findMenu li").click(function() {
				$("#menuBtn").html($(this).text()+' <span class="caret"></span>');
			})
		})
	</script>
	
	<!-- 페이징버튼 -->
	<ul class="pagination pagination">
		<li><a href="#">«</a></li>
		<li class="active"><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li class="disabled"><a href="#">»</a></li>
	</ul>
</div>
