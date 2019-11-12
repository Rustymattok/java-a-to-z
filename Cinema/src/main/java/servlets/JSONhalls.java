package servlets;
import com.fasterxml.jackson.databind.ObjectMapper;
import logic.Halls;
import logic.ValidateService;
import persistent.DbStorePostgres;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
/**
 * Servlet responsible for HALLS data.
 */
public class JSONhalls extends HttpServlet {
//    public final static ValidateService work = ValidateService.getINSTANCE(DbStorePostgres.getINSTANCE());
private final static ValidateService work = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(getData());
        resp.getWriter().write(jsonString);
        resp.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
    /**
     * Method for collect all halls in data.
     */
    public HashMap<Integer, Halls> getData(){
        int i = 1;
        HashMap<Integer, Halls> list = new HashMap<Integer, Halls>();
        while (i<=work.getLogic().sizeData()){
            list.put(i,work.getLogic().selectByIDHalls(i));
            i++;
        }
        return list;
    }
}
