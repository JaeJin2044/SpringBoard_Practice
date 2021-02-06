<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/css/bootstrap.css">
<style>
	thead, tbody,tr,th{
	text-align: center;
	
	}
	#postion_btn{
	  float: right;
	}
	a{
		text-decoration: none;
		color: black;
	}
	span{
		margin: 10px;	
	}
</style>
</head>
<body>
	<div id="nav">
		<%@ include file="../inc/nav.jsp" %>
	</div>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${list}" var="list">
				<tr>
					<td>${list.bno}</td> 
					<td><a href="/board/detail?bno=${list.bno}">${list.title}</a></td>
					<td>
					<fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd" />
					</td>
					<td>${list.writer}</td>
					<td>${list.viewCnt}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<c:forEach begin="1" end="${pageNum}" var="num">
			<span>
				<a href="/board/listPage?num=${num}">${num}</a>
			</span>
		</c:forEach>
	</div>

</body>
</html>