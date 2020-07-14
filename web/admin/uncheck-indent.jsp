<%--
  Created by IntelliJ IDEA.
  User: Wangyh 有问题找我
  Date: 2020/7/9
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="altrowstable" id="alternatecolor" width="800px">
        <tr>
            <th>订单编号</th><th>下单时间</th><th>用户账号</th><th>收货人姓名</th><th>收货地址</th><th>收货人联系方式</th><th>订单状态</th><th>操作</th>
        </tr>
        <tr>
            <c:forEach  items="${indentCheckedList}" var="u"><!-- 这里用到了ModelAndView方法 后端有改变的的话这里也要修改 -->
            <td>${u.iid}嗷嗷</td>
            <td>${u.utime}嗷嗷</td>
            <td>${u.userid}</td>
            <td>${u.uname }</td>
            <td>${u.uloc }</td>
            <td>${u.utel }</td>
            <td>${u.ustate }</td>
            <td><a href="itemList?id=${u.iid}">详情</a>&nbsp;
                <a href="indentDispose?id=${u.iid}">处理</a>&nbsp;
                <a href="indentModify?id=${u.iid}">修改</a>
                <a href="indentDelete?id=${u.iid}">删除</a></td><!--返回id给后端-->
            </c:forEach>
        </tr>
    </table>
