package Vue;

import Modele.Video;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;

public class VideoRenderer extends JPanel implements ListCellRenderer<Video> {
    private JLabel VidImg = new JLabel();
    private JLabel VidTitre = new JLabel();
    private JLabel VidAnnee = new JLabel();

    //private JButton VidButton = new JButton();


    public VideoRenderer() {
        setLayout(new BorderLayout(5, 5));
        JPanel panelText = new JPanel(new GridLayout(0, 1));
        panelText.add(VidTitre);
        panelText.add(VidAnnee);
        add(VidImg, BorderLayout.CENTER);
        add(panelText, BorderLayout.SOUTH);


    }


    @Override
    public Component getListCellRendererComponent(JList<? extends Video> list,
                                                  Video video, int index, boolean isSelected, boolean cellHasFocus) {

        VidImg.setIcon(new ImageIcon(getClass().getResource(
                "/image/" + video.getImg() + ".jpg")));
        VidTitre.setText(video.getTitre());
        VidAnnee.setText(video.getAnnee());

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
            //new Page_video(video);

        } else {
            VidTitre.setBackground(list.getBackground());
            VidAnnee.setBackground(list.getBackground());
            VidImg.setBackground(list.getBackground());
            setBackground(list.getBackground());
        }



        return this;
    }
}
