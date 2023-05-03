<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 47358
  Date: 2023/3/27
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>

    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>课程信息管理系统</title>
<link rel="stylesheet" href="./css/cours.css">
</head>
<body>

<h1>课程信息管理系统</h1>
<div class="box">
<div class="user">
    ${user.username},欢迎您
</div>
<div class="u1">
    <a href="index.jsp">退出</a>

</div>
</div>
<div class="form1">

<%--<input type="button" value="新增" id="add"><br>--%>


<table  class="cours">
  <tr>
    <th>序号</th>
      <th> 封面图片</th>
    <th>课程名称</th>
    <th>课时</th>
    <th>开课学院编号</th>
  </tr>
  <c:forEach items="${courses}" var="course" varStatus="status">
  <tr align="cente" class="infom">
      <%--<td>${course.id}</td>--%>
        <td>${status.count}</td>
          <td style="text-align: center"><img width="100px" height="50px" src="imgs/${course.imagurl}"/></td>
        <td>${course.name}</td>
        <td>${course.hours}</td>
        <td>${course.sid}</td>
        <td><a href="/demo1/selectByIdServlet01?id=${course.id}">修改</a>
            <a href="/demo1/delectByIdServlet01?id=${course.id}" onclick="javascript:return del()">删除</a>
        </td>
  </tr>
  </c:forEach>

</table>
</div>
<div class="add">
<h3>添加课程</h3>
<form action="/demo1/addServlet01" method="post" class="form2" enctype="multipart/form-data">
    课程名称：<input name="name">
    <span id="username_err" class="err_msg" >${addCourse_msg}</span>
    课程时长：<input name="hours">
    学院编号：<input name="sid">
    <tr height="40px">
        <td>封面图片：</td>
        <td><input type="file" name="picture" id="picture"></td>
    </tr>
    <input type="submit" value="提交">
</form>
</div>
<script language=javascript>
    function del(){
        var msg="是否删除？\n\n请确认";
        if(confirm(msg)==true)
            return true;
        else {return false;}

    }
</script>

</body>
</html>
