<%@ page import="servlets.UserServlet" %>
<%--
  This is the page to work with DataBase.
  It's main page . And during evry update parser in logic update all page.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Добро пожаловать, JSP!</title>
</head>
<body>
<table>
    <colgroup>
        <col span="4" style="background:Khaki">
        <col style="background-color:LightCyan">
    </colgroup>
    <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>LOGIN</th>
        <th>MAIL</th>
    </tr>
<c:forEach var = "i" begin = "0" end = "${size}">
    <c:set var="id" value = "${UserServlet.work.logic.findById(i).id}" />
    <c:set var="name" value = "${UserServlet.work.logic.findById(i).name}" />
    <c:set var="login" value = "${UserServlet.work.logic.findById(i).login}" />
    <c:set var="email" value = "${UserServlet.work.logic.findById(i).email}" />
    <tr>
        <td>${id} </td>
        <td>${name}</td>
        <td>${login}</td>
        <td>${email} </td>
        <td>
            <form method = "POST"  action="/">
                <input type="submit" name="sub1" value="update" id="submitB"/>
                <input type="hidden" name="ID1" value="${i}">
            </form>
        </td>
        <td>
            <form method="POST" action="/" style="float:left;" >
                <input type="submit" name="sub" value="delete" id="submitB1"/>
                <input type="hidden" name="ID" value="${id}">
            </form>
        </td>
    </tr>
</c:forEach>
</table>
<form method = "POST" action="/" style="float:left;">
    <input type="submit" name="subAdd" value="Add" id="submitB2"></form>
</body>
</html>
