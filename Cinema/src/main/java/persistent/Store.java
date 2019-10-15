package persistent;
import logic.Halls;
import logic.User;

import java.util.List;

/**
 * Interface for work with DataBase.
 */
public interface Store {
     /**
      * Method for update status of place.
      * @param row -  horisantal position.
      * @param place - current place to update.
      */
     void updatePlace (String row,String place,String status);
     /**
      * Method for init first DataBase - cinema.
      * @param rows - value of rows.
      * @param places - value of places.
      */
     void initPlaces(int rows,int places,double price);
     /**
      * Method for add to data User.
      * @param user - which you want to add.
      */
     void addUser(User user, List<Integer> list);
     /**
      * Method for update balance of user.
      * @param user -  user which we want to update.
      * @param cost - price of ticket.
      */
     boolean checkTransactionUser(User user, Double cost);
     /**
      * This method calculate common size of data .
      * @return - size of data.
      */
     int sizeData();
     /**
      * This method select Hall by ID .
      * @return - value of Hall.
      */
     Halls selectByIDHalls(Integer id);
}
