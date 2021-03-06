package servlets;
import com.fasterxml.jackson.databind.ObjectMapper;
import logic.*;
import persistent.DbLocationStore;
import persistent.DbStore;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class has responsoble for login options.
 */
public class UserControler extends HttpServlet{

    public static HttpSession session;
    public final static ValidateService pars = ValidateService.getInstance(DbLocationStore.getInstance());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/viewa/login.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String login = req.getParameter("login1");
         String password = req.getParameter("password1");
        if(pars.getLogic().isCredentional(login,password)){
                 session = req.getSession();
                 User user = pars.getLogic().findById(login,password);
                 session.setAttribute("loginrole",user.getRole());
                 session.setAttribute("login1",user.getLogin());
                 session.setAttribute("name1",user.getName());
                 req.getRequestDispatcher("/Items.html").forward(req,resp);
             return;
         }else {
             doGet(req,resp);
             req.setAttribute("error","This page is not correct");
         }
    }

    public static HttpSession getSession() {
        return session;
    }
}
