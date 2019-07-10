package servlets;
import com.sun.deploy.net.socket.UnixSocketException;
import logic.User;
import logic.ValidateService;
import org.powermock.modules.junit4.PowerMockRunner;
import persistent.DbStore;
import persistent.ValidateStub;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(PowerMockRunner.class)
@PrepareForTest(ValidateService.class)
public class UserServletTest {
    @Test
    public void whenAddUserThenStoreIt() throws ServletException, IOException {
        //создаем альтернативную базу данных для теста, она наследована от Store и автомотически заполняется.
        ValidateStub validate = new ValidateStub();
        //так как заглушка ставится на место статического класса ValidationSevice вызываем к ней PowerMockito.
        PowerMockito.mockStatic(ValidateService.class);
        //Создаю щаглушку мок для класса ValidationService
        ValidateService mc  = Mockito.mock(ValidateService.class);
        //При запуске теста если вызывается логика заглушки, то подставляем в нее альтернативную логику базы данных.
        Mockito.when(mc.getLogic()).thenReturn(validate);
        //Настройки заглушек под сервлет, для имитации.
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        //Когда нажата клавиша в сервлете то автоматом возращается Макаров( это тест работоспособности ).
        when(req.getParameter("submitAdd")).thenReturn("Makarov");
        //обращаемся к сервлету с посдтавленными заглушками.
        new UserServlet().doPost(req, resp);
        //сама проверка условия. до конца не написана.
        assertThat(validate.getStore().get(0).getName(), is("Makarov"));
    }
    @Test
    public void whenEditeUserThenStoreIt() throws ServletException, IOException {
   }
    @Test
    public void whenRemoveUserThenStoreIt() throws ServletException, IOException {
    }

}
