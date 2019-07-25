package servlets;
import com.fasterxml.jackson.databind.ObjectMapper;
import logic.Item;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Servlet responsoble for forming json.
 */
public class JSONControllers extends HttpServlet {
    private PrintWriter writer;
    private ConcurrentHashMap<UUID,Item> list = new ConcurrentHashMap<UUID, Item>();

    public JSONControllers() {
        list.put(generateID(),new Item("Vladimir1","Makarov1","info1"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        writer = new PrintWriter(resp.getOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(list);
        writer.append(jsonString);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstname");
        String lastname =  req.getParameter("secondname");
        String info = req.getParameter("info");
        list.put(generateID(),new Item(firstname,lastname,info));
    }
    public UUID generateID(){
        UUID uniqueKey = UUID.randomUUID();
        return uniqueKey;
    }
}
