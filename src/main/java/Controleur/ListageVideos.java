package Controleur;
import Modele.*;

import java.util.ArrayList;
import java.util.List;

/** Classe Listage de vidéos*/
public class ListageVideos {

    /** Liste de vidéo*/

    public List<Video> ListVideo(){
        VideoDao videodao = new VideoDao();
        List<Video> ListVideos = new ArrayList<>();
        ListVideos = videodao.lister();

        return ListVideos;
    }

    /** Liste de liste de vidéo par catégorie */

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

    /** Liste de vidéo dans l'historique */

    public List<Visionne> historique (long id_client){

        VisionneDao v = new VisionneDao();
       List<Visionne> list = v.listh(id_client);
       return list;
    }

    /** Fonction de recherche */
    public List<Video> recherche(String s){
        List<Video> list=this.ListVideo();
        List<Video> list_f=new ArrayList<>();
        for(Video value: list){
            if(value.getTitre().contains(s)){
                list_f.add(value);
            }
        }
        return list_f;
    }

    /** Fonction de recherche spécifique */

    public List<Video> recherche_sp(String s, String filtre){
        List<Video> list=this.ListVideo();
        List<Video> list_f=new ArrayList<>();
        for(Video value: list){
            if(filtre.equals("Titre")){
                if(value.getTitre().contains(s)){
                    list_f.add(value);
                }
            }
            if(filtre.equals("Acteur")){
                if(value.getActeur().contains(s)){
                    list_f.add(value);
                }
            }
            if(filtre.equals("Réalisateur")){
                if(value.getRealisateur().contains(s)){
                    list_f.add(value);
                }
            }
        }
        return list_f;
    }

    /** Filtre de popularité (ici 2 choix : note >5 -> i=0 ; note >8 -> i=1)*/
    public List<Video> filtre(List<Video> list,int i){
        List<Video> list_f=new ArrayList<>();
        if(i==0){
            for(Video value : list){
                if(value.getNote_j()>5) {
                    list_f.add(value);
                }
            }
        }
        if(i==1){
            for(Video value : list){
                if(value.getNote_j()>8) {
                    list_f.add(value);
                }
            }
        }
        return list_f;
    }
    /** Liste des films préférés de l'utilisateur*/

    public List<Video> film_pref(Client client){
        VisionneDao visionneDao=new VisionneDao();
        List<Visionne> visionneList=visionneDao.lister();

        VideoDao videoDao=new VideoDao();
        List<Video> videoList=videoDao.lister();

        // On cree une liste de videos à partir de la liste de visionnage

        List<Video> list_f=new ArrayList<>();

        for(Visionne value: visionneList){
            // On recherche chaque video dans la liste

            for(Video value1: videoList){
                if((value.getId_video()==value1.getId_video()) && (value.getId_client()==client.getId()) && (value.getNote()>7)){
                    list_f.add(value1);
                }
            }

        }
        return list_f;
    }

    /** Methode recherchant la liste correspondant au client*/
    public long id_list(Client client){
        Liste_clientDao listeClientDao=new Liste_clientDao();
        List<Liste_client> list=listeClientDao.lister();

        long id_list = 0;

        for(Liste_client value: list){
            if(value.getId_client()==client.getId()){
                id_list=value.getId_list();
            }
        }
        return id_list;
    }
    /** Liste des films de la liste personnalisée de l'utilisateur*/
    public List<Video> film_perso(Client client){
        Liste_clientDao listeClientDao=new Liste_clientDao();
        List<Video> listf;
        long id_list = id_list(client);

        listf=listeClientDao.contient_listvideo(id_list);

        return listf;
    }

}
