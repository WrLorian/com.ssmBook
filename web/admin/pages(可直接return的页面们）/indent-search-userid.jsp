<%--
  Created by IntelliJ IDEA.
  User: Yokyi
  Date: 2020/7/10
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>通过订单id查找</title>
    <script type="text/javascript">
        function altRows(id){
            if(document.getElementsByTagName){

                var table = document.getElementById(id);
                var rows = table.getElementsByTagName("tr");

                for(i = 0; i < rows.length; i++){
                    if(i % 2 == 0){
                        rows[i].className = "evenrowcolor";
                    }else{
                        rows[i].className = "oddrowcolor";
                    }
                }
            }
        }

        window.onload=function(){
            altRows('alternatecolor');
        }
    </script>
    <style type="text/css">
        table.altrowstable {
            font-family: verdana,arial,sans-serif;
            font-size:11px;
            color:#333333;
            border-width: 1px;
            border-color: #a9c6c9;
            border-collapse: collapse;
        }
        table.altrowstable th {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #a9c6c9;
        }
        table.altrowstable td {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #a9c6c9;
        }
        .oddrowcolor{
            background-color:#d4e3e5;
        }
        .evenrowcolor{
            background-color:#c3dde0;
        }
        .header {
            background-color: #f1f1f1;
            padding: 20px;
            text-align: center;
        }
        .column {
            float: left;
            width: 100px;
            height: 600px;
            padding: 20px;
            margin-top: 20px;
        }
        .column1{
            float:left;
            width: 800px;
            height: 600px;
            padding: 20px;
            margin-top: 20px;
        }
        .father{
            width: 100%;
            height: 1200px;
        }
        .son{
            width: 1000px;
            height: 600px;
            position: absolute;
            margin: 10px 20%;
        }
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }

        li a {
            display: block;
            color: #000;
            padding: 8px 16px;
            text-decoration: none;
        }

        li a.active {
            background-color: #4CAF50;
            color: white;
        }

        li a:hover:not(.active) {
            background-color: #555;
            color: white;
        }
    </style>
    <link rel="stylesheet" href="../css/bootstrap.css"/>
    <link rel="stylesheet" href="../css/mylayout.css"/>
</head>
<body>
<div class="father" style="text-align: center">
    <div class="son">
        <div class="header" style="background-color: #5bc0de">
            <h2 style="font-family:'幼圆'" align="center">后台管理系统</h2>
        </div>
        <div class="column" style="text-align: center;background-color: lightblue">
            <ul class="nav navbar-nav">
                <li><a href="indent-list.jsp">订单管理</a></li>
                <li><a href="admin-list.jsp">管理员信息管理</a></li>
                <li><a href="user-list.jsp">客户管理</a></li>
                <li><a href="book-list.jsp">商品管理</a></li>
                <li><a href="category-list.jsp">类别管理</a></li>
                <li><a href="../modifyPassword.jsp">修改密码</a></li>
                <li><a href="login.jsp">退出</a></li>
            </ul>
        </div>
        <div class="column1">
            <a href="indent-list.jsp" style="text-decoration:none;color: black;background-color: lightblue">返回</a>
            <table class="altrowstable" id="alternatecolor" width="800px">
                <tr>
                    <th>订单编号</th><th>下单时间</th><th>用户账号</th><th>收货人姓名</th><th>收货地址</th><th>收货人联系方式</th><th>订单状态</th><th>操作</th>
                </tr>
                <tr align="center">
                    <c:forEach  items="${requestScope.indent}" var="u"><!-- 这里用到了ModelAndView方法 后端有改变的的话这里也要修改 -->
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
        </div>    
    </div></div>

</div>


</body>
</html>


