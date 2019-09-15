package servlets;
import logic.ValidateService;
import persistent.DbLocationStore;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/**
 * Main Servlet for work.
 */
public class UserServlet extends HttpServlet {
    /**
     * @param work - describe logic and database. Not active now.
     */
     public final static ValidateService work = ValidateService.getInstance(DbLocationStore.getInstance());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                req.getRequestDispatcher("Update.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

         doGet(req,resp);
    }

    public static ValidateService getWork() {
        return work;
    }

}

