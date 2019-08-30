<%@ page import="servlets.UserServlet" %>
<%@ page import="servlets.UserControler" %>
<%@ page import="javax.servlet.http.HttpServlet" %>
<%--
  This is the page to work with DataBase.
  It's main page . And during evry update parser in logic update all page.
--%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Добро пожаловать, JSP"!</title>
</head>
<body>
<c:set var="NameLog" value = "${UserControler.session.getAttribute('login1')}" />
<c:set var="RoleLog" value = "${UserControler.session.getAttribute('loginrole')}" />
<b>Hello ${NameLog}</b>
<b>You entered as ${RoleLog}</b>
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
    <c:set var="role" value = "${UserServlet.work.logic.findById(i).role}" />
    <c:set var="listRole" value = "${UserServlet.work.logic.findById(i).roles}" />
    <tr>
        <td>${id} </td>
        <td>${name}</td>
        <td>${login}</td>
        <td>${email} </td>
        <c:if test ="${RoleLog == 'ADMINISTRATOR' or RoleLog == 'USER'}">
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
        </c:if>
        <c:if test ="${RoleLog == 'ADMINISTRATOR'}">
        <td>
            <form method="POST" action="/">
                <select name="Itemrole">
                    <c:forEach items="${listRole}" var="c">
                        <option name = "IDRole"  <c:if test ="${c eq role}">selected="selected"</c:if> value="${c}">${c}</option>
                    </c:forEach>
                </select>
                <input type="submit" name="submitRole" value="choose role" id="submitRole">
                <input type="hidden" name="ItemroleID" value="${id}">
            </form>
        </td>
        </c:if>
    </tr>
</c:forEach>
</table>
<form method = "POST" action="/" style="float:left;">
    <input type="submit" name="subAdd" value="Add" id="submitB2"style="float: left;"></form>
</body>
<FORM method="POST" action="/">
    <input type="submit" name = "logout" value="LOGOUT" style="float: left;">
</FORM>
<%--<FORM method="POST" action="/">--%>
    <%--<input type="submit" name = "index1" value="index1" style="float: left;">--%>
<%--</FORM>--%>
</html>
