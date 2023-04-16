package Vue;

import Modele.Video;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/** Classe permettant la personnalisation des cellules des Listes de Vidéos */
public class VideoRenderer extends JPanel implements ListCellRenderer<Video> {
    private JLabel VidImg = new JLabel();
    private JLabel VidTitre = new JLabel();
    private JLabel VidAnnee = new JLabel();
    private JButton Vidbuton =new JButton("Voir plus");



    public VideoRenderer() {
        setLayout(new BorderLayout(5, 5));
        JPanel panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(VidTitre);
        panelText.add(VidAnnee);
        panelText.add(Vidbuton);
        add(VidImg, BorderLayout.CENTER);
        add(panelText, BorderLayout.SOUTH);
    }

    /** Methode définissant chaque cellules des Listes de Vidéos */
    @Override
    public Component getListCellRendererComponent(JList<? extends Video> list,
                                                  Video video, int index, boolean isSelected, boolean cellHasFocus) {

        VidImg.setIcon(new ImageIcon(getClass().getResource(
                "/image/" + video.getImg() + ".jpg")));
        VidTitre.setText(video.getTitre());
        VidAnnee.setText(video.getAnnee().substring(0,4));

        VidTitre.setHorizontalAlignment(JLabel.CENTER);
        VidAnnee.setHorizontalAlignment(JLabel.CENTER);
        VidImg.setHorizontalAlignment(JLabel.CENTER);

        VidTitre.setForeground(Color.red);
        VidAnnee.setForeground(Color.red);

        VidTitre.setOpaque(true);
        VidAnnee.setOpaque(true);
        VidImg.setOpaque(true);

        if (isSelected) {
            VidTitre.setBackground(list.getSelectionBackground());
            VidAnnee.setBackground(list.getSelectionBackground());
            VidImg.setBackground(list.getSelectionBackground());
            setBackground(list.getSelectionBackground());
        } else {
            VidTitre.setBackground(list.getBackground());
            VidAnnee.setBackground(list.getBackground());
            VidImg.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }

        return this;
    }
}
