<%--
  Created by IntelliJ IDEA.
  User: kim-yeonhui
  Date: 2023/12/02
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상세보기</title>
</head>
<body>
<h1>상세보기</h1>
<table id="edit">
    <tr><td>Title:</td><td>${board.title}</td></tr>
    <tr><td>Category:</td><td>${board.category}</td></tr>
    <tr><td>Writer:</td><td>${board.writer}</td></tr>
    <tr><td>Content:</td><td>${board.content}</td></tr>
    <tr><td>RegDate:</td><td>${board.regdate}</td></tr>
    <tr><td><a href="../posts">View All Records</a></td></tr>
</table>
</body>
</html>
