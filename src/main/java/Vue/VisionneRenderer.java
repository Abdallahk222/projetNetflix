package Vue;

import Modele.Video;
import Modele.Visionne;

import javax.swing.*;
import java.awt.*;
/** Classe permettant la personnalisation des cellules des Listes de Vidéos (Historique) (non utilisée)*/
public class VisionneRenderer extends JPanel implements ListCellRenderer<Visionne> {

    private JLabel VidTitre = new JLabel();
    private JLabel VidDate = new JLabel();




    public VisionneRenderer() {
        setLayout(new BorderLayout(5, 5));
        JPanel panelText = new JPanel(new GridLayout(1, 2));
        panelText.add(VidTitre);
        panelText.add(VidDate);

    }

    /** Methode définissant chaque cellules des Listes de Vidéos (Historique)*/
    @Override
    public Component getListCellRendererComponent(JList<? extends Visionne> list,
                                                  Visionne visionne, int index, boolean isSelected, boolean cellHasFocus) {


        VidTitre.setText(String.valueOf(visionne.getId_video()));
        VidDate.setText(String.valueOf(visionne.getDate_v()));

        VidTitre.setHorizontalAlignment(JLabel.CENTER);
        VidDate.setHorizontalAlignment(JLabel.CENTER);


        VidTitre.setForeground(Color.red);
        VidDate.setForeground(Color.red);

        VidTitre.setOpaque(true);
        VidDate.setOpaque(true);


        if (isSelected) {
            VidTitre.setBackground(list.getSelectionBackground());
            VidDate.setBackground(list.getSelectionBackground());


        } else {
            VidTitre.setBackground(list.getBackground());
            VidDate.setBackground(list.getBackground());

        }



        return this;
    }
}

