package sqltask.jdbc;
import org.junit.Test;
import javax.xml.transform.TransformerException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/**
 * Class for test xsl files.
 * This class test next elements:
 * -creation of new XML files regarding condition in XSL.
 * -XSL documents regarding conditions.
 */
public class XslTransformerTest {

    @Test
    public void whenShouldSheckParserXstl() throws InterruptedException, FileNotFoundException, TransformerException {
        XslTransformer xslTransformer = new XslTransformer();
        xslTransformer.process(new File(FilesWayForTest.fileXmlWay),new File(FilesWayForTest.fileXslWay),new FileOutputStream(new File(FilesWayForTest.fileParserWay)));
    }
}