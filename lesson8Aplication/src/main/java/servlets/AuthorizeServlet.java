package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import logic.User;
import logic.ValidateService;
import persistent.DbLocationStore;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
/**
 * This servlet responsible for Authorize. Form JSON with role of user to send for pages with type if role.
 */
public class AuthorizeServlet extends HttpServlet {
    public final static ValidateService work = ValidateService.getInstance(DbLocationStore.getInstance());
    private ConcurrentHashMap<String,User> list = new ConcurrentHashMap<String, User>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        User user = work.getLogic().findById(session.getAttribute("login1").toString(),session.getAttribute("name1").toString());
        list.put("roles",user);
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(list);
        resp.getWriter().write(jsonString);
        resp.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        BufferedReader reader = req.getReader();
        String jsonLine = reader.readLine();
    }
}
