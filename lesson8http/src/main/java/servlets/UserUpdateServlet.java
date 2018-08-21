package servlets;

import logic.ValidateService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * This servlet allow to update data.
 */
public class UserUpdateServlet extends HttpServlet {
    private final static ValidateService work = UserServlet.getWork();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer =new PrintWriter(resp.getOutputStream());
        writer.append("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<body>\n");

        writer.append(
                "<FORM method=\"POST\">" +
                        "   <p>"+work.getLogic().findById(String.valueOf(work.getID())).getName()+":  <input type=\"text\" name=\"user\"></p>\n" +
                        "   <p>"+work.getLogic().findById(String.valueOf(work.getID())).getLogin()+":  <input type=\"text\" name=\"login\"></p>\n" +
                        "   <p>"+work.getLogic().findById(String.valueOf(work.getID())).getEmail()+":  <input type=\"text\" name=\"mail\"></p>\n" +
                        "   <p><input type=\"submit\" value=\"UPDATE\" style=\"float: left;\"></p>\n" +
                        "</FORM>" +
                        "<FORM action=\"/item1/servlet\">" +
                        "   <p><input type=\"submit\" value=\"BACK\" style=\"float: left;\"></p>\n" +
                        "</FORM>" +
                        "</body>\n" +
                        "</html>"
        );
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
        work.getLogic().update(String.valueOf(work.getID()),req.getParameter("user"),req.getParameter("login"),req.getParameter("mail"));
    }
}
