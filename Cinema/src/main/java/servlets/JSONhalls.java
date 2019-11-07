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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Servlet responsible for HALLS data.
 */
public class JSONhalls extends HttpServlet {
    public final static ValidateService work = ValidateService.getInstance(DbStorePostgres.getINSTANCE());

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
    /**
     * Method for parsing element from main page(chose halls).
     * @param text - list of format js halls.
     * @return - ArrayList of ID halls which were chose.
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
