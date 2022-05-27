package src;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Gui implements ActionListener {
    JFrame jframe;
    JButton Yes;
    JButton No;
    JLabel question;
    JLabel askEmail;
    JTextField Email;
    JLabel askPW;
    JTextField Password;
    JButton Login;
    JButton CreateAccount;
    JButton continueWatchlistChoice;
    static User user;
    static Database db = new Database();
    JLabel AccountCreationMsg;
    JButton Back;
    JComboBox Options;
    JLabel StockQuestion;
    JMenu SysOptions;
    JMenuBar m1;
    JMenuItem LogOut;
    JLabel stockListLabel;
    JComboBox watchList; 
    JTextField stockOption;

    Gui() {
        jframe = new JFrame("Welcome!");
        jframe.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
        Yes = new JButton("Yes");
        No = new JButton("No");
        Yes.setBounds(30, 50, 80, 40);
        No.setBounds(150, 50, 80, 40);
        Yes.addActionListener(this);
        No.addActionListener(this);
        jframe.setSize(270, 150);
        jframe.setLayout(null);
        jframe.setVisible(true);
        question = new JLabel("Do you have an account with us?");
        question.setBounds(30, 20, 200, 20);
        jframe.add(question);
        jframe.add(Yes);
        jframe.add(No);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Yes) {
            jframe.getContentPane().removeAll();
            jframe.setTitle("Log In");
            jframe.setSize(500, 200);
            askEmail = new JLabel("Email:");
            askEmail.setBounds(30, 20, 200, 20);
            Email = new JTextField(20);
            Email.setBounds(65, 20, 226, 20);
            askPW = new JLabel("Password:");
            askPW.setBounds(30, 60, 200, 20);
            Password = new JTextField(20);
            Password.setBounds(90, 60, 200, 20);
            Login = new JButton("Log In");
            Login.setBounds(375, 130, 90, 20);
            Login.addActionListener(this);
            jframe.add(askPW);
            jframe.add(askEmail);
            jframe.add(Email);
            jframe.add(Password);
            jframe.add(Login);
            jframe.repaint();
        }
        if (e.getSource() == No) {
            jframe.getContentPane().removeAll();
            jframe.setSize(500, 200);
            jframe.setTitle("Create an Account");
            askEmail = new JLabel("Email:");
            askEmail.setBounds(30, 20, 200, 20);
            Email = new JTextField(20);
            Email.setBounds(65, 20, 226, 20);
            askPW = new JLabel("Password:");
            askPW.setBounds(30, 60, 200, 20);
            Password = new JTextField(20);
            Password.setBounds(90, 60, 200, 20);
            CreateAccount = new JButton("Create Account");
            CreateAccount.setBounds(330, 130, 140, 20);
            CreateAccount.addActionListener(this);
            jframe.add(askPW);
            jframe.add(askEmail);
            jframe.add(Email);
            jframe.add(Password);
            jframe.add(CreateAccount);
            jframe.repaint();
        }
        if (e.getSource() == CreateAccount) {
            // need to add check for duplicate accounts
            // user = new User(Email.getText(), Password.getText());
            // db.getUserlist().add(user);
            jframe.getContentPane().removeAll();
            jframe.setSize(300, 200);
            AccountCreationMsg = new JLabel("Account Successfully Created!");
            AccountCreationMsg.setBounds(59, 15, 200, 100);
            Back = new JButton("To Login");
            Back.setFont(new Font("", Font.TRUETYPE_FONT, 10));
            Back.setBounds(100, 90, 80, 20);
            Back.addActionListener(this);
            jframe.add(AccountCreationMsg);
            jframe.add(Back);
            jframe.repaint();
        }
        if (e.getSource() == Login) {
            // Check to see if login is valid
            jframe.getContentPane().removeAll();
            jframe.setVisible(false);
            SysOptions = new JMenu("Options");
            m1 = new JMenuBar();
            LogOut = new JMenuItem("Log Out");
            SysOptions.add(LogOut);
            m1.add(SysOptions);
            jframe.setJMenuBar(m1);
            LogOut.addActionListener(this);
            jframe.setTitle("Your Account");
            StockQuestion = new JLabel("What did you want to do?");
            StockQuestion.setBounds(20, 20, 170, 20);
            jframe.add(StockQuestion);
            String optionArr[] = { "Check a stock", "See your watchlist ", "See your portfolio ", "Edit your portfolio ", "Edit watchlist" };
            Options = new JComboBox(optionArr);
            Options.setBounds(20, 40, 150, 20);
            Options.setSelectedIndex(-1);
            Options.addActionListener(this);
            jframe.add(Options);
            jframe.repaint();
            jframe.setVisible(true);

        }
        if (e.getSource().equals(LogOut)) {
            jframe.getContentPane().removeAll();
            jframe.setJMenuBar(null);
            jframe.setVisible(false);
            jframe.setTitle("Log In");
            jframe.setSize(500, 200);
            askEmail = new JLabel("Email:");
            askEmail.setBounds(30, 20, 200, 20);
            Email = new JTextField(20);
            Email.setBounds(65, 20, 226, 20);
            askPW = new JLabel("Password:");
            askPW.setBounds(30, 60, 200, 20);
            Password = new JTextField(20);
            Password.setBounds(90, 60, 200, 20);
            Login = new JButton("Log In");
            Login.setBounds(375, 130, 90, 20);
            Login.addActionListener(this);
            jframe.add(askPW);
            jframe.add(askEmail);
            jframe.add(Email);
            jframe.add(Password);
            jframe.add(Login);
            jframe.repaint();
            jframe.setVisible(true);
        }
        if (e.getSource().equals(Options)) {
            if(Options.getSelectedIndex()==0){
                String options = new String("0 - price, 1 - volAvg, 2 - mktCap, 3 - range, 4 - ceo.  ");
                String options1 = new String("OR 5 - add stock to your Watchlist, 6 - add stock to your Portfolio.");
                boolean x = false;

                jframe.getContentPane().removeAll();
                System.out.println("Check Stock");
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
            if (Options.getSelectedIndex() == 1) {
                jframe.getContentPane().removeAll();
                jframe.setTitle("Your Watchlist");
                stockListLabel= new JLabel("Stock List:");
                stockListLabel.setBounds(20, 20, 170, 20);
                jframe.add(stockListLabel);
                jframe.repaint(); 
                System.out.println("See");
                // Needs to be added
            }
            if (Options.getSelectedIndex() == 2) {
                System.out.println("Edit");
                // Needs to be added
            }
        }

        if (e.getSource() == Back) {
            jframe.getContentPane().removeAll();
            jframe.setTitle("Log In");
            jframe.setSize(500, 200);
            askEmail = new JLabel("Email:");
            askEmail.setBounds(30, 20, 200, 20);
            Email = new JTextField(20);
            Email.setBounds(70, 20, 200, 20);
            askPW = new JLabel("Password:");
            askPW.setBounds(30, 60, 200, 20);
            Password = new JTextField(20);
            Password.setBounds(90, 60, 200, 20);
            Login = new JButton("Log In");
            Login.setBounds(375, 130, 90, 20);
            Login.addActionListener(this);
            jframe.add(askPW);
            jframe.add(askEmail);
            jframe.add(Email);
            jframe.add(Password);
            jframe.add(Login);
            jframe.repaint();
        }

    }

    public static void main(String[] args) {
        new Gui();
    }

}
