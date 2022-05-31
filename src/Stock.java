package src;
import java.net.URL;

public class Stock{
    private String ticker;
    private URL url;


    public Stock(String ticker, URL url){
        this.ticker = ticker;
        this.url = url;
    }

    // public StockEvent getStockEvent(){
    //     return this.event;
    // }

    public URL getUrl(){
        return this.url;
    }

    @Override
    public String getTicker(){
        return this.ticker;
    }


}