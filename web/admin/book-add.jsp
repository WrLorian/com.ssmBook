<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<form method="post" action="/bookAdd"><%--后续补充--%>
    <table align="center">
        <tr>
            <td>图书名称</td><td><input type="text" name="bookName"></td>
        </tr><tr>
        <td>图书图片</td><td><input type="text" name="img" placeholder="请输入图片路径"></td>
    </tr><tr>
        <td>价格</td><td><input type="text" name="price"></td>
    </tr><tr>
        <td>库存数量</td><td><input type="text" name="count"></td>
    </tr><tr>
        <td>简介</td><td><input type="text" name="brief"></td>
    </tr><tr>
        <td>作者</td><td><input type="text" name="author"></td>
    </tr><tr>
        <td>出版社</td><td><input type="text" name="press"></td>
    </tr><tr>
        <td>出版时间</td><td><input type="text" name="time"></td>
    </tr><tr>
        <td>评分</td><td><input type="text" name="grade"></td>
    </tr><tr>
        <td>分类</td><td><input type="text" name="cId" placeholder="请输入分类编号"></td>
    </tr><tr>
        <td><input type="submit" name="cancel" value="取消"></td><td><input type="submit" name="add" value="提交"></td>
    </tr>
    </table>
</form>


