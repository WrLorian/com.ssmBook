<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>书店首页</title>
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
    <link rel="stylesheet" href="css/indexlayout.css">
</head>
<body>

<div class="header" style="background-image: url('img/bg3.jpg')">
    <h1>书店订购</h1>
</div>
<div class="topnav">
    <a href="index.jsp">首页</a>
    <a href="recommend.jsp">精品推荐</a>
    <a href="new.jsp">新书上市</a>
    <a href="shopList.jsp">购物车</a>
    <a href="order">我的订单</a>
    <a href="login.jsp">登出</a>
    <table><form method="post" action="">
        <tr><td> <input id="input2" type="text" name="search" placeholder="请输入书名、分类等"></td><td> <input id="input1" type="submit" name="search" value="搜索"></td></tr>
    </form></table>

</div>

<div class="row">
    <div class="leftcolumn">
        <div class="card">
                <div class="card">
                    <h3>精品推荐</h3>
                    <table>
                        <tr>
                            <c:forEach var="book" items="${specialList}">
                                <td> <a href="detail?bookId=${book.id}"><img src="../${book.cover}" class="thumb_big"/></a></td>
                                <td>${book.name}人间失格</td>
                                <td><a href="detail?bookId=${book.id}" style="text-decoration:none;color: black;background-color: lightblue">图书详情</a></td>
                                    <a href="detail?bookId=${book.id}" style="text-decoration:none;color: black;background-color: lightblue">加入购物车</a></td>
                                </td>
                            </c:forEach>
                        </tr>
                    </table>
                </div>
            </div>

        </div>
    <div class="rightcolumn">
        <div class="card">
            <h2>书店简介</h2>
            <div class="fakeimg" style="height:100px;">图片</div>
            <p>本书店由嘉庚学子建设，为了服务大家方便网络订书而设置~</p>
        </div>
        <div class="card">
            <h3>图书分类</h3>
            <ul class="list">
                <c:forEach var="category" items="${categoryList}">
                    <li><a href="category?categoryId=${category.id}">${category.name}</a></li>
                </c:forEach>
            </ul>
        </div>
    </div>
</div>

<div class="footer">
    <h4>@B书店订购系统</h4>
</div>
<img src="img/bg3.jpg">
</body>
</html>