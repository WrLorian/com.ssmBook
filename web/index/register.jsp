<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户注册</title>
    <style>
        #input1[type=text],#input1[type=password] {
            width: 100%;
            padding: 12px;
            margin: 8px 0;
            box-sizing: border-box;
            border: 2px solid #4CAF50;
            border-radius: 4px;
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
    </style>
    <link rel="stylesheet" href="css/indexlayout.css">
</head>
<body>
<div class="header" style="background-image: url('img/bg3.jpg')">
    <h1 style="font-family: 幼圆">书店订购</h1>
</div>
<div class="card" style="height: 800px">
    <form action="reg" method="post">
        <table  align="center" width="300px" height="200px">
            <tr><td width="150px" align="center">账号</td>
                <td><input type="text" name="userId" placeholder="请输入下次登录账号" id="input1"></td>
            </tr>
            <tr><td width="150px" align="center"  >用户名</td>
                <td><input type="text" name="userName" placeholder="请输入用户名" id="input1"></td>
            </tr>
            <tr><td width="150px" align="center" >密码</td>
                <td><input type="password" name="uPassWord" placeholder="请输入注册密码" id="input1"></td>
            </tr>
            <tr><td width="150px" align="center"  >性别</td>
                <td><input type="text" name="uSex" placeholder="输入性别" id="input1"></td>
            </tr>
            <tr><td width="150px" align="center"  >联系电话</td>
                <td><input type="text" name="uTel" placeholder="输入联系电话" id="input1"></td>
            </tr>
            <tr><td width="150px" align="center"  >收货地址</td>
                <td><input type="text" name="uLoc" placeholder="输入地址" id="input1"></td>
            </tr>
            <tr><td align="right"><input type="submit" value="取消" name="cancel"></td><td><input type="submit" value="确认" name="confirm"></td></tr>
        </table>
    </form>
</div>
<div class="alert alert-success" role="alert">${msg}</div>
</body>
</html>