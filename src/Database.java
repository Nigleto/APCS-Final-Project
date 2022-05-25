package src;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Database {
    public ArrayList<User> users;

    public void AddUser(User e){
        users.add(e);
        try {
            FileOutputStream file = new FileOutputStream("Database.json");
            ObjectOutputStream out = new ObjectOutputStream(file);
        }

    }
    //String wherearemypants = "/laundryroom/dryer/pants.java";
}

//ADD SERALIZATION AND DESERIALIZATION
