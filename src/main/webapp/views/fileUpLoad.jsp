<%--
  Created by IntelliJ IDEA.
  User: vurtne
  Date: 2018/4/17
  Time: 下午5:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>excelUpLoad</title>
</head>
<body>
    <form action="/excelUpLoad" method="post" enctype="multipart/form-data">
        <input type="file" name="file">

        <input type="submit">上传</form>
    </form>
</body>
</html>
