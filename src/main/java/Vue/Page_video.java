package Vue;

import Controleur.Mise_a_jour;
import Modele.Client;
import Modele.Video;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

/** Classe correspondant à la Fenêtre affichant les informations d'une vidéo au client */
public class Page_video extends JFrame {

    private JPanel Page_video;
    private JLabel titrevideo;
    private JPanel Page_video2;
    private JButton Teaser;
    private JButton Regarder;
    private JLabel Image;
    private JLabel Resume;
    private JLabel Duree;
    private JLabel Annee;
    private JLabel Acteur;
    private JLabel Realisateur;
    private JLabel Note;
    private JSpinner Note_c;
    private JButton button_note;
    private JLabel Note_client;
    private JButton retour;

    public Page_video(Video video, Client client){
        setLayout(null);
        setContentPane(Page_video);
        //setSize(1080,720);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu");
        titrevideo.setText(video.getTitre());
        Resume.setText(video.getResume());
        Resume.setLayout(new GridLayout(1, 3));
        Duree.setText(video.getDuree());
        Annee.setText(video.getAnnee());
        Acteur.setText(video.getActeur());
        Realisateur.setText(video.getRealisateur());
        Note.setText(String.valueOf(video.getNote_j()));
        Image.setIcon(new ImageIcon(getClass().getResource("/image/" + video.getImg() + ".jpg")));

        setVisible(true);


        Regarder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Desktop.getDesktop().browse(new URI(video.getLien()));
                    Mise_a_jour maj=new Mise_a_jour();
                    maj.ajoutvisionne(client,video);
                }
                catch(Exception o){
                    o.printStackTrace();
                }

            }
        });
        Teaser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Desktop.getDesktop().browse(new URI(video.getTeaser()));
                }
                catch(Exception o){
                    o.printStackTrace();
                }

            }
        });
        button_note.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mise_a_jour maj2=new Mise_a_jour();
                maj2.note_visionne(client,video, (Integer) Note_c.getValue());
            }
        });
        retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Interface_client(client);
            }
        });
    }

}
