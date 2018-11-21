<%--
  Created by IntelliJ IDEA.
  User: shenruofan
  Date: 11/7/18
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file upload test</title>
</head>
<body>
    <h1>File Upload Page</h1>
    <form method = "post" action = "/fileUpload.do" enctype = "multipart/form-data">

        <input type = "file" name = "file" /><br>

        <input type = "submit" value = "开始上传"/>

    </form>
</body>
</html>
