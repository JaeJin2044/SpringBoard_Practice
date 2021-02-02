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
	<h3>게시글 작성</h3>
	<div class="container">
		<form action="/board/write" method="post">
			<div class="form-group">
				<label for="title">Title </label> <input type="text" name="title"
					placeholder="글 제목" />
			</div>

			<div class="form-group">
				<label for="writer">Writer </label> <input type="text" name="writer"
					placeholder="작성자" />
			</div>

			<div class="form-group">
				<label for="content">Content </label>
				<textarea class="form-control" name="content" rows="3" placeholder="내용"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">글 작성</button>
		</form>

	</div>
</body>
</html>