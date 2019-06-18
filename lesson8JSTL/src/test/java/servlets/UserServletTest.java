package servlets;
import logic.User;
import logic.ValidateStub;
import org.junit.Test;
import persistent.Store;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServletTest {
    Store store = new ValidateStub();
    HttpServletRequest req = mock(HttpServletRequest.class);
    HttpServletResponse resp = mock(HttpServletResponse.class);

    public void initStore(){
        store.add(new User("root","root","root"));
        store.add(new User("root1","root1","root1"));
        store.add(new User("root2","root2","root2"));
        store.add(new User("root3","root3","root3"));
    }

    @Test
    public void whenAddUserThenStoreIt() throws ServletException, IOException {
        when(req.getParameter("submitAdd")).thenReturn("Makarov");
        store.add(new User(req.getParameter("submitAdd"),"root","root"));
        new UserServlet().doPost(req, resp);
        assertThat(((ValidateStub) store).getStore().get(0).getName(), is("Makarov"));
    }
    @Test
    public void whenEditeUserThenStoreIt() throws ServletException, IOException {
        initStore();
        when(req.getParameter("subUpdate")).thenReturn("Makarov");
        store.update("0",req.getParameter("subUpdate"),req.getParameter("subUpdate"),req.getParameter("subUpdate"));
        new UserServlet().doPost(req, resp);
        assertThat(((ValidateStub) store).getStore().get(0).getName(), is("Makarov"));
        assertThat(((ValidateStub) store).getStore().get(0).getLogin(), is("Makarov"));
        assertThat(((ValidateStub) store).getStore().get(0).getEmail(), is("Makarov"));
    }
    @Test
    public void whenRemoveUserThenStoreIt() throws ServletException, IOException {
        initStore();
        when(req.getParameter("sub")).thenReturn("0");
        new UserServlet().doPost(req, resp);
        store.delete(req.getParameter("sub"));
    }

}
