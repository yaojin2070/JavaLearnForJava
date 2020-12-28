<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2020-12-26
  Time: 16:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="test1" method="POST">
    <input name="username">
    <input type="submit" value="测试post">
</form>

<form action="test1" method="POST">
    <input type="hidden" name="_method" value="PUT">
    <input type="submit" value="测试put">
</form>

<form action="test1" method="POST">
    <input type="hidden" name="_method" value="DELETE">
    <input type="hidden" name="id">
    <input type="submit" value="测试delete">
</form>

<form action="test2" method="POST">
    <input name="name">
    <input name="password" type="password">
    <input type="submit" value="提交">
</form>
</body>
</html>
