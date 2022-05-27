package src;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SecondInput {
    SecondInput() {
        JFrame a = new JFrame("Stock Interface");
        JPanel p = new JPanel();
        p.setBounds(40, 70, 200, 200);
        JButton price = new JButton("Price");
        price.setBounds(60, 50, 80, 40);
        p.add(price);
        JButton volAvg = new JButton("VolAvg");
        price.setBounds(40, 50, 80, 40);
        p.add(price);
        p.add(volAvg); 


        a.add(p);
        a.setSize(400, 400);
        a.setLayout(null);
        a.setVisible(true);
    }
}