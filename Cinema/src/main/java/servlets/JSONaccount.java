package servlets;
import com.fasterxml.jackson.databind.ObjectMapper;
import logic.Halls;
import logic.ValidateService;
import persistent.DbStorePostgres;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Servlet responsible for formed list of hall's id.
 */
public class JSONaccount extends HttpServlet {
    public final static ValidateService work = ValidateService.getInstance(DbStorePostgres.getINSTANCE());
    private ConcurrentHashMap<Integer,Halls> list = new ConcurrentHashMap<Integer,Halls>();
    /**
     * By get parameter json of id halls.
     * @param req - request.
     * @param resp - resposible.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(list);
        resp.getWriter().write(jsonString);
        resp.getWriter().flush();
    }
    /**
     * By post info from choosed halls in index.html
     * @param req -request.
     * @param resp - resposoble.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        list.clear();
        BufferedReader reader = req.getReader();
        String jsonLine = reader.readLine();
        ArrayList<Integer> listID = new ArrayList<Integer>();
        listID = parsText(jsonLine);
        for (int i = 0; i < listID.size() ; i++) {
            Halls halls = work.getLogic().selectByIDHalls(listID.get(i));
            list.put(listID.get(i),halls);
        }
        doGet(req,resp);
    }
    /**
     *This method returned list if halls which were choosed.
     * @param text - json text from index panel.
     * @return list - of choosed parameter by id.
     */
    public ArrayList parsText(String text){
        Pattern p = Pattern.compile("=([^\\s]+)"); // the regex to be found
        Matcher m = p.matcher(text);
        ArrayList<Integer> listTxt = new ArrayList<Integer>();
        String result = "";
        if (m.find()) { // if found
            result = m.group().replace("&list%5B%5D", "");
            String[] test1 = result.split("=");
            for (int i = 1; i < test1.length; i++) {
                listTxt.add(Integer.valueOf(test1[i]));
            }
        }
        return listTxt;
    }
}
