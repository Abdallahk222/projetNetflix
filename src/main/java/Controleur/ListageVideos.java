package Controleur;
import Modele.*;

import java.util.ArrayList;
import java.util.List;

public class ListageVideos {


    public ListageVideos(){
        VideoDao videodao = new VideoDao();
        List<Video> ListVideos = new ArrayList<>();
        ListVideos = videodao.lister();


    }
}
