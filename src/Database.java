package src;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import com.google.gson.Gson;

public class Database{
    public ArrayList<User> users;
    public Database(){
        this.users = new ArrayList<User>();
    }


    public ArrayList<User> getUserlist(){
        return this.users;  
    }

    public void Sererialize(){
        try{
            FileOutputStream file = new FileOutputStream("previousUserlist.txt");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.writeObject(this.users);

            out.close();
            file.close();

        }

        catch (IOException ex){
            ex.printStackTrace();
        }

    }
    //I might need to use this function in a for loop, going thru the arraylist of users stored.
    // ALSO IMPORTANT REMINDER! MAKE SURE TO DESERIALIZE BEFORE ADDING ANY OTHER USERS!!!!!!!!

    public void Deserialize(){
        try{
            FileInputStream file = new FileInputStream("previousUserlist.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            this.users = (ArrayList) in.readObject();

            in.close();
            file.close();

        }

        catch (IOException e){
            e.printStackTrace();
            return;
        }

        catch (ClassNotFoundException e){
            e.printStackTrace();
            return;
        }
        for(int i = 0; i < users.size(); i++){
            System.out.println(users.get(i));
        }

    }
}

//ADD SERALIZATION AND DESERIALIZATION
