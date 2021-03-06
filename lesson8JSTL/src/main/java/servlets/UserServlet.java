package servlets;
import logic.User;
import logic.ValidateService;
import persistent.DbStore;
import persistent.Store;

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
     public final static ValidateService work = ValidateService.getInstance(DbStore.getInstance());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                req.setAttribute("size",work.getLogic().size()-1);
                req.getRequestDispatcher("/WEB-INF/viewa/TestJstl.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        /*
         * This condition - if on main page smb switch on 'Delete'buttom. We only update page after removing element.
         */
        if(req.getParameter("sub")!= null) {
            work.getLogic().delete(req.getParameter("ID"));
            doGet(req,resp);
        }
        /*
         * This condition - if on main page smb switch on 'Update' buttom. We link to the update page.
         */
        if(req.getParameter("sub1")!=null){
            work.setID(Integer.valueOf(req.getParameter("ID1")));
            req.setAttribute("size",work.getID());
            req.getRequestDispatcher("/WEB-INF/viewa/updateitem.jsp").forward(req,  resp);
            return;
        }
        /*
         * This condition - if on update page smb switch on 'Update' buttom. We link to the main page(before it calculate new parameters).
         */
        if( req.getParameter("subUpdate") != null){
            work.getLogic().update(work.getLogic().findById(String.valueOf(work.getID())).getId(),req.getParameter("user"), req.getParameter("login"), req.getParameter("mail"));
            doGet(req,resp);
        }
        /*
         * This condition - if on main page smb switch on 'Add' buttom. We link to the Add page.
         */
        if (req.getParameter("subAdd") != null){
            req.getRequestDispatcher("/WEB-INF/viewa/additem.jsp").forward(req,resp);
            return;
        }
        /*
         * This condition - if on Add page smb switch on 'Add' buttom. We link to the main page(before it calculate new parameters).
         */
        if(req.getParameter("submitAdd") != null){
            if(req.getParameter("user")!=null || req.getParameter("login") != null || req.getParameter("mail")!= null) {
                work.getLogic().add(new User(req.getParameter("user"), req.getParameter("login"), req.getParameter("mail")));
            }
            doGet(req,resp);
        }
        /*
         * This condition - if on push buttom logout. We go to login page and clean all session).
         */
        if (req.getParameter("logout") != null){
            req.getSession().invalidate();
            req.getRequestDispatcher("/WEB-INF/viewa/login.jsp").forward(req,resp);
            return;
        }
        /*
         * This condition - if choose button to choose role It start activities to update roles.
         */
        if(req.getParameter("submitRole") != null){
            work.getLogic().updateRole(req.getParameter("ItemroleID"),req.getParameter("Itemrole"));
        }
        if(req.getParameter("index1") != null){
            req.getRequestDispatcher("/WEB-INF/viewa/index.html").forward(req,resp);
            return;
        }
        doGet(req,resp);
    }

    public static ValidateService getWork() {
        return work;
    }

}

