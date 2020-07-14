<%--
  Created by IntelliJ IDEA.
  User: Yokyi
  Date: 2020/7/11
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="altrowstable" id="alternatecolor" width="800px">
    <tr>
        <th>图书编号</th><th>图书名称</th><th>图书图片</th><th>价格</th><th>库存数量</th><th>简介</th><th>作者</th><th>出版社</th><th>出版时间</th>
        <th>评分</th><th>分类编号</th><th>操作</th>
    </tr>
    <tr align="center">
        <c:forEach  items="${bookList}" var="u"><!-- 这里用到了ModelAndView方法 后端有改变的的话这里也要修改 -->
        <td>${u.bookid}嗷嗷</td>
        <td>${u.bookname}嗷嗷</td>
        <td>${u.img}</td>
        <td>${u.price}嗷嗷</td>
        <td>${u.count}嗷嗷</td>
        <td>${u.brief}</td>
        <td>${u.author}嗷嗷</td>
        <td>${u.press}嗷嗷</td>
        <td>${u.time}</td>
        <td>${u.grade}嗷嗷</td>
        <td>${u.categoryid}嗷嗷</td>
        <a href="bookModify?id=${u.bookid}">修改</a></td><!--返回id给后端，不一样的修改-->
        <a href="bookDelete?id=${u.bookid}">删除</a></td><!--返回id给后端，不一样的修改-->
        <a href="bookRecommend?id=${u.bookid}">设为推荐图书</a></td><!--返回id给后端，不一样的修改-->
        <a href="bookNew?id=${u.bookid}">设为最新图书</a></td><!--返回id给后端，个人觉得可以按时间排序更方便-->
        </c:forEach>
    </tr>
</table>