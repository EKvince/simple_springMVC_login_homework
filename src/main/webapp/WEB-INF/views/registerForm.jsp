<%--
  Created by IntelliJ IDEA.
  User: EKVINC
  Date: 2021/5/24
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form action="register2" method="post">
    <table border="2" align="center">
        <caption>用户注册</caption>
        <tr>
            <th>用户名：</th>
            <td><input name="username" id="username" type="text" /></td>
        </tr>
        <tr>
            <th>密码：</th>
            <td><input name="password" id="password" type="password" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="提交" width="120ppx" /></td>
        </tr>

    </table>
</form>
</body>
</html>
