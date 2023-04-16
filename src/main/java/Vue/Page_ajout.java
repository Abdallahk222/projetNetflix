package Vue;

import Controleur.ListageVideos;
import Controleur.Mise_a_jour;
import Modele.Client;
import Modele.Video;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

/** Classe correspondant à la Page d'ajout d'une vidéo dans une liste personnalisée d'un client */
public class Page_ajout extends JFrame {

    private JPanel mainpanel;
    private JList<Video> list_ajout;
    private JLabel titre_ajout;
    public long id_list;

    public Client client0;

    public Page_ajout(long id_list, Client client){
        this.id_list=id_list;
        this.client0=client;
        setLayout(null);

        setContentPane(mainpanel);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Page d'ajout");
        setVisible(true);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultListModel<Video> model_rec = new DefaultListModel<>();
        ListageVideos list=new ListageVideos();

        List<Video> vidlist_rec=list.recherche("");
        for(Video value: vidlist_rec){
            model_rec.addElement(value);
        }
        list_ajout=new JList<>(model_rec);
        list_ajout.setCellRenderer(new VideoRenderer());
        list_ajout.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list_ajout.setVisibleRowCount(2);


        list_ajout.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {

                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    Video video= (Video) list.getModel().getElementAt(index);
                    Mise_a_jour maj=new Mise_a_jour();
                    maj.ajout_contientliste(id_list,video.getId_video());
                    dispose();
                    new Interface_client(client0);
                }
            }
        });
    }

}
