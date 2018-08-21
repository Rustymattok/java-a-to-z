package servlets;

import logic.User;
import logic.ValidateService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Servlet for creation form. This servlet allow to add data to database.
 */
public class UserCreatServlet extends HttpServlet {
    /**
     * @param - logic for data. THe same as for main servlet.
     */
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
                     "   <p>Name: <input type=\"text\" name=\"user\"></p>\n" +
                     "   <p>Login:<input type=\"text\" name=\"login\"></p>\n" +
                     "   <p>Mail: <input type=\"text\" name=\"mail\"></p>\n" +
                     "   <p><input type=\"submit\" value=\"ADD\" style=\"float: left;\"></p>\n" +
                 "</FORM>" +
                 "<FORM action=\"/item1/servlet\">" +
                     "   <p><input type=\"submit\" value=\"BACK\" style=\"float: left;\"></p>\n" +
                 "</FORM>" +
                        "</body>\n" +
                        "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        doGet(req,resp);
        work.getLogic().add(new User(req.getParameter("user"),req.getParameter("login"),req.getParameter("mail")));
    }
}
