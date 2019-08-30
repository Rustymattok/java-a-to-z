package servlets;
import logic.*;
import persistent.DbStore;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
/**
 * This class has responsoble for login options.
 */
public class UserControler extends HttpServlet{

    public static HttpSession session;
    public final static ValidateService pars = ValidateService.getInstance(DbStore.getInstance());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.getRequestDispatcher("/WEB-INF/viewa/login.jsp").forward(req,resp);
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
             req.getRequestDispatcher(String.format("%s/",req.getContextPath())).forward(req,resp);
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
