<%--
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
    <title>login</title>
    <link href="../resource/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .center_block {
            display: block;
            margin-left: auto;
            margin-right: auto;
        }
    </style>
</head>
<body>
<div class="container" style="margin-top: 80px">
    <form action="/loginAction" method="post" class="form-horizontal col-sm-6 col-sm-offset-3">

        <div class="row">
            <div class="col-sm-offset-3">
                <c:if test="${errorMsg != null}">
                    <div style="color: red" ><c:out value="${errorMsg}"/></div>
                </c:if>
            </div>
        </div>

        <div class="form-group">
            <label for="username" class="control-label col-sm-2">username:</label>
            <div class="col-sm-10">
                <input name="username" type="text" id="username" class="form-control">
            </div>

        </div>

        <div class="form-group">
            <label for="password" class="control-label col-sm-2">password:</label>
            <div class="col-sm-10">
                <input name="password" type="password" id="password" class="form-control">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default center_block">Submit</button>
            </div>
        </div>
    </form>
</div>

<script src="../resource/js/jquery.js"/>
<script src="../resource/js/bootstrap.js"/>
</body>
</html>

<%--<html>--%>
<%--<head>--%>
<%--<title>login</title>--%>
<%--<style>--%>
<%--#loginForm {--%>
<%--border: 1px solid #000000;--%>
<%--padding: 15px;--%>
<%--text-align: center;--%>
<%--display: inline-block;--%>
<%--position: relative;--%>
<%--left: 50%;--%>
<%--top:40%;--%>
<%--transform: translateX(-50%) translateY(-50%);--%>
<%--}--%>

<%--input {--%>
<%--margin-top: 20px;--%>
<%--}--%>
<%--</style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<form id="loginForm" name="loginForm" action="/loginAction" method="post">--%>
<%--<c:if test="${errorMsg != null}">--%>
<%--<div style="color: red"><c:out value="${errorMsg}"/></div>--%>
<%--</c:if>--%>
<%--<label for="username">username:--%>
<%--<input name="username" type="text" id="username">--%>
<%--</label>--%>
<%--<br>--%>
<%--<label for="password">password:--%>
<%--<input name="password" type="password" id="password">--%>
<%--</label>--%>
<%--<br>--%>
<%--<input type="submit" value="admit">--%>
<%--</form>--%>

<%--</body>--%>
<%--</html>--%>
