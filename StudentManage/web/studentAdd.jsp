<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 19833
  Date: 2022/5/6
  Time: 19:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生新增页</title>
</head>
<body>
<%
    ArrayList<HashMap<String,Object>> subjects = (ArrayList<HashMap<String,Object>>)session.getAttribute("subjects");

    StringBuilder str = new StringBuilder();
    if(subjects != null){
        for(HashMap<String,Object> subject:subjects){
            str.append(
                    "<option value='"+subject.get("subject_id")+"'>"+subject.get("subject_name")+"</option>"
            );
        }
    }
%>
<form action="studentAdd" method="post">
    姓名:<input type="text" name="name"><br>
    性别:
    <select name="gender">
        <option value='0'>请选择性别</option>
        <option value='男'>男</option>
        <option value='女'>女</option>
    </select><br>
    课程:
    <select name="subjectId">
        <option value='0'>请选择课程</option>
        <%=str%>
    </select><br>
    <input type="submit" value="新增">&nbsp;&nbsp;<a href="studentList.jsp">返回学生列表</a>
</form>
</body>
</html>
