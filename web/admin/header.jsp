<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <link rel="stylesheet" href="css/bootstrap.css"/>
    <style>
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
</head>
<body>
<div class="header" style="background-color: #5bc0de">
    <h2 style="font-family:'幼圆'" align="center">后台管理系统</h2>
</div>
<div class="column" style="text-align: center;background-color: lightblue">
    <ul class="nav navbar-nav">
        <li><a href="pages/indent-list.jsp">订单管理</a></li>
        <li><a href="#">客户管理</a></li>
        <li><a href="#">商品管理</a></li>
        <li><a href="#">类别管理</a></li>
        <li><a href="#">修改密码</a></li>
        <li><a href="#">退出</a></li>
    </ul>
</div>
</body>
</html>