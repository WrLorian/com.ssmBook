<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户登录</title>
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
    </style>
    <link rel="stylesheet" href="css/indexlayout.css">
</head>
<body>

<div class="header">
    <h1 style="font-family: 幼圆">书店订购</h1>
</div>
<div class="card" style="height: 800px">
    <form action="/index/userLogin" method="post">
        <table  align="center" width="300px" height="200px">
            <tr><td width="150px" align="center">用户</td>
                <td><input type="text" name="userName" placeholder="请输入注册账号"></td>
            </tr>
            <tr><td width="150px" align="center"  placeholder="请输入注册密码">密码</td>
                <td><input type="password" name="uPassWord"></td>
            </tr>
            <tr><td align="center"><input type="checkbox" name="cookie" ></td><td height="30px">记住我</td></tr>
            <tr><td align="right"><a href="/index/reg" >没有账号?注册</a></td><td><input type="submit" value="登录" name="log"></td></tr>
        </table>
    </form>
</div>
<div class="alert alert-success" role="alert">${msg}</div>
</body>
</html>