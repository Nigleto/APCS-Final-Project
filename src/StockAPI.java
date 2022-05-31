package src;
import java.net.URL;
import java.time.Year;
import java.util.Scanner;
import java.util.*;

public class StockAPI{
    static User user;
    static Database db = new Database();
    // I MIGHT HAVE TO CHANGE THIS!!!!

    public static void main(String[] args) {
        //db.Deserialize();
        new Gui(); 
        db.Deserialize();

        StockAPI api = new StockAPI();
        api.loop();
        db.Sererialize();
        
    }


    public void start(){
        String options = new String("0 - price, 1 - volAvg, 2 - mktCap, 3 - range, 4 - ceo.  ");
        String options1 = new String("OR 5 - add stock to your Watchlist, 6 - add stock to your Portfolio.");

        Scanner scan = new Scanner(System.in);
        boolean x = true;

        try {
            System.out.print("What stock would you like? ");
            String ticker = scan.nextLine();

            URL url = new URL("https://financialmodelingprep.com/api/v3/profile/" + ticker
                    + "?apikey=9e32e1c117e9206264ef7c63453dca84");

            System.out.println("What would you like to do with this stock? ");
            System.out.println("The options are: " + options + options1);
            String keyInput = scan.nextLine();

            while(x){
                switch(keyInput){
                    case "0":
                        StockEvent stockWithKey = new StockEvent("price", url);
                        System.out.println(stockWithKey.getValue());
                        x = false;
                        break;
                    case "1":
                        StockEvent stockWithKey1 = new StockEvent("volAvg", url);
                        System.out.println(stockWithKey1.getValue());
                        x = false;
                        break;
                    case "2":
                        StockEvent stockWithKey2 = new StockEvent("mktCap", url);
                        System.out.println(stockWithKey2.getValue());
                        x = false;
                        break;
                    case "3":
                        StockEvent stockWithKey3 = new StockEvent("range", url);
                        System.out.println(stockWithKey3.getValue());
                        x = false;
                        break;
                    case "4":
                        StockEvent stockWithKey4 = new StockEvent("ceo", url);
                        System.out.println(stockWithKey4.getValue());
                        x = false;
                        break;
                    case "5":
                        Stock stock = new Stock(ticker, url);
                        user.addWatchlistStock(stock);
                        System.out.println("Done");
                        System.out.println(user.getWatchlist().get(0));
                        x = false;
                        break;
                    case "6":
                        Stock stock1 = new Stock(ticker, url);
                        user.addWatchlistStock(stock1);
                        System.out.println("Done");
                        x = false;
                        break;
                    default:
                        System.out.println("Please enter a valid option. ");
                }
            }
        }

        catch (Exception e) {
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
            start = false;
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
                //start = false;
                System.out.print("Thanks for using Nigel and Nick's Stock API");
                break;
            }
            else if(!play.equals("y") && !play.equals("n")){
                System.out.println("Please enter either y or n. ");
                this.loop();
            } 
        }

    }

    public static User login(){
        Scanner scan = new Scanner(System.in);
        boolean x = true;
        String email = "";
        String pass = "";

        System.out.println("Do you already have an account with us? y/n");
        String haveAccount = scan.nextLine();

        while(x){
            if(haveAccount.equals("y")){
                System.out.println("Enter login info: ");
                System.out.println("Email: ");
                email += scan.nextLine();
                System.out.println("Pass: ");
                pass += scan.nextLine();
                x = false;
            }

            if(haveAccount.equals("n")){
                System.out.println("Please create an account! ");
    
                System.out.println("Email: ");
                email += scan.nextLine();
                System.out.println("Pass: ");
                pass += scan.nextLine();
                user = new User(email, pass);
                db.getUserlist().add(user);
                x = false;
            }

            if(!haveAccount.equals("y") && !haveAccount.equals("n")){
                System.out.println("Please enter either y or n. ");
            }
        }
        
        user = new User(email, pass);


        
        return user;
    }

}