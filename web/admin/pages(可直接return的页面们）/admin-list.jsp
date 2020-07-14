<%--
  Created by IntelliJ IDEA.
  User: Wangyh
  Date: 2020/7/9
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>管理员管理</title>
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
            document.getElementById("btnhref").innerHTML ="添加管理员";
            document.getElementById("btnhref").href ="javascript:divShow()";
        }
        function divShow1(){
            document.getElementById("btnshow1").style.display="block";
            document.getElementById("btnhref1").innerHTML ="关闭";
            document.getElementById("btnhref1").href ="javascript:divhidden1()";
        }
        function divhidden1(){
            document.getElementById("btnshow1").style.display="none";
            document.getElementById("btnhref1").innerHTML ="查看所有管理员";
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
                <li><a href="indent-list.jsp">订单管理</a></li>
                <li><a href="admin/admin-list.jsp">管理员管理</a></li>
                <li><a href="user-list.jsp">客户管理</a></li>
                <li><a href="book-list.jsp">商品管理</a></li>
                <li><a href="category-list.jsp">类别管理</a></li>
                <li><a href="../modifyPassword.jsp">修改密码</a></li>
                <li><a href="loggout">退出</a></li>
            </ul>
        </div>
        <div class="column1">
            <table align="center">
                <tr align="center"><td>
                    <form method="post" action="url"><!--传值-->
                    <input type="input" name="searchByUsername" placeholder="按用户名查询">&nbsp;<a href="search?username=${request.getParameter("searchByUsername")}" style="text-decoration:none;color: black;background-color: lightblue">搜索</a>
                </form></td>
                    <td> <form method="post" action="url">
                        <input type="input" name="searchByUserId" placeholder="按账号查询">&nbsp;<a href="search?userid=${request.getParameter("searchByUserId")}" style="text-decoration:none;color: black;background-color: lightblue">搜索</a>
                    </form></td>
                </tr>
            </table>
            <a href="javascript:divShow();" id="btnhref" style="text-decoration:none;color: black;background-color: lightblue">添加管理员</a>
            <a href="javascript:divShow1();" id="btnhref1" style="text-decoration:none;color: black;background-color: lightblue">查看所有管理员</a>
                <div id="btnshow" style=" display: none;">
             <c:import url="../admin-add.jsp"></c:import>
        </div>
                <div id="btnshow1" style="display: none;">
             <c:import url="../allAdminList.jsp"></c:import>
        </div>
        </div>    
    </div></div>
</div>
</body>
</html>
<img src="../img/bg1.JPG">

