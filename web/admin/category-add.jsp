<%--
  Created by IntelliJ IDEA.
  User: Yokyi
  Date: 2020/7/11
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
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
<form method="post" action="/categoryAdd"><%--后续补充--%>
    <table align="center">
        <tr>
            <td>编号</td><td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>分类名</td><td><input type="text" name="name"></td>
        </tr>
        <td><input type="submit" name="cancel" value="取消"></td><td><input type="submit" name="add" value="提交"></td>
    </tr>
    </table>
</form>

