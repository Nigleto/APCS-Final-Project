package src;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class StockEvent {
    private String key;
    private String value;
    private URL url;

    public StockEvent(String key, String value, URL url) throws Exception {
        this.url = url;
        this.key = key;
        if (value == null)
            this.value = findInputValue(key, url);
        else
            this.value = value;
    }

    public StockEvent(String key, URL url) throws Exception {
        this(key, null, url);
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String findInputValue(String option, URL url) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONArray array = (JSONArray) obj;
            JSONObject dict = (JSONObject) array.get(0);
            return this.key + ": " + dict.get(option).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}