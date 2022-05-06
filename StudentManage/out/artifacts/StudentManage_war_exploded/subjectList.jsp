<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 19833
  Date: 2022/5/5
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程列表</title>
</head>
<body>
<%
    ArrayList<HashMap<String,Object>> subjects = (ArrayList<HashMap<String,Object>>)session.getAttribute("subjects");
    StringBuilder str = new StringBuilder();
    if(subjects != null){
        for(HashMap<String,Object> subject:subjects){
            str.append(
                    "<tr>"+
                            "<th>"+subject.get("subject_id")+"</th>"+
                            "<th>"+subject.get("subject_name")+"</th>"+
                            "<th>"+subject.get("subject_credit")+"</th>"+
                            "<th><a href='toModifySubject?id="+subject.get("subject_id")+"'>修改</a>&nbsp;&nbsp;&nbsp;<a href='subjectDelete?id="+subject.get("subject_id")+"'>删除</a></th>"+
                    "</tr>"
            );
        }
    }
%>
<a href="index.html">首页</a>&nbsp;&nbsp;&nbsp;<a href="subjectAdd.jsp">新增课程</a>
<table style="width: 100%" align="center">
    <tr>
        <th>编号</th>
        <th>名称</th>
        <th>学分</th>
        <th>操作</th>
    </tr>
    <%=str%>
</table>
</body>
</html>
