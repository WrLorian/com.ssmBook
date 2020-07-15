<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="altrowstable" id="alternatecolor" width="1000px">
    <tr>
        <th>图书编号</th><th>图书名称</th><th>图书图片</th><th>价格</th><th>库存数量</th><th>作者</th><th>出版社</th><th>出版时间</th>
        <th>评分</th><th>分类编号</th><th>操作</th>
    </tr>

        <c:forEach  items="${bookList}" var="u">
    <tr align="center">
        <td>${u.bookId}</td>
        <td>${u.bookName}</td>
        <td>${u.img}</td>
        <td>${u.price}</td>
        <td>${u.count}</td>
        <td>${u.author}</td>
        <td>${u.press}</td>
        <td>${u.time}</td>
        <td>${u.grade}</td>
        <td>${u.cId}</td>
        <td><a href="/bookUp?bookId=${u.bookId}">修改</a>
            <a href="/bookDelete?id=${u.bookId}">删除</a>


    </tr>
        </c:forEach>

</table>