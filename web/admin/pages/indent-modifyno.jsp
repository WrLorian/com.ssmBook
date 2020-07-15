<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ssmBook.service.IndentService" %>
<%@ page import="ssmBook.pojo.indent" %>
<%
    IndentService service=new IndentService();
    indent result=service.getIndentById((Integer) request.getAttribute("id"));
    request.setAttribute("id",result.getUserId());
    request.setAttribute("name",result.getUserName());
    request.setAttribute("time",result.getTime());
    request.setAttribute("address",result.getLoc());
    request.setAttribute("phone",result.getTel());
%>
<html>
<head>
    <title>订单修改</title>
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
                <li><a href="../modifyPassword.jsp">修改密码</a></li><!--??-->
                <li><a href="logout">退出</a></li>
            </ul>
        </div>
        <div class="column1">
            <form method="post" action="/"><%--后续补充--%>
                <table align="center">
                    <tr><%--从业务角度分析其他值应为默认值--%>
                        <td>下单时间</td><td><input type="date" name="date" value="${time}"></td>
                    </tr><tr>
                    <td>用户账号</td><td><input type="text" name="userId" value="${id}"></td>
                </tr><tr>
                    <td>收货人姓名</td><td><input type="text" name="name" value="${name}"></td>
                </tr><tr>
                    <td>收货地址</td><td><input type="text" name="address" value="${address}"></td>
                </tr><tr>
                    <td>收货人联系方式</td><td><input type="text" name="tel" value="${phone}"></td>
                </tr><tr>
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
