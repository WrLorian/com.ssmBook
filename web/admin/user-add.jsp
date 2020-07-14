<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    input[type=button], input[type=submit], input[type=reset] {
        background-color: #4CAF50;
        border: none;
        color: white;
        text-decoration: none;
        margin: 4px 2px;
        cursor: pointer;
        width: 80px;
        height: 30px;
    }
</style>
<form method="post" action="/userAdd"><%--后续补充--%>
    <table align="center">
        <tr>
            <td>账号</td><td><input type="text" name="userId"></td>
        </tr>
        <tr>
            <td>用户名</td><td><input type="text" name="userName"></td>
        </tr><tr>
        <td>密码</td><td><input type="password" name="uPassWord"></td>
    </tr><tr>
        <td>性别</td><td><input type="text" name="uSex"></td>
    </tr><tr>
        <td>年龄</td><td><input type="text" name="uAge"></td>
        </tr>
        <tr>
            <td>联系电话</td><td><input type="text" name="uTel"></td>
        </tr><tr>
        <td>地址</td><td><input type="text" name="uLoc"></td>
    </tr><tr align="center">
        <td><input type="submit" name="cancel" value="取消"></td><td><input type="submit" name="add" value="提交"></td>
    </tr>
    </table>
</form>
