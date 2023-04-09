package Vue;

import Controleur.ListageVideos;
import Modele.Client;
import Modele.Video;
import Modele.Visionne;

import javax.swing.*;
import java.util.List;

public class Historique extends JFrame {
    private JButton boutonh;
    private JLabel titrehisto;
    private JList<Visionne> listh;
    private JPanel mainpanel;
    public Client client;

    public Historique(Client client1){
        this.client = client1;
        setLayout(null);
        setContentPane(mainpanel);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Historique");
        setVisible(true);
    }

    private void createUIComponents() {

        // TODO: place custom component creation code here
        ListageVideos listageVideos = new ListageVideos();
        DefaultListModel<Visionne> model = new DefaultListModel<>();
        List<Visionne> listpav = listageVideos.historique(client.getId());

        for(Visionne value:  listpav){
            model.addElement(value);
        }
        listh=new JList<>(model);
        listh.setCellRenderer(new VisionneRenderer());
        listh.setLayoutOrientation(JList.VERTICAL_WRAP);


    }

    public static void main(String[] args) {
       // new Historique(3);
    }
}
