package Vue;

import Controleur.Mise_a_jour;
import Modele.Client;
import Modele.Direction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Client_modifier extends JFrame{
    private JPanel modifclient;
    private JLabel titre;
    private JTextField tnom;
    private JTextField temail;
    private JPasswordField tmdp1;
    private JButton valider;
    private JButton cancel;
    private JLabel validation;

    public Client_modifier(Client client, Direction direction){
        setLayout(null);
        setContentPane(modifclient);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Connection");
        setVisible(true);

        tnom.setText(client.getNom_client());
        temail.setText(client.getEmail());
        tmdp1.setText(client.getMdp());

        valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Si le bouton validé est appuyé et les termes sont acceptés
                if(e.getSource() == valider){


                    if(!tnom.getText().equals("") && !temail.getText().equals("") && !tmdp1.getText().equals("")) {

                        client.setNom_client(tnom.getText());
                        client.setEmail(temail.getText());
                        client.setMdp(String.valueOf(tmdp1.getPassword()));


                        Mise_a_jour maj = new Mise_a_jour();
                        maj.modifierclient(client);

                        validation.setText("Client modifié !");

                    }
                    else {
                        validation.setText("Veuillez remplir toutes les informations");
                    }

                }


            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Interface_direction(direction);

            }
        });
    }
}
