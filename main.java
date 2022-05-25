// import org.json.simple.JSONObject;
// import org.json.simple.JSONArray;
// import java.net.MalformedURLException;
// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.net.HttpURLConnection;
// import java.net.MalformedURLException;
// import java.net.URL;
// import java.util.Map;
// import java.util.Scanner;

import java.io.*;
import java.net.*;
import java.util.*;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;


public class main{
    private URL url;
    private String value;
    private String key;

    public static void main(String[] args) throws Exception{
        
        int splitter = 0;
        String key = "";
        String value = "";
        // API Key is : 9e32e1c117e9206264ef7c63453dca84
        URL url = new URL("https://financialmodelingprep.com/api/v3/profile/TSLA?apikey=9e32e1c117e9206264ef7c63453dca84");

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            for (String line; (line = reader.readLine()) != null;) {
                splitter = line.indexOf(":");
                key = line.substring(0, splitter);
                value = line.substring(splitter);
                StockEvent x = new StockEvent(key, value);
            
            System.out.println(line);
    }
}
    catch(Exception e){
        e.printStackTrace();
    }
}

}
    
}
