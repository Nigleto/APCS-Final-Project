package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LoginGui implements ActionListener {
    JFrame jframe; 
    JButton Yes;
    JButton No;
    JLabel question; 
    JLabel askEmail;
    JTextField Email;
    JLabel askPW;
    JTextField Password; 
    JButton Submit; 
    static User user;
    static Database db = new Database();

    LoginGui() {
        jframe = new JFrame("Stock Login");
        Yes = new JButton("Yes");
        No = new JButton("No");
        Yes.setBounds(30,50,80,40);
        No.setBounds(150,50,80,40);
        Yes.addActionListener(this);
        No.addActionListener(this);
        jframe.setSize(300, 200 );
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
    if(e.getSource()== Yes){
        jframe.getContentPane().removeAll();
        jframe.setSize(500, 200);
        askEmail= new JLabel("Email:");
        askEmail.setBounds(30, 20, 200, 20);
        Email= new JTextField(20);
        Email.setBounds(70,20,200,20);
        askPW= new JLabel("Password:");
        askPW.setBounds(30, 60, 200, 20);
        Password = new JTextField(20);
        Password.setBounds(90, 60, 200, 20);
        Submit = new JButton("Submit"); 
        Submit.setBounds(375, 130, 90, 20);
        Submit.addActionListener(this);
        jframe.add(askPW); 
        jframe.add(askEmail);
        jframe.add(Email);
        jframe.add(Password); 
        jframe.add(Submit); 
        jframe.repaint();
    }
    if(e.getSource()==No){
    }
    if(e.getSource()==Submit){
        user = new User(Email.getText(), Password.getText());
        db.getUserlist().add(user);
        

    }
    
}

public static void main(String[] args) {
    new LoginGui();
}

}
