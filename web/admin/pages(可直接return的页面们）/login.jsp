<%--
  Created by IntelliJ IDEA.
  User: Wangyh 有问题找我
  Date: 2020/7/9
  Time: 9:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员登录</title>
    <style>
        input[type=button], input[type=submit], input[type=reset] {
            background-color: #4CAF50;
            border: none;
            color: white;
            text-decoration: none;
            margin: 4px 2px;
            cursor: pointer;
            width: 80px;
            height: 40px;
        }
        input[type=text],input[type=password] {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 2px solid #4CAF50;
            border-radius: 4px;
        }
        body {
            margin: 0;
        }

        .header {
            background-color: #f1f1f1;
            padding: 20px;
            text-align: center;
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
    </style>
    <link rel="stylesheet" href="css/mylayout.css">
</head>
<body>
<div class="father" style="text-align: center">
    <div class="son">
        <div class="header" style="background-color:lightblue">
            <h2 style="font-family:'幼圆'" align="center">后台管理系统</h2>
        </div>
        <br>
        <form action="login" method="post">
            <table  align="center" width="300px" height="200px">
                <tr><td width="150px" align="center">用户</td>
                    <td><input type="text" name="adminid" placeholder="请输入注册账号"></td>
                </tr>
                <tr><td width="150px" align="center">密码</td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr><td align="center"><input type="checkbox" name="cookie" ></td><td height="30px">记住我</td></tr>
                <tr><td align="right"><input type="submit" value="注册" name="zc"></td><td><input type="submit" value="登录" name="denglu"></td></tr>
            </table>
        </form>
    </div>
</div>

</body>
</html>
