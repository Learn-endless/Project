<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: 19833
  Date: 2022/5/6
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生修改页</title>
</head>
<body>
<%
    HashMap<String,Object> student = (HashMap<String,Object>)session.getAttribute("student");

    ArrayList<HashMap<String,Object>> subjects = (ArrayList<HashMap<String,Object>>)session.getAttribute("subjects");
    StringBuilder str = new StringBuilder();
    if(subjects != null){
        for(HashMap<String,Object> subject:subjects){
            if(subject.get("subject_id").toString().equals(student.get("student_subject").toString())){
                str.append("<option value='"+subject.get("subject_id")+"' selected>"+subject.get("subject_name")+"</option>");
            }else{
                str.append("<option value='"+subject.get("subject_id")+"'>"+subject.get("subject_name")+"</option>");
            }
        }
    }
%>
<form action="studentUpdate" method="post">
    <input type="hidden" name="id" value="<%=student.get("student_id")%>">
    姓名:<input type="text" name="name" value="<%=student.get("student_name")%>"><br>
    性别:
    <select name="gender">
        <option value='0'>请选择性别</option>
        <option value='男' <%=student.get("student_gender").equals("男")?"selected":""%>>男</option>
        <option value='女' <%=student.get("student_gender").equals("女")?"selected":""%>>女</option>
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
