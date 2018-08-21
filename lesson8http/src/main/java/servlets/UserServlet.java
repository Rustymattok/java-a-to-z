package servlets;

import logic.ValidateService;
import persistent.MemoryStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Main Servlet for work.
 */
public class UserServlet extends HttpServlet {
    /**
     * @param work - describe logic and database.
     */
    private final static ValidateService work = ValidateService.getInstance(MemoryStore.getInstance());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer =new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n" +
                " <table>\n" +
                "<colgroup>\n" +
                        "    <col span=\"4\" style=\"background:Khaki\">" +
                        "    <col style=\"background-color:LightCyan\">" +
                        " </colgroup>"+
                "<tr>" +
                "<th>ID</th>" +
                "<th>NAME</th><" +
                "th>LOGIN</th>" +
                "<th>MAIL</th>" +
                "</tr>\n");
          for (int i = 0; i < work.getLogic().size(); i++) {
            writer.append("<tr>" +
                    "<td>" + work.getLogic().findById(String.valueOf(i)).getId()+"</td>" +
                    "<td>" + work.getLogic().findById(String.valueOf(i)).getName() + "</td>" +
                    "<td>" + work.getLogic().findById(String.valueOf(i)).getLogin() + "</td>" +
                    "<td>" + work.getLogic().findById(String.valueOf(i)).getEmail() + "</td>" +
                    "<td>" +
                    "<form method = \"POST\">"+
                    "<input type=\"submit\" name=\"sub1\" value=\"update\" id=\"submitB\"/>" +
                    "<input type=\"hidden\" name=\"ID1\" value=" + i + ">"+
                    "</form>\n" +
                    "</td>"+
                    "<td>" +
                    "<form method=\"POST\" action=\"/item1/servlet\" style=\"float: left;\" >" +
                    "<input type=\"submit\" name=\"sub\" value=\"delete\" id=\"submitB1\"/>" +
                    "<input type=\"hidden\" name=\"ID\" value=" + i + ">"+
                    "</form>\n" +
                    "</td>"+
                    "</tr>\n");
        }

        writer.append(
                "</table>\n" +
                 "<form action=\"/item1/example\" style=\"float: left;\">" +
                 "<input type=\"submit\" value=\"Add\"id=\"submitB1\"></form>\n" +
                "</body>\n" +
                "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        if(req.getParameter("sub1") != null){
            work.setID(Integer.parseInt(req.getParameter("ID1")));
            resp.sendRedirect("http://localhost:8082/item1/update");
       }
        if(req.getParameter("sub")!= null){
            work.getLogic().delete(req.getParameter("ID"));
        }
        doGet(req,resp);
    }

    public static ValidateService getWork() {
        return work;
    }
}

