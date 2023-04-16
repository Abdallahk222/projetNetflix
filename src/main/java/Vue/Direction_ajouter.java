package Vue;

import Modele.Video;
import Controleur.*;
import Modele.Direction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/** Classe correspondant à la Fenêtre d'ajout d'une vidéo par l'admin*/
public class Direction_ajouter extends JFrame{
    Video nv_video=new Video();
    private JPanel Ajout_video;
    private JLabel titrepage;
    private JTextField ttitre;
    private JTextField tlien;
    private JButton button;
    private JLabel validation;
    private JButton cancel;
    private JTextField timage;
    private JTextArea tresume;
    private JTextField tteaser;
    private JTextField tduree;
    private JTextField tannee;
    private JTextField tacteur;
    private JTextField treal;
    private JTextField tnote;
    private JComboBox choixcat;

    public Direction_ajouter(Direction direction){
        setLayout(null);
        setContentPane(Ajout_video);
        //setSize(1920,1080);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Direction");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Si le bouton validé est appuyé et les termes sont acceptés
                if(e.getSource() == button){


                        if(!ttitre.getText().equals("") && !tlien.getText().equals("") && !timage.getText().equals("") && !tresume.getText().equals("") && !tteaser.getText().equals("") && !tduree.getText().equals("") && !tannee.getText().equals("") && !tacteur.getText().equals("") && !treal.getText().equals("") && !tnote.getText().equals("")) {
                                nv_video = new Video(ttitre.getText(),tlien.getText(),timage.getText(), tresume.getText(),tteaser.getText(),tduree.getText(),tannee.getText(),tacteur.getText(),treal.getText(),Integer.parseInt(tnote.getText()));
                                Mise_a_jour maj = new Mise_a_jour();

                                long idcat=0;

                                if(choixcat.getSelectedItem().toString().equals("Drame-Comédie dramatique")){
                                    idcat=3;
                                }
                                if(choixcat.getSelectedItem().toString().equals("Comédie")){
                                    idcat=2;
                                }
                                if(choixcat.getSelectedItem().toString().equals("Fiction jeunesse")){
                                    idcat=4;
                                }
                                if(choixcat.getSelectedItem().toString().equals("Film musical")){
                                    idcat=5;
                                }
                                if(choixcat.getSelectedItem().toString().equals("Policier-espionnage")){
                                    idcat=6;
                                }
                                if(choixcat.getSelectedItem().toString().equals("Aventure-Guerre-Histoire-Action")){
                                    idcat=1;
                                }
                                maj.ajoutervideo(nv_video, direction, idcat);
                                validation.setText("Vidéo ajoutée !");

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
                Interface_direction interfaced = new Interface_direction(direction) ;
            }
        });
        setVisible(true);
    }

}
