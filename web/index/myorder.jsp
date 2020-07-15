<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>我的订单</title>
    <style>
        /* 响应式布局 - 屏幕尺寸小于 800px 时，两列布局改为上下布局 */
        @media screen and (max-width: 800px) {
            .leftcolumn, .rightcolumn {
                width: 100%;
                padding: 0;
            }
        }
        /* 响应式布局 -屏幕尺寸小于 400px 时，导航等布局改为上下布局 */
        @media screen and (max-width: 400px) {
            .topnav a {
                float: none;
                width: 100%;
            }
        }
        #input1[type=button], #input1[type=submit], #input1[type=reset] {
            background-color:white;
            border: none;
            color: black;
            text-decoration: none;
            margin: 4px 2px;
            cursor: pointer;
            width: 80px;
            height: 30px;
        }
        #input2[type=text],#input2[type=password] {
            width: 100%;
            padding: 5px 20px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 2px solid white;
            border-radius: 4px;
        }
    </style>
    <link rel="stylesheet" href="../index/css/indexlayout.css">
</head>
<body>

<div class="header" style="background-image: url('../index/img/bg3.jpg')">
    <h1 style="font-family: 幼圆">书店订购</h1>
</div>

<div class="topnav">
    <a href="/index">首页</a>
    <a href="/special">精品推荐</a>
    <a href="/news">新书上市</a>
    <a href="/cart">购物车</a>
    <a href="/order">我的订单</a>
    <a href="userLogout">登出</a>
    <table><form method="post" action="/index/search">
        <tr><td> <input id="input2" type="text" name="bookName" placeholder="请输入书名"></td><td> <input id="input1" type="submit" name="search" value="搜索"></td></tr>
    </form></table>

</div>

<div class="row">
    <div class="leftcolumn">
        <div class="card">
            <h3>我的订单</h3>
            <table border="1">
                <tr>
                    <td>订单编号</td><td>书籍总数</td><td>总价</td><td>下单时间</td>
                </tr>
                <c:forEach var="indent" items="${indentList}">
                <tr>
                        <td>${indent.iId}</td>
                        <td>${indent.amount}</td>
                        <td>${indent.total}</td>
                        <td>${indent.time}</td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="rightcolumn">
            <div class="card">
                <h2>欢迎光临</h2>
                <h2 style="color:#1b6d85;">书店简介</h2>
                <img src="../index/img/jg.jpg" width="200px">
                <p>本书店由嘉庚学子建设，为了服务大家方便网络订书而设置~</p>
            </div>
        <div class="card">
            <h3>图书分类</h3>
            <ul class="list">
                <c:forEach var="category" items="${categoryList}">
                    <li><a href="category?cId=${category.cId}" style="text-decoration:none;color: black;">${category.cName}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>
<div class="footer">
    <h4>@B书店订购系统</h4>
</div>

</body>
</html>