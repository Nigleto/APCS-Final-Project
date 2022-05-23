public class Firebase {
    public void initializeFirebase(){
        FileInputStream serviceAccount =
        new FileInputStream("/stock-apcs-firebase-adminsdk-v4r2v-14337a8dd7.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
        .setDatabaseUrl("https://stock-apcs-default-rtdb.firebaseio.com")
        .build();

        FirebaseApp.initializeApp(options);
        

    }
    
}
