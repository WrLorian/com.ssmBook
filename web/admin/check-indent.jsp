<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="altrowstable" id="alternatecolor" width="800px">
    <tr>
        <th>订单编号</th><th>下单时间</th><th>用户账号</th><th>收货人姓名</th><th>收货地址</th><th>收货人联系方式</th><th>订单状态</th><th>操作</th>
    </tr>
    <tr>
        <c:forEach  items="${indentCheckedList}" var="u"><!-- 这里用到了ModelAndView方法 后端有改变的的话这里也要修改 -->
        <td>${u.iId}</td>
        <td>${u.time}</td>
        <td>${u.userId}</td>
        <td>${u.uerName }</td>
        <td>${u.loc }</td>
        <td>${u.tel }</td>
        <td>${u.state }</td>
        <td><a href="/itemList?id=${u.iId}">详情</a>&nbsp;
            <a href="/deleteIndent?id=${u.iId}">删除</a></td><!--返回id给后端-->
        </c:forEach>
    </tr>
</table>

