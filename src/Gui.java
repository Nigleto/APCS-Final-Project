package src;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
            String optionArr[] = { "See your watchlist", "Edit your watchlist" };
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
            if (Options.getSelectedIndex() == 0) {
                jframe.getContentPane().removeAll();
                jframe.setTitle("Your Watchlist");
                stockListLabel= new JLabel("Stock List:");
                stockListLabel.setBounds(20, 20, 170, 20);
                jframe.add(stockListLabel);
                jframe.repaint(); 
                System.out.println("See");
                // Needs to be added
            }
            if (Options.getSelectedIndex() == 1) {
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
