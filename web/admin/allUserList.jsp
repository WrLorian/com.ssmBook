<%--
  Created by IntelliJ IDEA.
  User: Wangyh
  Date: 2020/7/11
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="altrowstable" id="alternatecolor" width="800px">
    <tr>
        <th>账号</th><th>用户名</th><th>密码</th><th>性别</th><th>年龄</th><th>联系电话</th><th>地址</th><th>操作</th>
    </tr>
    <tr align="center">
        <c:forEach  items="${userList}" var="u"><!-- 这里用到了ModelAndView方法 后端有改变的的话这里也要修改 -->
        <td>${u.userid}嗷嗷</td>
        <td>${u.uname}嗷嗷</td>
        <td>${u.upassword}</td>
        <td>${u.usex}嗷嗷</td>
        <td>${u.uage}嗷嗷</td>
        <td>${u.utel}</td>
        <td>${u.uloc}嗷嗷</td>
        <td>
            <a href="userModify?id=${u.userid}">修改</a></td><!--返回id给后端，不一样的修改-->
            <a href="userDelete?id=${u.userid}">删除</a></td><!--返回id给后端，不一样的修改-->
        </td>
        </c:forEach>
    </tr>
</table>