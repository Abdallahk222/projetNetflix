package Vue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JPanel Menu;
    private JLabel titre;
    private JButton connectionButton;
    private JButton inscriptionButton;

    public Menu(){
        setLayout(null);
        setContentPane(Menu);
        setSize(300,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setVisible(true);
        inscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Inscription_form inscriptionForm=new Inscription_form();
            }
        });
        connectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Connection_form connectionForm=new Connection_form();
            }
        });
    }

    public static void main(String[] args) {
        Menu menu=new Menu();
    }
}
