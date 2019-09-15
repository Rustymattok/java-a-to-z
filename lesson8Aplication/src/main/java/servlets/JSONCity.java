package servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import logic.User;
import logic.ValidateService;
import persistent.DbLocationStore;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * This servlet responsible for List of city. Form JSON with list of cities.
 */
public class JSONCity extends HttpServlet {
    public final static ValidateService work = ValidateService.getInstance(DbLocationStore.getInstance());
    private ConcurrentHashMap<String,String[]> list = new ConcurrentHashMap<String, String[]>();

    public JSONCity() {
        init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
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
        String name = parsText(jsonLine,"name");
        String login = parsText(jsonLine,"login");
        String email = parsText(jsonLine,"email");
        //Костыль
        email = email.replace("%40","@");
        String role = parsText(jsonLine,"role");
        String country = parsText(jsonLine,"country");
        String index = parsText(jsonLine,"city");
        String  city = list.get(country)[Integer.valueOf(index)];
        work.getLogic().add(new User(name,login,email,role,country,city));
        doGet(req,resp);
    }

    public void init(){
        if(list != null){
            list.clear();
        }
        String[] Rcity = {"Moscow","Mitishi","Omsk","Korolev","Posad"};
        list.put("Russia",Rcity);
        String[] Ecity = {"London","Glasgou","Elm"};
        list.put("England",Ecity);
        String[] Gcity = {"Berlin","Ulm","Koln"};
        list.put("Germany",Gcity);
    }
    public String parsText(String text, String keyword) {
        Pattern p = Pattern.compile(keyword + "=([^\\s]+)"); // the regex to be found
        Matcher m = p.matcher(text);
        String result = "";
        if (m.find()) { // if found
            if (keyword.equals("id")) {
                result = m.group().replace(keyword + "=", "");
                String[] test1 = result.split("&", result.length() - 1);
                result = test1[0];
            } else if (keyword.equals("name")) {
                result = m.group().replace(keyword + "=", "");
                String[] test1 = result.split("&", result.length() - 1);
                result = test1[0];
            }else if (keyword.equals("login")) {
                result = m.group().replace(keyword + "=", "");
                String[] test1 = result.split("&", result.length() - 1);
                result = test1[0];
            }else if (keyword.equals("email")) {
                result = m.group().replace(keyword + "=", "");
                String[] test1 = result.split("&", result.length() - 1);
                result = test1[0];
            }else if (keyword.equals("role")) {
                result = m.group().replace(keyword + "=", "");
                String[] test1 = result.split("&", result.length() - 1);
                result = test1[0];
            }else if (keyword.equals("country")) {
                result = m.group().replace(keyword + "=", "");
                String[] test1 = result.split("&", result.length() - 1);
                result = test1[0];
            }else if (keyword.equals("city")) {
                result = m.group().replace(keyword + "=", "");
                String[] test1 = result.split("&", result.length() - 1);
                result = test1[0];
            }
        }
        return result;
    }
}
