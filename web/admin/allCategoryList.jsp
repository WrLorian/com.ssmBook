<%--
  Created by IntelliJ IDEA.
  User: Yokyi
  Date: 2020/7/11
  Time: 21:09
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="altrowstable" id="alternatecolor" width="800px">
    <tr>
        <th>编号</th><th>分类名</th><th>操作</th>
    </tr>

        <c:forEach  items="${categoryList}" var="u"><!-- 这里用到了ModelAndView方法 后端有改变的的话这里也要修改 -->
    <tr align="center">
        <td>${u.cId}</td>
        <td>${u.cName}</td>
        <td>
            <a href="categoryModify?id=${u.cId}">修改</a>
            <a href="categoryDelete?id=${u.cId}">删除</a>
        </td>
    </tr>
        </c:forEach>

</table>