<%@ page import="logic.ValidateService" %>
<%@ page import="persistent.DbStore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:set var="id" value = "${UserServlet.work.logic.findById(i).id}" />
<c:set var="name" value = "${UserServlet.work.logic.findById(i).name}" />
<c:set var="login" value = "${UserServlet.work.logic.findById(i).login}" />
<c:set var="email" value = "${UserServlet.work.logic.findById(i).email}" />
<FORM method="POST">
       <p>${name}:  <input type="text" name="user"></p>
       <p>${login}:  <input type="text" name="login"></p>
       <p>${email}:  <input type="text" name="mail"></p>
   <p><input type="submit" name = "subUpdate" value="UPDATE" style="float: left;"></p>
</FORM>
<FORM action="/">
    <p><input type="submit" name = "back" value="BACK" style="float: left;"></p>
</FORM>
</body>
</html>
