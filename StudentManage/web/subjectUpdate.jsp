<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 19833
  Date: 2022/5/6
  Time: 18:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程修改页</title>
</head>
<body>

<%
    HashMap<String,Object> subject = (HashMap<String,Object>)session.getAttribute("subject");
%>

<form action="subjectUpdate" method="post">
     <input type="hidden" name="subject_id" value="<%=subject.get("subject_id")%>">
     名称:<input type="text" name="subject_name" value="<%=subject.get("subject_name")%>"><br>
     学分:<input type="text" name="subject_credit" value="<%=subject.get("subject_credit")%>"><br>
    <input type="submit" value="修改">&nbsp;&nbsp;<a href="subjectList.jsp">返回课程列表</a>
</form>
</body>
</html>
