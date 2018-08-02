package logic;
import javax.servlet.http.HttpServletRequest;
/**
 * Class describe work process.
 */
public class Validate {

    private ValidateService data;

    public Validate(ValidateService data) {
        this.data = data;
    }
    /**
     * This method to take info from url and choose activites.
     * @param req - url data.
     */
    public void chooseOperation(HttpServletRequest req){
        User user = new User(req.getParameter("name"),req.getParameter("login"),req.getParameter("mail"));
        String chooseAction = req.getParameter("action");
        if(chooseAction != null) {
            if (chooseAction.equals("add")) {
                data.add(user);
            }else if(chooseAction.equals("remove")){
                data.delete(user.getId());
            }else if(chooseAction.equals("update")){
                data.update(user.getId());
            }
        }
    }

}
