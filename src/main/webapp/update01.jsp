<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>修改课程信息</title>
    <link rel="stylesheet" href="./css/update.css">
</head>
<body>
<h1>修改课程信息</h1>
<form action="/demo1/updateServlet01" method="post" class="fix" enctype="multipart/form-data">

    <%--隐藏域，提交id--%>
    <input type="hidden" name="id" value="${course.id}">

    课程名称：<input name="name" value="${course.name}">
        <span id="username_err" class="err_msg" >${updata_msg}</span><br>
    课程时长：<input name="hours" value="${course.hours}"><br>
    学院编号：<input name="sid" value="${course.sid}"><br>
        <tr height="40px">
            <td>封面图片：</td>
            <td><input type="file" name="picture" id="picture"></td>
        </tr>

    <input type="submit" value="提交">
</form>
</body>
</html>