package Vue;

import javax.swing.*;
import Modele.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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

    public Page_video(Video video){
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
    }

    public static void main(String[] args) {
        VideoDao v = new VideoDao();
        List<Video> l = new ArrayList<>();
        l=v.lister();
        new Page_video(l.get(0));
    }
}
