package Modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DirectionDao extends MethodDao<Direction>{

    @Override
    public void ajouter(Direction obj) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(
                    "INSERT INTO direction (email_ad, mdp_ad) " +
                            "VALUES(?, ?)");
            preparedStatement.setString(1, obj.getEmail_ad());
            preparedStatement.setString(2, obj.getMdp_ad());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Direction obj) {
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "UPDATE client SET email_ad = ?, mdp_ad = ?" +
                            "WHERE id_admin = ?");
            preparedStatement.setString(1, obj.getEmail_ad());
            preparedStatement.setString(2, obj.getMdp_ad());
            preparedStatement.setLong(3, obj.getId_admin());


            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void supprimer(Direction obj) {
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "DELETE FROM direction WHERE id_admin = ?");
            preparedStatement.setLong(1,obj.getId_admin());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Direction> lister() {
        List<Direction> directionList=new ArrayList<>();
        try {
            ResultSet resultSet=this.connection.createStatement().executeQuery("SELECT id_admin, email_ad, mdp_ad FROM direction");

            while(resultSet.next()){
                Direction direction=new Direction();
                direction.setId_admin(resultSet.getLong("id_admin"));
                direction.setEmail_ad(resultSet.getString("email_ad"));
                direction.setMdp_ad(resultSet.getString("mdp_ad"));

                directionList.add(direction);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return directionList;
    }

    public void maj(Direction obj1, Video obj2){
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "INSERT INTO met_a_jour (id_admin, id_video, last_modif) " +
                    "VALUES(?, ?, ?)");
            preparedStatement.setLong(1, obj1.getId_admin());
            preparedStatement.setLong(2, obj2.getId_video());
            //preparedStatement.setString(3, LocalDate.now());//

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
