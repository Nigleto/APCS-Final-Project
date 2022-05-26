package src;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Database extends StockAPI{
    public ArrayList<User> users;

    public void AddUser(User e){
        users.add(e);
        

    }
    //String wherearemypants = "/laundryroom/dryer/pants.java";
}

//ADD SERALIZATION AND DESERIALIZATION
