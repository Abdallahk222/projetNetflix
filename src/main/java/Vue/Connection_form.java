package Vue;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Connection_form extends JFrame{
    private JPanel Connection;
    private JLabel titre;
    private JTextField temail;
    private JTextField tmdp;
    private JButton button;
    private JButton cancel;
    private JLabel mdp;
    private JLabel email;

    public Connection_form(){
        setLayout(null);
        setContentPane(Connection);
        setSize(600,300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connection");
        setVisible(true);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menu=new Menu();
            }
        });
    }

    public static void main(String[] args) {
        Connection_form connectionForm=new Connection_form();
    }

}
