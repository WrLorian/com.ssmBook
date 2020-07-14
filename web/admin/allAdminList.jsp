<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="altrowstable" id="alternatecolor" width="800px">
    <tr>
        <th>账号</th><th>用户名</th><th>密码</th><th>操作</th>
    </tr>
    <tr align="center">
        <c:forEach  items="${adminList}" var="u"><!-- 这里用到了ModelAndView方法 后端有改变的的话这里也要修改 -->
        <td>${u.adminid}嗷嗷</td>
        <td>${u.aname}嗷嗷</td>
        <td>${u.apassword}</td>
        <td>
            <a href="adminModify?id=${u.iid}">修改</a><!--返回id给后端，不一样的修改-->
            <a href="adminDelete?id=${u.iid}">删除</a><!--返回id给后端，不一样的修改-->
        </td>
        </c:forEach>
    </tr>
</table>

