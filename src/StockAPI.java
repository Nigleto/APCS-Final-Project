package src;
import java.net.URL;
import java.time.Year;
import java.util.Scanner;
import java.util.*;

public class StockAPI{
    static User user;

    public static void main(String[] args) {
        StockAPI api = new StockAPI();
        api.loop();
        
    }


    // FIX THIS SO THAT IT IS ABLE TO CHECK IF YOUR OPTION (PRICE, VOLAVG, ETC) IS CORRECT AND VALID!!
    public void start(){
        String options = new String("0 - price, 1 - volAvg, 2 - mktCap, 3 - range, 4 - ceo.  ");
        String options1 = new String("OR 5 - add stock to your Watchlist, 6 - add stock to your Portfolio.");
        Scanner scan = new Scanner(System.in);

        try {

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
                default:
                    System.out.println("Please enter a valid option. ");
                    
                    

            }

            

            //System.out.print(url);
        } catch (Exception e) {
            start();
        }
    }

    public void loop(){
        boolean start = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to start? | y/n");
        String play = scan.nextLine();

        if(play.equals("y")){
            start = true;
        }

        if(play.equals("n")){
            System.out.print("Thanks for using Nigel and Nick's Stock API!");
            return;
        }

        else if(!play.equals("y") && !play.equals("n")){
            System.out.println("Please enter either y or n. ");
            this.loop();
        } 
        
        while(start == true){
            user = login();
            this.start();
            System.out.println("Go again? | y/n");
            play = scan.nextLine();
            if(play.equals("y")){
                continue;
            }
            if(play.equals("n")){
                start = false;
                System.out.print("Thanks for using Nigel and Nick's Stock API");
            }
            else if(!play.equals("y") && !play.equals("n")){
                System.out.println("Please enter either y or n. ");
                this.loop();
            } 
        }

    }

    public static User login(){
        Scanner scan = new Scanner(System.in);
        User user = new User();

        System.out.println("Enter login info: ");
        System.out.println("email: ");
        String email = scan.nextLine();
        System.out.println("pass: ");
        String pass = scan.nextLine();
        
        user.setEmail(email);
        user.setPassword(pass);
        
        return user;
    }

}