package Controleur;
import Modele.*;

import java.util.ArrayList;
import java.util.List;

public class ListageVideos {


    public List<Video> ListVideo(){
        VideoDao videodao = new VideoDao();
        List<Video> ListVideos = new ArrayList<>();
        ListVideos = videodao.lister();

        return ListVideos;
    }

    // Liste de liste de vidéo par catégorie
    public List<List<Video>> Liste_cat(){
        VideoDao videodao = new VideoDao();
        List<List<Video>> list_cat=new ArrayList<>();
        for(int i=1;i<7;i++){
            List<Video> ListVids;
            ListVids = videodao.listcat(i);
            list_cat.add(ListVids);
        }

        return list_cat;
    }
}
