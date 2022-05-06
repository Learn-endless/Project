<%--
  Created by IntelliJ IDEA.
  User: 19833
  Date: 2022/5/5
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增课程</title>
</head>
<body>
<form action="subjectAdd" method="post">
    名称:<input type="text" name="subject_id"><br>
    学分:<input type="text" name="subject_credit"><br>
    <input type="submit" value="新增">&nbsp;&nbsp;<a href="subjectList.jsp">返回课程列表</a>
</form>
</body>
</html>
