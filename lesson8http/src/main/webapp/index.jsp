<%@ page import="logic.ValidateService" %>
<%@ page import="persistent.DbStore" %>
<%--
  This is the page to work with DataBase.
  It's main page . And during evry update parser in logic update all page.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private final static ValidateService work = ValidateService.getInstance(DbStore.getInstance());
    private  int i;
%>
<html>
<head>
    <title>Добро пожаловать, JSP!</title>
</head>
<% if(request.getParameter("sub")!= null) {
    work.getLogic().delete(request.getParameter("ID"));
}
%>
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

    <%
        DbStore dbStoreNew = new DbStore();
        for( i = 0; i < work.getLogic().size(); i++) {
        String id = dbStoreNew.IndicateID(i);
    %>
    <tr>
        <td><%= work.getLogic().findById(id).getId()%> </td>
        <td><%= work.getLogic().findById(id).getName()%></td>
        <td><%= work.getLogic().findById(id).getLogin()%></td>
        <td><%= work.getLogic().findById(id).getEmail()%> </td>
        <td>
            <form method = "POST"  action="updateitem.jsp">
                <input type="submit" name="sub1" value="update" id="submitB"/>
                <input type="hidden" name="ID1" value=<%=id%>>
            </form>
        </td>
        <td>
            <form method="POST" action="index.jsp" style="float:left;" >
                <input type="submit" name="sub" value="delete" id="submitB1"/>
                <input type="hidden" name="ID" value=<%=work.getLogic().findById(id).getId()%>>
            </form>
        </td>
    </tr>
    <%} %>
</table>
<form action="additem.jsp" style="float:left;">
    <input type="submit" value="Add"id="submitB2"></form>
</body>
</html>
