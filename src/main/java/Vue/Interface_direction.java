package Vue;

import Controleur.ListageVideos;
import Modele.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Interface_direction extends JFrame {
    private JList<Video> list1;
    private JButton ajout;
    private JPanel mainpanel;


    public Interface_direction(Direction direction){

        setLayout(null);

        setContentPane(mainpanel);
        this.pack();
        this.setDefaultLookAndFeelDecorated(true);
        this.setExtendedState(this.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Interface Admin");
        setVisible(true);

        list1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {

                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    Video video= (Video) list.getModel().getElementAt(index);
                    new Direction_modifier(direction, video);
                    dispose();
                }
            }
        });


        ajout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Direction_ajouter(direction);
                dispose();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        DefaultListModel<Video> model1 = new DefaultListModel<>();
        ListageVideos list=new ListageVideos();

        List<Video> vidlist_rec=list.recherche("");
        for(Video value: vidlist_rec){
            model1.addElement(value);
        }
        list1=new JList<>(model1);
        list1.setCellRenderer(new VideoRenderer());
        list1.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list1.setVisibleRowCount(2);
    }

    public static void main(String[] args) {
        Direction direction = new Direction();
        direction.setId_admin(1);
        new Interface_direction(direction);
    }
}
