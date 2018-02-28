package sqltask.jdbc;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.File;
/**
 * Class for convert data from dataBase to XML file.
 * Convert processing regarding JAXB.
 */
public class Jaxb {
    /**
     * @param full - parameter describe list of nodes.
     * @param fuileWay - way for parsing file.
     */
    private FullList full;
    private String fileWay;

    public Jaxb(FullList full, String fileWay) {
        this.full = full;
        this.fileWay = fileWay;
    }

    public void startConvert(){
        try {
            // create Jaxb context and instantiate marshaller
            JAXBContext context = JAXBContext.newInstance(FullList.class);

            // (1) Marshaller : Java Object to XML content.
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            File outFile = new File(fileWay);
            m.marshal(full, outFile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
