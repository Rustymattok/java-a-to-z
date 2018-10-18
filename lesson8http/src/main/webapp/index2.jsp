<%@ page import="logic.ValidateService" %>
<%@ page import="persistent.DbStore" %><%--
  Created by IntelliJ IDEA.
  User: Rustymattok
  Date: 18.10.2018
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private final static ValidateService work = ValidateService.getInstance(DbStore.getInstance());
    private  int i ;
    // private final static ValidateService work = ValidateService.getInstance(DbStore.getInstance());
%>
<html>
<head>
    <title>Title</title>

</head>
<body>
<td><%= work.getLogic().findById("5").getId()%> </td>
<td><%= work.getLogic().findById("5").getName()%></td>
<td><%= work.getLogic().findById("5").getLogin()%></td>
<td><%= work.getLogic().findById("5").getEmail()%> </td>
</body>
</html>
