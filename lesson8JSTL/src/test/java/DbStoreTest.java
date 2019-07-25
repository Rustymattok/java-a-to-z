import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import logic.Item;
import logic.User;
import logic.ValidateService;
import org.junit.Test;
import persistent.DbStore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DbStoreTest {
    private final static ValidateService work = ValidateService.getInstance(DbStore.getInstance());

    @Test
    public void add() {
        DbStore db = DbStore.getInstance();
        db.add(new User("fff","sss","kkk"));
    }

    @Test
    public void position() {
        DbStore db = DbStore.getInstance();
        System.out.println(db.position());
    }

    @Test
    public void findById(){
        DbStore dbStore =  DbStore.getInstance();
        System.out.println(dbStore.findById("52").getName());
    }

    @Test
    public void deleteTest(){
        DbStore dbStore =  DbStore.getInstance();
        dbStore.delete("7");
    }

    /**
     * for checking method
     */
    @Test
    public void testString() throws IOException {
        Item item = new Item();
        item.setFirstname("Vladimir");
        item.setLastname("Makarov");
        item.setInfoU("information");
        ObjectMapper mapper = new ObjectMapper();
        String jsonString = mapper.writeValueAsString(item);
        String dataFnew = "[{\"firstname\": \"text1\",\"lastname\": \"text2\",\"infoU\": \"text3\"},{\"firstname\": \"text4\",\"lastname\": \"text5\",\"infoU\": \"text6\"}]";
        System.out.println(jsonString);
        System.out.println(dataFnew);
        ConcurrentHashMap<Integer,Item> zero = new ConcurrentHashMap<Integer, Item>();
        zero.put(1,new Item("maksim1","maksim1","maksim1"));
        zero.put(2,new Item("maksim2","maksim2","maksim2"));
        zero.put(3,new Item("maksim3","maksim3","maksim3"));
        String testJson = mapper.writeValueAsString(zero);
        System.out.println(testJson);
        Item newItem = mapper.readValue(jsonString, Item.class);
        System.out.println(newItem.getFirstname());
        List<Item> myList =new ArrayList<Item>();
        myList.add(new Item("text1","text2","text3"));
        myList.add(new Item("text1","text2","text3"));
        String newJsonN = mapper.writeValueAsString(myList);
        System.out.println(newJsonN);
        //ConcurrentHashMap<Integer,Item> list = mapper.readValue(dataFnew, new TypeReference<ConcurrentHashMap(){});
        List<Item> myObjects = mapper.readValue(dataFnew, new TypeReference<List<Item>>(){});
        for (Item myItem:myObjects) {
            System.out.println("-------new Item");
            System.out.println(myItem.getFirstname() + "  " + myItem.getLastname() + "  " + myItem.getInfoU());
        }
        String newJson = mapper.writeValueAsString(myObjects);
        System.out.println(newJson);

//        String firstname = "vova";
//        String lastname =  "makarov";
//        String info = "111";
//        String dataF = "'[{\"firstname\": \"text1\",\"lastname\": \"text2\",\"infoU\": \"text3\"},{\"firstname\": \"text4\",\"lastname\": \"text5\",\"infoU\": \"text6\"}]'";
//        System.out.println(dataF);
//        dataF = dataF.trim().substring(0,dataF.length()-2);
//        dataF = dataF + ",{\"firstname\": \"" + firstname + "\",\"lastname\": \"" + lastname + "\",\"infoU\": \"" + info + "\"}]'";
//        System.out.println(dataF);
    }
}