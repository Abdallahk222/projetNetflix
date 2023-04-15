package Vue;

import Controleur.Mise_a_jour;
import Modele.Video;
import Modele.Direction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Direction_modifier extends JFrame {
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
    public Direction_modifier(Direction direction, Video video){
        setLayout(null);
        setContentPane(Ajout_video);
        //setSize(1920,1080);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Direction");
        ttitre.setText(video.getTitre());
        tlien.setText(video.getLien());
        timage.setText(video.getImg());
        tresume.setText(video.getResume());
        tteaser.setText(video.getTeaser());
        tduree.setText(video.getDuree());
        tannee.setText(video.getAnnee().substring(0,4));
        tacteur.setText(video.getActeur());
        treal.setText(video.getRealisateur());
        tnote.setText(String.valueOf(video.getNote_j()));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Si le bouton validé est appuyé et les termes sont acceptés
                if(e.getSource() == button){


                    if(!ttitre.getText().equals("") && !tlien.getText().equals("") && !timage.getText().equals("") && !tresume.getText().equals("") && !tteaser.getText().equals("") && !tduree.getText().equals("") && !tannee.getText().equals("") && !tacteur.getText().equals("") && !treal.getText().equals("") && !tnote.getText().equals("")) {

                        video.setTitre(ttitre.getText());
                        video.setLien(tlien.getText());
                        video.setImg(timage.getText());
                        video.setResume(tresume.getText());
                        video.setTeaser(tteaser.getText());
                        video.setDuree(tduree.getText());
                        video.setAnnee(tannee.getText());
                        video.setActeur(tacteur.getText());
                        video.setRealisateur(treal.getText());
                        video.setNote_j(Integer.parseInt(tnote.getText()));


                        Mise_a_jour maj = new Mise_a_jour();
                        maj.modifiervideo(video, direction);
                        validation.setText("Vidéo modifiée !");

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
                Interface_direction interfaced = new Interface_direction(direction);
            }
        });
        setVisible(true);
    }
    public static void main(String[] args) {

        Direction direction = new Direction();
        Video video = new Video();
        direction.setId_admin(1);
        Direction_modifier direction1 =new Direction_modifier (direction, video);
    }
}

