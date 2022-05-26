package src;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.google.gson.Gson;

public class Database extends StockAPI{
    public ArrayList<User> users;

    public void AddUser(User e){
        users.add(e);
        

    }
    //String wherearemypants = "/laundryroom/dryer/pants.java";

    public void Sererialize(){

        try{
            FileOutputStream file = new FileOutputStream("Database.json");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject()
        }

        catch (IOException ex){

        }
    }
}

//ADD SERALIZATION AND DESERIALIZATION
