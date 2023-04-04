package Controleur;
import Modele.*;

import java.util.ArrayList;
import java.util.List;

public class ListageVideos {


    public ListageVideos(){
        VideoDao video = new VideoDao();
        List<Video> ListVideos = new ArrayList<>();
        ListVideos = VideoDao.lister();


    }
}
