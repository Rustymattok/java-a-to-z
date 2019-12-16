package servlet;
import com.fasterxml.jackson.databind.ObjectMapper;
import logic.ValidateService;
import models.Topic;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.GregorianCalendar;
/**
 * This servlet for work with appToDo list.
 */
public class ToDoServlet extends HttpServlet {
    private final static ValidateService work = ValidateService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json");
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(work.getLogic().getData());
        resp.getWriter().write(jsonString);
        resp.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String topic = null;
        BufferedReader reader = req.getReader();
        String jsonLine = reader.readLine();
        String decodeRespJson = URLDecoder.decode(jsonLine, "UTF-8" );
        decodeRespJson = decodeRespJson.replace("result=","");
        System.out.println(decodeRespJson);
        ObjectMapper mapper = new ObjectMapper();
        Topic taskChoosed = mapper.readValue(decodeRespJson, Topic.class);
        if(decodeRespJson.contains("status") && decodeRespJson.contains("id")){
            boolean st = taskChoosed.isStatus();
            Topic updatedTask = new Topic();
            updatedTask.setTask(taskChoosed.getTask());
            updatedTask.setExpired(new GregorianCalendar());
            updatedTask.setStatus(st);
            work.getLogic().update(taskChoosed.getId(),updatedTask);
        }else if(decodeRespJson.contains("task")) {
            topic = taskChoosed.getTask();
            Topic newTask = new Topic();
            newTask.setExpired(new GregorianCalendar());
            newTask.setTask(topic);
            newTask.setExpired(new GregorianCalendar());
            work.getLogic().add(newTask);
        }else if(decodeRespJson.contains("id")){
            Integer id = taskChoosed.getId();
            work.getLogic().remove(id);
        }
        doGet(req,resp);
    }
}
