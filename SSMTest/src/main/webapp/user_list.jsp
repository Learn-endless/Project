<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/17
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${ulist}" var="user">
        <table>
            <tr>
                <td >${user.tid}</td>
                <td >${user.tname}</td>
                <td >${user.password}</td>
            </tr>
        </table>

    </c:forEach>
</body>
</html>
