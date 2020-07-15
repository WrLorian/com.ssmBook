<%--
  Created by IntelliJ IDEA.
  User: Yokyi
  Date: 2020/7/11
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>分类管理</title>
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
        function divShow(){
            document.getElementById("btnshow").style.display="block";
            document.getElementById("btnhref").innerHTML ="关闭";
            document.getElementById("btnhref").href ="javascript:divhidden()";
        }
        function divhidden(){
            document.getElementById("btnshow").style.display="none";
            document.getElementById("btnhref").innerHTML ="添加分类";
            document.getElementById("btnhref").href ="javascript:divShow()";
        }
        function divShow1(){
            document.getElementById("btnshow1").style.display="block";
            document.getElementById("btnhref1").innerHTML ="关闭";
            document.getElementById("btnhref1").href ="javascript:divhidden1()";
        }
        function divhidden1(){
            document.getElementById("btnshow1").style.display="none";
            document.getElementById("btnhref1").innerHTML ="查看所有分类";
            document.getElementById("btnhref1").href ="javascript:divShow1()";
        }
        function divShow2(){
            document.getElementById("btnshow2").style.display="block";
            document.getElementById("btnhref2").innerHTML ="关闭";
            document.getElementById("btnhref2").href ="javascript:divhidden2()";
        }
        function divhidden2(){
            document.getElementById("btnshow2").style.display="none";
            document.getElementById("btnhref2").innerHTML ="增加订单";
            document.getElementById("btnhref2").href ="javascript:divShow2()";
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
                <li><a href="indentList">订单管理</a></li>
                <li><a href="adminList">管理员管理</a></li>
                <li><a href="userList">客户管理</a></li>
                <li><a href="bookList">商品管理</a></li>
                <li><a href="categoryList">类别管理</a></li>
                <li><a href="logout">退出</a></li>
            </ul>
        </div>
        <div class="column1">
            <a href="/categoryAd" id="btnhref" style="text-decoration:none;color: black;background-color: lightblue">添加分类</a>
                <div>
             <table class="altrowstable" id="alternatecolor" width="800px">
            <tr>
                <th>编号</th><th>分类名</th><th>操作</th>
            </tr>
                <c:forEach  items="${categoryList}" var="u"><!-- 这里用到了ModelAndView方法 后端有改变的的话这里也要修改 -->
            <tr align="center">
                <td>${u.cId}</td>
                <td>${u.cName}</td>
                <td>
                    <a href="categoryUp?id=${u.cId}">修改</a>
                <a href="categoryDelete?id=${u.cId}">删除</a>
                </td>
            </tr>
                </c:forEach>
            <tr><td colspan="3">
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    <tr>
                        <td style="background: #1b6d85">${pageTool}</td>
                    </tr>
                </table>
            </td>
            </tr>
        </table>
        </div>
        </div>    
    </div></div>
</div>
<div class="alert alert-success" role="alert">${msg}</div>
</body>
</html>