package Vue;

import Controleur.Login;
import Modele.Client;
import Modele.Direction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Connection_form extends JFrame{
    private JPanel Connection;
    private JLabel titre;
    private JTextField temail;
    private JPasswordField tmdp;
    private JButton button;
    private JButton cancel;
    private JLabel mdp;
    private JLabel email;
    private JCheckBox checkadmin;
    private JLabel validation;

    public Connection_form(){
        setLayout(null);
        setContentPane(Connection);
        //setSize(600,300);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
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
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Client client=new Client();
                Direction direction= new Direction();
                direction.setEmail_ad(temail.getText());
                direction.setMdp_ad(String.valueOf(tmdp.getPassword()));
                client.setEmail(temail.getText());
                client.setMdp(String.valueOf(tmdp.getPassword()));
                Login log= new Login();
                if(checkadmin.isSelected()){
                    if(log.SignDirection(direction)){
                        validation.setText("Bienvenue admin !");
                    }
                    else{
                        validation.setText("Veuillez indiquer un mot de passe correct");
                    }
                }
                else {
                    if (!String.valueOf(tmdp.getPassword()).equals("") && !temail.getText().equals("")) {
                        if (log.signIn(client)) {
                            validation.setText("Connection établie !");
                            dispose();
                            new Interface_client(client);
                        } else {
                            validation.setText("Email ou Mot de Passe incorrect");
                        }
                    } else {
                        validation.setText("Veuillez remplir toutes les informations");
                    }
                }

                }

        });
    }

    public static void main(String[] args) {
        Connection_form connectionForm=new Connection_form();
    }

}
