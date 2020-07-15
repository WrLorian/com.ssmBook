<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ssmBook.service.UserService" %>
<%@ page import="ssmBook.pojo.user" %>
<html>
<head>
    <title>书籍修改</title>
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
                <li><a href="indentList">订单管理</a></li>
                <li><a href="adminList">管理员管理</a></li>
                <li><a href="userList">客户管理</a></li>
                <li><a href="bookList">商品管理</a></li>
                <li><a href="categoryList">类别管理</a></li>
                <li><a href="logout">退出</a></li>
            </ul>
        </div>
        <div class="column1">
            <form method="post" action="/userUpdate"><%--后续补充--%>
                <table align="center">
                    <tr>
                        <td>账号</td><td><input type="text" name="userId" value="${userMo.userId}"></td>
                    </tr>
                    <tr>
                        <td>用户名</td><td><input type="text" name="userName" value="${userMo.userName}"></td>
                    </tr><tr>
                    <td>密码</td><td><input type="password" name="uPassWord" value="${userMo.uPassWord}"></td>
                </tr><tr>
                    <td>性别</td><td><input type="text" name="uSex" value="${userMo.uSex}"></td>
                </tr><tr>
                    <td>年龄</td><td><input type="text" name="uAge" value="${userMo.uAge}"></td>
                </tr>
                    <tr>
                        <td>联系电话</td><td><input type="text" name="uTel" value="${userMo.uTel}"></td>
                    </tr><tr>
                    <td>地址</td><td><input type="text" name="uLoc" value="${userMo.uLoc}"></td>
                </tr><tr align="center">
                    <td><input type="submit" name="cancel" value="取消"></td><td><input type="submit" name="add" value="提交"></td>
                </tr>
                </table>
            </form>


            <div class="alert alert-success" role="alert">${msg}</div>
        </div>    
    </div></div>
</div>
</body>
</html>