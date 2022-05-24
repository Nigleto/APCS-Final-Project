import javax.annotation.*;
import org.springframework.stereotype.Service;
import com.google.auth.oath2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

import com.example.demo.service;
import com.example.demo.objects.Person;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;



public class Firebase {

    
    public void initializeFirebase(){
        try{
            FileInputStream serviceAccount =
            new FileInputStream("/stock-apcs-firebase-adminsdk-v4r2v-14337a8dd7.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://stock-apcs-default-rtdb.firebaseio.com")
            .build();

            FirebaseApp.initializeApp(options); 
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public User saveUserData(Person Person){
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Users").document(person.getName().set(fields));
        return collectionsApiFuture.get().getUpdateTime().toString();
    }

    public User getUserDetails(String name){
        Firestore dbFirestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = dbFirestore.collection("users").document(name);
    }
    
}
