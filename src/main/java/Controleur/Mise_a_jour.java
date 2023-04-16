package Controleur;
import Modele.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mise_a_jour {

    /** Methode ajout de Video dans Visionne à savoir la video vue par le client */

    public void ajoutvisionne(Client obj1, Video obj2){
        Visionne visionne=new Visionne(obj2.getId_video(), obj1.getId(), Date.valueOf(LocalDate.now()));
        visionne.setVue(0);
        VisionneDao visionneDao=new VisionneDao();
        List<Visionne> visionneList=visionneDao.lister();

        // ajout si la vidéo n'a pas déjà été vu sinon update

        int a=0;
        for(Visionne value : visionneList){
            if(value.getId_client()==obj1.getId() && value.getId_video()==obj2.getId_video()){
                value.setDate_v(Date.valueOf(LocalDate.now()));
                visionneDao.update(value);
                a++;
            }
        }
        if(a==0){
            visionneDao.ajouter(visionne);
        }

    }

    /** Methode permettant au client d'attribuer une note*/

    public void note_visionne(Client obj1, Video obj2, int note_client){
        VisionneDao visionneDao=new VisionneDao();
        List<Visionne> visionneList=visionneDao.lister();

        Visionne vis=new Visionne();

        int a=0;
        for(Visionne value : visionneList){
            if(value.getId_client()==obj1.getId() && value.getId_video()==obj2.getId_video()){
                vis=value;
                a++;
            }
        }

        // Si le client n'a pas visualisé la video mais veut mettre une note, on part du principe qu'il a deja du la voir
        // On ajoute ainsi avant la video dans la BDD

        if(a==0){
            this.ajoutvisionne(obj1,obj2);
        }

        vis.setNote(note_client);
        vis.setVue(1);
        visionneDao.update(vis);
    }

    /** Ajout de video dans une liste*/
    public void ajout_contientliste(long id_list, long id_video){
        Liste_clientDao listeClientDao=new Liste_clientDao();
        listeClientDao.contient(id_list,id_video);
    }


    /** Methode d'ajout de video par l'admin */
    public void ajoutervideo (Video video, Direction direction, long idcat){
        VideoDao videodao= new VideoDao();
        DirectionDao directionDao = new DirectionDao();
        videodao.ajouter(video);
        CategorieDao cat = new CategorieDao();
        List<Video> l = videodao.lister();
        video.setId_video(l.get(l.size()-1).getId_video());
        cat.videocat(video,idcat);
        directionDao.maj(direction, video);
    }


    /** Methode de modification de vidéo par l'admin */
    public void modifiervideo(Video video, Direction direction){
        VideoDao videodao= new VideoDao();
        videodao.update(video);
        List<Video> l = videodao.lister();
        DirectionDao directionDao = new DirectionDao();
        directionDao.maj2(direction, video);
    }

    /** Methode de modification des informations clients par l'admin */
    public void modifierclient(Client client){
        ClientDAO clientdao= new ClientDAO();
        clientdao.update(client);
    }
}