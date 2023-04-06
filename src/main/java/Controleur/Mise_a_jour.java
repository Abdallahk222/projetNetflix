package Controleur;
import Modele.*;

public class Mise_a_jour {

    // Methode ajout video de la direction
    public void ajoutervid(Direction obj1, Video obj2) {
        VideoDao videodao = new VideoDao();
        DirectionDao directiondao = new DirectionDao();
        videodao.ajouter(obj2);
        directiondao.maj(obj1, obj2);
    }

    public void ajouterlist(Liste_client obj) {
        Liste_clientDao listeClientDao = new Liste_clientDao();
        listeClientDao.ajouter(obj);
    }

    public void ajoutervidlist(Liste_client obj1, Video obj2){
        Liste_clientDao listeClientDao=new Liste_clientDao();
        VideoDao videoDao=new VideoDao();
        listeClientDao.contient(obj1, obj2);
    }

}
