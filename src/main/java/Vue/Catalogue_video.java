package Vue;

import Controleur.ListageVideos;
import Modele.Video;

import javax.swing.*;
import java.util.List;

public class Catalogue_video extends JFrame{
    private JPanel mainpanel;
    private JTabbedPane tab;
    private JTextField searchbar;

    private JList<Video> list_rec;
    private JButton searchbutton;
    private JPanel panel2;
    private JLabel titre2;
    private JPanel panel1;
    private JLabel cat1;
    private JLabel cat2;
    private JList<Video> list1;
    private JList<Video> list2;
    private JList<Video> list3;
    private JList<Video> list4;
    private JList<Video> list5;
    private JList<Video> list6;
    private JLabel cat3;
    private JLabel cat4;

    private JLabel cat5;
    private JLabel cat6;

    public Catalogue_video(){
        setLayout(null);
        setContentPane(mainpanel);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("cat");
        setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        // Liste de liste de video par categorie;
        ListageVideos listageVideos=new ListageVideos();
        List<List<Video>> liste_cat=listageVideos.Liste_cat();

        // Liste par categorie :

        // Liste 1 filme Drame (catégorie 3)
        DefaultListModel<Video> model1 = new DefaultListModel<>();
        List<Video> vidlist1=liste_cat.get(2);
        for(Video value: vidlist1){
            model1.addElement(value);
        }
        list1=new JList<>(model1);
        list1.setCellRenderer(new VideoRenderer());
        list1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list1.setVisibleRowCount(1);

        //Liste 2 film Comedie (categorie 2)

        DefaultListModel<Video> model2 = new DefaultListModel<>();

        List<Video> vidlist2=liste_cat.get(1);
        for(Video value: vidlist2){
            model2.addElement(value);
        }
        list2=new JList<>(model2);
        list2.setCellRenderer(new VideoRenderer());
        list2.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list2.setVisibleRowCount(1);

        //Liste 3 film Fiction (categorie 4)

        DefaultListModel<Video> model3 = new DefaultListModel<>();

        List<Video> vidlist3=liste_cat.get(3);
        for(Video value: vidlist3){
            model3.addElement(value);
        }
        list3=new JList<>(model3);
        list3.setCellRenderer(new VideoRenderer());
        list3.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list3.setVisibleRowCount(1);

        //Liste 4 film Fiction (categorie 4)

        DefaultListModel<Video> model4 = new DefaultListModel<>();

        List<Video> vidlist4=liste_cat.get(4);
        for(Video value: vidlist4){
            model4.addElement(value);
        }
        list4=new JList<>(model4);
        list4.setCellRenderer(new VideoRenderer());
        list4.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list4.setVisibleRowCount(1);

        //Liste 5 film Fiction (categorie 5)

        DefaultListModel<Video> model5 = new DefaultListModel<>();

        List<Video> vidlist5=liste_cat.get(5);
        for(Video value: vidlist5){
            model5.addElement(value);
        }
        list5=new JList<>(model5);
        list5.setCellRenderer(new VideoRenderer());
        list5.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list5.setVisibleRowCount(1);

        //Liste 6 film Fiction (categorie 6)

        DefaultListModel<Video> model6 = new DefaultListModel<>();

        List<Video> vidlist6=liste_cat.get(0);
        for(Video value: vidlist6){
            model6.addElement(value);
        }
        list6=new JList<>(model6);
        list6.setCellRenderer(new VideoRenderer());
        list6.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list6.setVisibleRowCount(1);
    }

    public static void main(String[] args) {
        Catalogue_video c=new Catalogue_video();
    }
}
