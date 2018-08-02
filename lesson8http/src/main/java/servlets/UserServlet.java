package servlets;

import logic.Validate;
import logic.ValidateService;
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

    private Validate work  = new Validate(ValidateService.getInstance());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer =new PrintWriter(resp.getOutputStream());
        writer.append("Hello World ");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        work.chooseOperation(req);
        doGet(req,resp);
    }

}
