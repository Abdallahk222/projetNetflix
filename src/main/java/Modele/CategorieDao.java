package Modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategorieDao extends MethodDao<Categorie>{
    @Override
    public void ajouter(Categorie obj) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(
                    "INSERT INTO categorie (nom_cat) " +
                            "VALUES(?)");
            preparedStatement.setString(1, obj.getNom_cat());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Categorie obj) {
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "UPDATE categorie SET nom_cat = ?" +
                            "WHERE id_cat = ?");
            preparedStatement.setString(1, obj.getNom_cat());
            preparedStatement.setLong(2, obj.getId_cat());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void supprimer(Categorie obj) {
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "DELETE FROM categorie WHERE id_cat = ?");
            preparedStatement.setLong(1,obj.getId_cat());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Categorie> lister() {
        List<Categorie> categorieList=new ArrayList<>();
        try {
            ResultSet resultSet=this.connection.createStatement().executeQuery("SELECT id_cat, nom_cat FROM categorie");

            while(resultSet.next()){
                Categorie categorie=new Categorie();
                categorie.setId_cat(resultSet.getLong("id_admin"));
                categorie.setNom_cat(resultSet.getString("email_ad"));

                categorieList.add(categorie);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return categorieList;
    }

    public void videocat(Video video, long idcat){
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(
                    "INSERT INTO appartient (id_video, id_cat) " +
                            "VALUES(?,?)");
            preparedStatement.setLong(1, video.getId_video());
            preparedStatement.setLong(2, idcat);

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
