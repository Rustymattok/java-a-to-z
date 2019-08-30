package servlets;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import logic.Item;
import org.junit.Test;

import java.io.PrintWriter;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.*;

public class JSONControllersTest {

    @Test
    public void parsText() throws JsonProcessingException {
        ConcurrentHashMap<UUID, Item> list = new ConcurrentHashMap<UUID, Item>();
        list.put(generateID(), new Item("Vladimir1", "Makarov1", "info1"));
        ObjectMapper mapper = new ObjectMapper();
        String text = mapper.writeValueAsString(list);
        System.out.println(text);
        JSONControllers jsonControllers = new JSONControllers();
        System.out.println( jsonControllers.parsText(text,"firstname"));
    }

    public UUID generateID() {
        UUID uniqueKey = UUID.randomUUID();
        return uniqueKey;
    }
}