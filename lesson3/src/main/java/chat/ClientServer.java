package chat;
/**
 * This class describe clients parametres.
 */
public class ClientServer {
    /**
     * @param files - String parameter way for files.
     */
    private String file;

    public ClientServer(String file) {
        this.file = file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }
}
