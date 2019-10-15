package servlets;

import logic.Halls;
import logic.User;
import logic.ValidateService;
import org.junit.Test;
import persistent.DbStorePostgres;

import java.util.ArrayList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ServletAccountTest {
    private String text1 = "name=Rustymattok&phone=89165758909&list%5B%5D=30";
    private String text = "name=Rustymattok&phone=89165758909&list%5B%5D=31&list%5B%5D=32&list%5B%5D=159&list%5B%5D=160&list%5B%5D=161";
    private ServletAccount jsoAccount = new ServletAccount();
    DbStorePostgres store = DbStorePostgres.getINSTANCE();
    @Test
    public void parseAccount() {
        assertThat(jsoAccount.parseAccount(text,"name"),is("Rustymattok"));
        assertThat(jsoAccount.parseAccount(text,"phone"),is("89165758909"));
    }
}