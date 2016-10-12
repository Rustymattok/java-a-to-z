package testtdd;

import TDD.Pair;
import TDD.SimpleGenerator;
import TDD.Template;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SimpleGeneratorTest {
    @Test
    public void whenShouldCheckValidate(){
        Pair pair1 = new Pair("name","Vladimir");
        Pair pair2 = new Pair("name1","Yhoo");
        Pair[] pairs = {pair1,pair2};
        Template template = new SimpleGenerator();
        String rezult = template.generate("Privet ${name} ,${name1}",pairs);
        assertThat(rezult, is("Privet Vladimir ,Yhoo"));
    }
}

