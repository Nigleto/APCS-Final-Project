package src;
import java.net.URL;
import java.time.Year;
import java.util.Scanner;
import java.util.*;

public class StockAPI {

    public void start(){
        String options = new String("0 - price, 1 - volAvg, 2 - mktCap, 3 - range, 4 - ceo.  ");
        String options1 = new String("OR 5 - add stock to your Watchlist, 6 - add stock to your Portfolio.");
        Scanner scan = new Scanner(System.in);
        User user;

        try {

            user = login();

            System.out.print("What stock would you like? ");
            String ticker = scan.nextLine();

            URL url = new URL("https://financialmodelingprep.com/api/v3/profile/" + ticker
                    + "?apikey=9e32e1c117e9206264ef7c63453dca84");

            System.out.println("What would you like to do with this stock? ");
            System.out.println("The options are: " + options + options1);
            String keyInput = scan.nextLine();
            switch(keyInput){
                case "0":
                    StockEvent stockWithKey = new StockEvent("price", url);
                    System.out.println(stockWithKey.getValue());
                    break;
                case "1":
                    StockEvent stockWithKey1 = new StockEvent("volAvg", url);
                    System.out.println(stockWithKey1.getValue());
                    break;
                case "2":
                    StockEvent stockWithKey2 = new StockEvent("mktCap", url);
                    System.out.println(stockWithKey2.getValue());
                    break;
                case "3":
                    StockEvent stockWithKey3 = new StockEvent("range", url);
                    System.out.println(stockWithKey3.getValue());
                    break;
                case "4":
                    StockEvent stockWithKey4 = new StockEvent("ceo", url);
                    System.out.println(stockWithKey4.getValue());
                    break;
                case "5":
                    Stock stock = new Stock(ticker, url);
                    user.addWatchlistStock(stock);
                    System.out.println("Done");
                    System.out.println(user.getWatchlist().get(0));
                    break;
                case "6":
                    Stock stock1 = new Stock(ticker, url);
                    user.addWatchlistStock(stock1);
                    System.out.println("Done");
                    break;
                    

            }

            

            //System.out.print(url);
        } catch (Exception e) {
            start();
        }
    }


    public User login(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter login info: ");
        System.out.println("email: ");
        String email = scan.nextLine();
        System.out.println("pass: ");
        String pass = scan.nextLine();
        return new User(email, pass);
    }

    public void loop(){
        boolean start = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to start? | y/n");
        String play = scan.nextLine();

        if(play.equals("y")){
            start = true;
        }
        
        while(start == true){
            this.start();
            System.out.println("Go again? | y/n");
            play = scan.nextLine();
            if(play.equals("y")){
                continue;
            }
            else if(play.equals("n")){
                start = false;
                System.out.print("Thanks for using Nigel and Nick's Stock API");
            }
            else{
                System.out.print("Please enter either y or n")
                this.loop();
            }
        }

        else if(play.equals("n")){
            System.out.print("Thanks for using Nigel and Nick's Stock API!")
            break;
        }
        else{
            System.out.print("Please enter either y or n");
            this.loop;
        } 

    }

    public static void main(String[] args) {
        StockAPI api = new StockAPI();

        //
        try {
            FileOutputStream file = new FileOutputStream("Database.json");
            ObjectOutputStream out = new ObjectOutputStream(file);

            out.WriteObject(object);

            out.close();
            file.close();
            
        }


        User user = login();
        api.loop();
        
    }
}