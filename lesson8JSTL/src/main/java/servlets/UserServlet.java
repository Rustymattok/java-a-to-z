package servlets;
import logic.User;
import logic.ValidateService;
import persistent.DbStore;
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
     * @param work - describe logic and database.
     */
    private final static ValidateService work = ValidateService.getInstance(DbStore.getInstance());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/viewa/index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        /*
         * This condition - if on main page smb switch on 'Delete'buttom. We only update page after removing element.
         */
        if(req.getParameter("sub")!= null) {
            req.getRequestDispatcher("/WEB-INF/viewa/index.jsp").forward(req, resp);
        }
        /*
         * This condition - if on main page smb switch on 'Update' buttom. We link to the update page.
         */
        if(req.getParameter("sub1")!=null){
            req.getRequestDispatcher("/WEB-INF/viewa/updateitem.jsp").forward(req,  resp);
        }
        /*
         * This condition - if on update page smb switch on 'Update' buttom. We link to the main page(before it calculate new parameters).
         */
        if( req.getParameter("subUpdate") != null){
            work.getLogic().update(work.getLogic().findById(String.valueOf(work.getID())).getId(),req.getParameter("user"), req.getParameter("login"), req.getParameter("mail"));
            req.getRequestDispatcher("/WEB-INF/viewa/index.jsp").forward(req, resp);
        }
        /*
         * This condition - if on main page smb switch on 'Add' buttom. We link to the Add page.
         */
        if (req.getParameter("subAdd") != null){
            req.getRequestDispatcher("/WEB-INF/viewa/additem.jsp").forward(req,resp);
        }
        /*
         * This condition - if on Add page smb switch on 'Add' buttom. We link to the main page(before it calculate new parameters).
         */
        if(req.getParameter("submitAdd") != null){
            if(req.getParameter("user")!=null || req.getParameter("login") != null || req.getParameter("mail")!= null) {
                work.getLogic().add(new User(req.getParameter("user"), req.getParameter("login"), req.getParameter("mail")));
            }
            req.getRequestDispatcher("/WEB-INF/viewa/index.jsp").forward(req, resp);
        }
    }
}

