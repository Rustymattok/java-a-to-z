<%@ page import="logic.ValidateService" %>
<%@ page import="persistent.DbStore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private final static ValidateService work = ValidateService.getInstance(DbStore.getInstance());
%>
<html>
<head>
    <title>Title</title>
</head>
<% if(request.getParameter("sub1") != null){
    work.setID(Integer.valueOf(request.getParameter("ID1")));
}
%>
<body>
<FORM method="POST">
    <p><%=work.getLogic().findById(String.valueOf(work.getID())).getName()%>:  <input type="text" name="user"></p>
    <p><%=work.getLogic().findById(String.valueOf(work.getID())).getLogin()%>:  <input type="text" name="login"></p>
    <p><%=work.getLogic().findById(String.valueOf(work.getID())).getEmail()%>:  <input type="text" name="mail"></p>
    <p><input type="submit" name = "subUpdate" value="UPDATE" style="float: left;"></p>
</FORM>
<FORM action="/">
    <p><input type="submit" name = "back" value="BACK" style="float: left;"></p>
</FORM>
</body>
</html>