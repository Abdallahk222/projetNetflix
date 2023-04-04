package Modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VideoDao extends MethodDao<Video>{

    @Override
    public void ajouter(Video obj) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(
                    "INSERT INTO video (titre, lien, resume, teaser, duree, annee, acteur, realisateur, Note_j) " +
                            "VALUES(?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, obj.getTitre());
            preparedStatement.setString(2, obj.getLien());
            preparedStatement.setString(3, obj.getResume());
            preparedStatement.setString(4, obj.getTeaser());
            preparedStatement.setString(5, obj.getDuree());
            preparedStatement.setString(6, obj.getAnnee());
            preparedStatement.setString(7, obj.getActeur());
            preparedStatement.setString(8, obj.getRealisateur());
            preparedStatement.setInt(9, obj.getNote_j());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Video obj) {
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "UPDATE video SET titre = ?, lien = ?, resume = ?, teaser = ?, duree = ?, annee = ?, acteur = ?, realisateur = ?, Note_j = ?" +
                            "WHERE id_video = ?");
            preparedStatement.setString(1, obj.getTitre());
            preparedStatement.setString(2, obj.getLien());
            preparedStatement.setString(3, obj.getResume());
            preparedStatement.setString(4, obj.getTeaser());
            preparedStatement.setString(5, obj.getDuree());
            preparedStatement.setString(6, obj.getAnnee());
            preparedStatement.setString(7, obj.getActeur());
            preparedStatement.setString(8, obj.getRealisateur());
            preparedStatement.setInt(9, obj.getNote_j());
            preparedStatement.setLong(10, obj.getId_video());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void supprimer(Video obj) {
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "DELETE FROM video WHERE id_video = ?");
            preparedStatement.setLong(1,obj.getId_video());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Video> lister() {
        List<Video> videoList=new ArrayList<>();
        try {
            ResultSet resultSet=this.connection.createStatement().executeQuery("SELECT id_video, titre, lien, resume," +
                    " teaser, duree, annee, acteur, realisateur, Note_j FROM video");

            while(resultSet.next()){
                Video video=new Video();
                video.setId_video(resultSet.getLong("id_video"));
                video.setTitre(resultSet.getString("titre"));
                video.setLien(resultSet.getString("lien"));
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
    public void appartient(Video obj1, Categorie obj2){
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "INSERT INTO appartient (id_cat, id_video) " +
                            "VALUES(?, ?)");
            preparedStatement.setLong(1, obj2.getId_cat());
            preparedStatement.setLong(2, obj1.getId_video());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
