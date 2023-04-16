package Modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/** DAO pour Visionne*/
public class VisionneDao extends MethodDao<Visionne>{


    @Override
    public void ajouter(Visionne obj) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(
                    "INSERT INTO visionne (id_video, id_client, date_v, Pause, Note, Vue) " +
                            "VALUES(?, ?, ?, ?, ?, ?)");
            preparedStatement.setLong(1, obj.getId_video());
            preparedStatement.setLong(2, obj.getId_client());
            preparedStatement.setDate(3, obj.getDate_v());
            preparedStatement.setString(4, obj.getPause());
            preparedStatement.setInt(5, obj.getNote());
            preparedStatement.setInt(6, obj.getVue());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Visionne obj) {
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "UPDATE visionne SET date_v = ?, Pause = ?, Note = ?, Vue = ? WHERE (id_video = ? AND id_client = ?)");
            preparedStatement.setDate(1, obj.getDate_v());
            preparedStatement.setString(2, obj.getPause());
            preparedStatement.setInt(3, obj.getNote());
            preparedStatement.setInt(4, obj.getVue());
            preparedStatement.setLong(5, obj.getId_video());
            preparedStatement.setLong(6, obj.getId_client());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void supprimer(Visionne obj) {
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "DELETE FROM visionne WHERE id_video = ? AND id_client = ?");
            preparedStatement.setLong(1,obj.getId_video());
            preparedStatement.setLong(2,obj.getId_client());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Visionne> lister() {
        List<Visionne> visionneList=new ArrayList<>();
        try {
            ResultSet resultSet=this.connection.createStatement().executeQuery("SELECT id_video, id_client, date_v, Pause, Note, Vue FROM visionne");

            while(resultSet.next()){
                Visionne visionne=new Visionne();
                visionne.setId_video(resultSet.getLong("id_video"));
                visionne.setId_client(resultSet.getLong("id_client"));
                visionne.setDate_v(resultSet.getDate("date_v"));
                visionne.setPause(resultSet.getString("Pause"));
                visionne.setNote(resultSet.getInt("Note"));
                visionne.setVue(resultSet.getInt("Vue"));

                visionneList.add(visionne);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return visionneList;
    }

    /** Methode de Listage de Vidéo dans l'ordre décroissant de la date de Visionnage (Historique) */

    public List<Visionne> listh(long id_client){
        List<Visionne> visionneList=new ArrayList<>();
        try {
            ResultSet resultSet=this.connection.createStatement().executeQuery("SELECT id_video, id_client, date_v, Pause, Note, Vue FROM visionne ORDER BY date_v DESC SC WHERE id_client ="+id_client+";");

            while(resultSet.next()){
                Visionne visionne=new Visionne();
                visionne.setId_video(resultSet.getLong("id_video"));
                visionne.setId_client(resultSet.getLong("id_client"));
                visionne.setDate_v(resultSet.getDate("date_v"));
                visionne.setPause(resultSet.getString("Pause"));
                visionne.setNote(resultSet.getInt("Note"));
                visionne.setVue(resultSet.getInt("Vue"));

                visionneList.add(visionne);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return visionneList;
    }
}
