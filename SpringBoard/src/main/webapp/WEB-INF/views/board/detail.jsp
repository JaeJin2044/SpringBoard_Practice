<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>
	<h3>디테일 페이지 </h3>
	<div id="nav">
		<%@ include file="../inc/nav.jsp" %>
	</div>
	
	<div class="container">
		<form action="/board/mod" method="get">
			<div class="form-group">
				<label for="title">Title </label>
				 <input type="text" name="title" value="${data.title}"  readonly />
			</div>
			<div>
				<input type="hidden" name="bno" value="${data.bno}">
			</div>
			
			<div class="form-group">
				<label for="writer">Writer </label> <input type="text" name="writer" value="${data.writer}" readonly />
			</div>

			<div class="form-group">
				<label for="content">Content </label>
				<textarea class="form-control" name="content" rows="3" readonly >${data.content}</textarea>
			</div>
			<input type="submit" class="btn btn-primary" value="게시물 수정">
			<a href="/board/delete?bno=${data.bno}" class="btn btn-primary" >게시물 삭제 </a>
		</form>
	
	</div>
	<!--  댓글 시작 -->
	<hr />

	<ul>
		<li>
			<div>
				<p>첫번째 댓글 작성자</p>
				<p>첫번째 댓글</p>
			</div>
		</li>
		<li>
			<div>
				<p>두번째 댓글 작성자</p>
				<p>두번째 댓글</p>
			</div>
		</li>
		<li>
			<div>
				<p>세번째 댓글 작성자</p>
				<p>세번째 댓글</p>
			</div>
		</li>
	</ul>
	<div>
		<p>
			<label>댓글 작성자</label><input type="text">
		</p>
		<p>
			<textarea rows="5" cols="50"></textarea>
		</p>
		<p>
			<button type="button">댓글 작성</button>
		</p>
	</div>
	
	
	<!--  댓글 종료 -->
	

</body>
</html>