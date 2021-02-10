<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>
	<h3>디테일 페이지</h3>
	<div id="nav">
		<%@ include file="../inc/nav.jsp"%>
	</div>

	<div class="container">
		<form action="/board/mod" method="get">
			<div class="form-group">
				<label for="title">Title </label> <input type="text" name="title"
					value="${data.title}" readonly />
			</div>
			<div>
				<input type="hidden" name="bno" value="${data.bno}">
			</div>

			<div class="form-group">
				<label for="writer">Writer </label> <input type="text" name="writer"
					value="${data.writer}" readonly />
			</div>

			<div class="form-group">
				<label for="content">Content </label>
				<textarea class="form-control" name="content" rows="3" readonly>${data.content}</textarea>
			</div>
			<input type="submit" class="btn btn-primary" value="게시물 수정">
			<a href="/board/delete?bno=${data.bno}" class="btn btn-primary">게시물
				삭제 </a>
		</form>

	</div>
	<!--  댓글 시작 -->
	
	<hr />
	
	<ul>
		<c:forEach items="${reply}" var="reply">
			<li>
				<div>
					<p>${reply.writer} / <fmt:formatDate value="${reply.regDate}" pattern="yyyy-MM-dd"/></p>
					<p>${reply.content}</p>
				</div>
			</li>
		</c:forEach>
	</ul>




<div>
	<form action="/reply/write" method="post">
		<p>
			<label>댓글 작성자</label><input type="text" name="writer">
		</p>
		<p>
			<textarea rows="5" cols="50" name="content"></textarea>
		</p>
		<p>
			<input type="hidden" name="bno" value="${data.bno}">
			<button type="submit">댓글 작성</button>
		</p>
	</form>
</div>


	<!--  댓글 종료 -->


</body>
</html>