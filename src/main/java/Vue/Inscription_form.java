package Vue;

import Controleur.Login;
import Modele.Client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/** Classe correspondant à la Fenêtre d'inscription d'un client */
public class Inscription_form extends JFrame{
    Client nv_client=new Client();
    private JLabel titre;
    private JTextField tnom;
    private JTextField temail;
    private JPasswordField tmdp1;
    private JPasswordField tmdp2;
    private JCheckBox terms;
    private JButton button;
    private JLabel validation;
    private JPanel inscription_p;
    private JButton cancel;

    public Inscription_form(){
        setLayout(null);
        setContentPane(inscription_p);
        //setSize(1920,1080);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inscription");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Si le bouton validé est appuyé et les termes sont acceptés
                if(e.getSource() == button){

                    if(terms.isSelected()){

                        if(!tnom.getText().equals("") && !temail.getText().equals("")) {
                            if (String.valueOf(tmdp1.getPassword()).equals(String.valueOf(tmdp2.getPassword()))) {
                                nv_client = new Client(tnom.getText(), temail.getText(), String.valueOf(tmdp1.getPassword()));
                                Login log = new Login();
                                log.signUp(nv_client);
                                validation.setText("Inscription validée !");
                            }
                            else{
                                validation.setText("Veuillez indiquer un mot de passe correct");
                            }

                        }
                        else {
                            validation.setText("Veuillez remplir toutes les informations");
                        }

                    }
                    else{
                        validation.setText("Veuillez acceptez les conditions d'inscription");
                    }
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu menu=new Menu();
            }
        });
        setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
