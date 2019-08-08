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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Servlet responsoble for forming json.
 */
public class JSONControllers extends HttpServlet {
    private ConcurrentHashMap<UUID,Item> list = new ConcurrentHashMap<UUID, Item>();

    public JSONControllers() {
        list.put(generateID(),new Item("Vladimir1","Makarov1","info1"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(list);
        writer.append(jsonString);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        BufferedReader reader = req.getReader();
        String jsonLine = reader.readLine();
        String firstname = parsText(jsonLine,"firstname");
        String secondname =   parsText(jsonLine,"secondname");
        String info =  parsText(jsonLine,"info");
        list.put(generateID(),new Item(firstname,secondname,info));
    }
    /**
     * Method  for randomize id.
     * @return id parameter.
     */
    public UUID generateID(){
        UUID uniqueKey = UUID.randomUUID();
        return uniqueKey;
    }
    /**
     * This method took line from json for parsing and get parameter.
     * @param text - json line.
     * @param keyword - word for value parameter.
     * @return String parameter.
     */
    public String parsText(String text,String keyword){
        Pattern p = Pattern.compile(keyword + "=([^\\s]+)"); // the regex to be found
        Matcher m = p.matcher(text);
        String result = "";
        if (m.find()) { // if found
            if(keyword.equals("info")){
                result = m.group().replace(keyword + "=", "");
                String[] test1=result.split("=",result.length()-1);
                result = test1[0];
            }else if(keyword.equals("firstname") || keyword.equals("secondname")){
                result = m.group().replace(keyword + "=", "");
                String[] test1=result.split("&",result.length()-1);
                result = test1[0];
            }
        }
        return result;
    }
}
