package servlets;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import logic.Item;
import logic.User;
import persistent.DbLocationStore;

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
    //todo Отладить парсер для новой базы данных и обновления ее при вызывое POST().
    //todo Написать тест для данного сервлета.

    private ConcurrentHashMap<UUID, User> list = new ConcurrentHashMap<UUID, User>();

    public JSONControllers() {
        DbLocationStore db = DbLocationStore.getInstance();
        for (int i = 0; i < db.size(); i++) {
            list.put(generateID(),db.findById(String.valueOf(i)));
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
       // PrintWriter writer = new PrintWriter(resp.getOutputStream());
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(list);
        resp.getWriter().write(jsonString);
        resp.getWriter().flush();
      //  writer.append(jsonString);
       // writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        BufferedReader reader = req.getReader();
        String jsonLine = reader.readLine();
        System.out.println(jsonLine);
//        System.out.println(jsonLine);
//        String id = parsText(jsonLine, "id");
//        String name = parsText(jsonLine, "name");
//        String login = parsText(jsonLine, "login");
//        String email = parsText(jsonLine, "email");
//        String role = parsText(jsonLine, "role");
//        String country = parsText(jsonLine, "country");
//        String city = parsText(jsonLine, "city");
//        list.put(generateID(), new User(id,name,login,email,role,country,city));
    }

    /**
     * Method  for randomize id.
     *
     * @return id parameter.
     */
    public UUID generateID() {
        UUID uniqueKey = UUID.randomUUID();
        return uniqueKey;
    }
    /**
     * This method took line from json for parsing and get parameter.
     *
     * @param text    - json line.
     * @param keyword - word for value parameter.
     * @return String parameter.
     */
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

