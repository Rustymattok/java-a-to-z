package servlets;
import com.fasterxml.jackson.databind.ObjectMapper;
import logic.User;
import logic.ValidateService;
import persistent.DbStorePostgres;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
/**
 * This servlet responsoble for work with Database. Input - data from order.html.
 */
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
        String orderData = URLDecoder.decode( jsonLine, "UTF-8" );
        orderData = orderData.replace("result=","");
        ObjectMapper mapper = new ObjectMapper();
        User customer = mapper.readValue(orderData, User.class);
        String name = customer.getName();
        String phone = customer.getPhone();
        ArrayList<Integer> idList = customer.getList();
        for (int i = 0; i < idList.size(); i++) {
            work.getLogic().addUser(new User(name,phone),idList);
        }
        doGet(req,resp);
    }
}
