package servlets;
import logic.Halls;
import logic.User;
import logic.ValidateService;
import persistent.DbStorePostgres;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//todo переделать на манипуляции только с ID.
public class ServletAccount extends HttpServlet {
    public final static ValidateService work = ValidateService.getInstance(DbStorePostgres.getINSTANCE());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        BufferedReader reader = req.getReader();
        String jsonLine = reader.readLine();
        String name = parseAccount(jsonLine,"name");
        String phone = parseAccount(jsonLine,"phone");
        ArrayList<Integer> idList = parsHallId(jsonLine);
        for (int i = 0; i < idList.size(); i++) {
           work.getLogic().addUser(new User(name,phone),idList);
        }
        doGet(req,resp);
    }
    /**
     * Method for take account.
     * @param text - json from order.html.
     * @param keyword -  "name" or "phone"
     * @return -  String value by key.
     */
    public String parseAccount(String text,String keyword){
        Pattern p = Pattern.compile("=([^\\s]+)"); // the regex to be found
        Matcher m = p.matcher(text);
        String result = "";
        if (m.find()) { // if found
            if (keyword.equals("name")) {
                result = m.group().replace("=","");
                String[] test1 = result.split("&", result.length());
                result = test1[0];
            } else if (keyword.equals("phone")) {
                result = m.group().replace(keyword + "=", "");
                String[] test1 = result.split("&", result.length() - 1);
                result = test1[1];
            }
        }
            return result;
    }
    /**
     * Method for the take hall parameter.
     * @param text - json from order.html
     * @return list - id of halls.
     */
    public ArrayList<Integer> parsHallId(String text){
        ArrayList<Integer> list = new ArrayList<Integer>();
        Pattern p = Pattern.compile("=([^\\s]+)"); // the regex to be found
        Matcher m = p.matcher(text);
        String result = "";
        if(m.find()){
            result = m.group().replace("list%5B%5D=", "");
            String[] test1 = result.split("&", result.length() - 1);
            for (int i = 2; i < test1.length; i++) {
                list.add(Integer.valueOf(test1[i]));
            }
        }
        return list;
    }
}
