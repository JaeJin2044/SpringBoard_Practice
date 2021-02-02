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

<h3 style="text-align: center;">수정 페이지 </h3>
	<div class="container">
		<form action="/board/mod" method="post">
			<div class="form-group">
				<label for="title">Title </label>
				 <input type="text" name="title" value="${data.title}"/>
			</div>
			<div>
				<input type="hidden" name="bno" value="${data.bno}">
			</div>

			<div class="form-group">
				<label for="content">Content </label>
				<textarea class="form-control" name="content" rows="3">${data.content}</textarea>
			</div>
			<input type="submit" class="btn btn-primary" value="게시물 수정">
			<a href="/board/list" class="btn btn-primary">게시물 리스트</a>
		</form>
	
	</div>

</body>
</html>