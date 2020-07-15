<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title>精品推荐</title>
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
            background-color:lightcyan;
        }
        .evenrowcolor{
            background-color:lightblue;
        }
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
        #input4[type=button], #input4[type=submit], #input4[type=reset] {
            background-color:#1b6d85;
            border: none;
            color: white;
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
        #input3[type=text],#input3[type=password] {
            width: 100%;
            padding: 5px 20px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 2px solid #1b6d85;
            border-radius: 4px;
        }
    </style>
    <link rel="stylesheet" href="css/indexlayout.css">
</head>
<body>

<div class="header">
    <h1>书店订购</h1>
</div>

<div class="topnav">
    <a href="index.jsp">首页</a>
    <a href="recommend.jsp">精品推荐</a>
    <a href="new.jsp">新书上市</a>
    <a href="">购物车</a>
    <a href="order">我的订单</a>
    <a href="login.jsp">登出</a>
    <table><form method="post" action="">
        <tr><td> <input id="input2" type="text" name="search" placeholder="请输入书名、分类等"></td><td> <input id="input1" type="submit" name="search" value="搜索"></td></tr>
    </form></table>

</div>

<div class="row">
    <div class="leftcolumn">
        <div class="card">
            <h3>购物车</h3>
            <a></a>
            <table class="altrowstable" id="alternatecolor" width="800px">
                <th></th><th>书名</th><th>单价</th><th>数量</th><th>合计</th><th>操作</th>
                <tr align="center">
                    <c:forEach var="book" items="${cartList}">
                        <td> <a href="detail?bookId=${book.id}"><img src="../${book.cover}" class="thumb_big"/></a></td>
                        <td>${book.name}人间失格</td>
                        <td>${book.price}12</td>
                        <td>${book.num}1</td>
                        <td>${(book.price)*(book.num)}11</td>
                        <td>
                            <a href="detail?bookId=${book.id}" style="text-decoration:none;color: black;background-color: lightblue">添加</a>
                        <a href="detail?bookId=${book.id}" style="text-decoration:none;color: black;background-color: lightblue">减少</a>
                        <a href="detail?bookId=${book.id}" style="text-decoration:none;color: black;background-color: lightblue">删除</a>
                        </td>
                    </c:forEach>
                </tr>
            </table>
            <table width="800px">
                <form method="post">
                    <tr><td>收货人姓名：<input type="text" name="name" id="input3"></td>
                        <td>收货人电话：<input type="text" name="phone" id="input3"></td>
                        <td>收货人地址：<input type="text" name="address" id="input3"></td>
                    </tr>
                    <tr><td></td><td></td><td><input type="submit" name="confirm" value="提交" id="input4"></td></tr>
                </form>
            </table>
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
</body>
</html>