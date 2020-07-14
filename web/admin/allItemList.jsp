<%--
  Created by IntelliJ IDEA.
  User: Yokyi
  Date: 2020/7/12
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="altrowstable" id="alternatecolor" width="800px">
    <tr>
        <th>图书编号</th><th>图书名称</th><th>图书单价</th><th>图书数量</th><th>合计</th><th>操作</th>
    </tr>
    <tr>
        <c:forEach  items="${itemList}" var="u"><!-- 这里用到了ModelAndView方法 后端有改变的的话这里也要修改 -->
        <td>${u.bookId}嗷嗷</td>
        <td>${u.bookName}嗷嗷</td>
        <td>${u.bookPrice}</td>
        <td>${u.bookNum }</td>
        <td>${(u.bookPrice)*(u.bookNum) }</td>
        <td><a href="itemAdd?id=${u.iid}">增加</a>&nbsp;
            <a href="itemMinus?id=${u.iid}">减少</a>&nbsp;
            <a href="itemDelete?id=${u.iid}">删除</a></td><!--返回id给后端-->
        </c:forEach>
    </tr>
</table>
