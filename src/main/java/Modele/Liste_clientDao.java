package Modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** DAO pour la liste du client*/
public class Liste_clientDao extends MethodDao<Liste_client>{

    @Override
    public void ajouter(Liste_client obj) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(
                    "INSERT INTO liste_client (nom_list, description, id_client) " +
                            "VALUES(?, ?, ?)");
            preparedStatement.setString(1, obj.getNom_list());
            preparedStatement.setString(2, obj.getDescription());
            preparedStatement.setLong(3, obj.getId_client());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Liste_client obj) {
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "UPDATE liste_client SET nom_list = ?, description = ?, id_client = ?" +
                            "WHERE id_list = ?");
            preparedStatement.setString(1, obj.getNom_list());
            preparedStatement.setString(2, obj.getDescription());
            preparedStatement.setLong(3, obj.getId_client());
            preparedStatement.setLong(4, obj.getId_list());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void supprimer(Liste_client obj) {
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "DELETE FROM visionne WHERE id_list = ?");
            preparedStatement.setLong(1,obj.getId_list());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Liste_client> lister() {
        List<Liste_client> liste_clientList=new ArrayList<>();
        try {
            ResultSet resultSet=this.connection.createStatement().executeQuery("SELECT id_list, nom_list, description, id_client FROM liste_client");

            while(resultSet.next()){
                Liste_client liste_client=new Liste_client();
                liste_client.setId_list(resultSet.getLong("id_list"));
                liste_client.setNom_list(resultSet.getString("nom_list"));
                liste_client.setDescription(resultSet.getString("description"));
                liste_client.setId_client(resultSet.getLong("id_client"));

                liste_clientList.add(liste_client);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return liste_clientList;
    }

    /** Methode d'ajout d'élémént dans la table contient */

    public void contient(long id_list, long id_video){
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "INSERT INTO contient_liste (id_video, id_liste) " +
                            "VALUES(?, ?)");
            preparedStatement.setLong(1, id_video);
            preparedStatement.setLong(2, id_list);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    /** Methode de Listage de video contenue dans une liste personnalisée*/

    public List<Video> contient_listvideo(long id_list){
        List<Video> videoList=new ArrayList<>();
        try {
            ResultSet resultSet=this.connection.createStatement().executeQuery("SELECT v.id_video, titre, lien, img, resume, teaser," +
                    " duree, annee, acteur, realisateur, Note_j FROM video AS v JOIN contient_liste AS c ON c.id_video=v.id_video " +
                    "WHERE c.id_liste= "+id_list+";");

            while(resultSet.next()){
                Video video=new Video();
                video.setId_video(resultSet.getLong("v.id_video"));
                video.setTitre(resultSet.getString("titre"));
                video.setLien(resultSet.getString("lien"));
                video.setImg(resultSet.getString("img"));
                video.setResume(resultSet.getString("resume"));
                video.setTeaser(resultSet.getString("teaser"));
                video.setDuree(resultSet.getString("duree"));
                video.setAnnee(resultSet.getString("annee"));
                video.setActeur(resultSet.getString("acteur"));
                video.setRealisateur(resultSet.getString("realisateur"));
                video.setNote_j(resultSet.getInt("Note_j"));

                videoList.add(video);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return videoList;
    }
}
