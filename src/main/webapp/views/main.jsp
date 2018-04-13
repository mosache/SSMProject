<%@ page import="com.vvv.models.User" %><%--
  Created by IntelliJ IDEA.
  User: vurtne
  Date: 2018/4/13
  Time: 上午11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>main</title>
</head>
<body>
    currentUser:<c:out value="${sessionScope.currentUser.username}"/>
</body>
</html>

