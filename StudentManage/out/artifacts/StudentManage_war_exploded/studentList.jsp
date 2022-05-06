<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 19833
  Date: 2022/5/6
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
</head>
<body>
<%
    ArrayList<HashMap<String,Object>> students = (ArrayList<HashMap<String,Object>>) session.getAttribute("students");
    StringBuilder str = new StringBuilder();
    if(students != null){
        for(HashMap<String,Object> student : students){
            str.append(
                    "<tr>"+
                        "<th>"+student.get("student_id")+"</th>"+
                        "<th>"+student.get("student_name")+"</th>"+
                        "<th>"+student.get("student_gender")+"</th>"+
                        "<th>"+student.get("subject_name")+"</th>"+
                        "<th><a href='toStudentModify?id="+student.get("student_id")+"'>修改</a>&nbsp;&nbsp;&nbsp;<a href='studentDelete?id="+student.get("student_id")+"'>删除</a></th>"+
                    "</tr>"
            );
        }
    }
%>
<a href="index.html">首页</a>&nbsp;&nbsp;&nbsp;<a href="studentAdd.jsp">新增学生</a><br>
<table style="width: 100%" text-align="center">
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>课程</th>
        <th>操作</th>
    </tr>
    <%=str%>
</table>
</body>
</html>
