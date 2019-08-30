package servlets;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import logic.User;
import org.junit.Test;
import persistent.DbLocationStore;
import java.io.*;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import logic.ValidateService;
import org.powermock.modules.junit4.PowerMockRunner;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.*;
/**
 * Test for servlet JSONControllers.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateService.class)
public class JSONControllersTest {

    private ConcurrentHashMap<UUID, User> list = new ConcurrentHashMap<UUID, User>();
    /**
     * This is for test lust which taken from DB.
     */
    @Test
    public void whenShouldCheckJsonText(){
        DbLocationStore db = DbLocationStore.getInstance();
        for (int i = 0; i < db.size(); i++) {
            list.put(generateID(),db.findById(String.valueOf(i)));
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            String jsonString = mapper.writeValueAsString(list);
            //todo we can compare with file test.txt if needed it.
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    public UUID generateID() {
        UUID uniqueKey = UUID.randomUUID();
        return uniqueKey;
    }
    /**
     * This method for test servlet. All data move to file test.txt.
     * This file we can check for correct creating data json.
     * @throws ServletException
     * @throws IOException
     */
    @Test
    public void whenShouldCheckJsonSrevlet() throws ServletException, IOException {
        String fileWay = "D:\\CODE_WORK\\JAVA\\java-a-to-z\\lesson8Aplication\\src\\main\\java\\persistent\\test.txt";
        final JSONControllers servlet = new JSONControllers();
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        PrintWriter writer = new PrintWriter(new FileWriter(fileWay));
        BufferedReader reader = new BufferedReader(new FileReader(fileWay));
        when(resp.getWriter()).thenReturn(writer);
        when(req.getReader()).thenReturn(reader);
        servlet.doGet(req,resp);
        servlet.doPost(req,resp);
    }
}