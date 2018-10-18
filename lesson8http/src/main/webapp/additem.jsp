<%@ page import="logic.ValidateService" %>
<%@ page import="logic.User" %>
<%@ page import="persistent.DbStore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private final static ValidateService work = ValidateService.getInstance(DbStore.getInstance());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<FORM method="POST">
    <p>Name: <input type="text" name="user"></p>
    <p>Login:<input type="text" name="login"></p>
    <p>Mail: <input type="text" name="mail"></p>
    <p><input type="submit" value="ADD" style="float: left;"></p>
</FORM>
<%  if(request.getParameter("user")!=null || request.getParameter("login") != null || request.getParameter("mail")!= null) {
    work.getLogic().add(new User(request.getParameter("user"), request.getParameter("login"), request.getParameter("mail")));
}%>
<FORM action="index.jsp">
   <p><input type="submit" value="BACK" style="float: left;"></p>
</FORM>
</body>
</html>
