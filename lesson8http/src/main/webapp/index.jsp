<%@ page import="logic.ValidateService" %>
<%@ page import="persistent.MemoryStore" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private final static ValidateService work = ValidateService.getInstance(MemoryStore.getInstance());
%>
<html>
<head>
    <title>Добро пожаловать, JSP!</title>
</head>
<% if(request.getParameter("sub")!= null){
    work.getLogic().delete(request.getParameter("ID"));
} %>
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

         <%for(int i = 0; i < work.getLogic().size(); i++) {%>
    <tr>
        <td><%= work.getLogic().findById(String.valueOf(i)).getId()%> </td>
        <td><%= work.getLogic().findById(String.valueOf(i)).getName()%></td>
        <td><%= work.getLogic().findById(String.valueOf(i)).getLogin()%></td>
        <td><%= work.getLogic().findById(String.valueOf(i)).getEmail()%> </td>
        <td>
            <form method = "POST"  action="updateitem.jsp">
                <input type="submit" name="sub1" value="update" id="submitB"/>
                <input type="hidden" name="ID1" value=<%=i%>>
                <%work.setID(i);%>
            </form>
        </td>
        <td>
            <form method="POST" action="index.jsp" style="float:left;" >
            <input type="submit" name="sub" value="delete" id="submitB1"/>
            <input type="hidden" name="ID" value=<%=i%>>
            </form>
        </td>
        </tr>
     <%} %>
    </table>
 <form action="additem.jsp" style="float:left;">
<input type="submit" value="Add"id="submitB2"></form>
</body>
</html>
