package Modele;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends MethodDao<Client>{
    @Override
    public void ajouter(Client obj) {
        try {
            PreparedStatement preparedStatement = this.connection.prepareStatement(
                    "INSERT INTO client (nom_client, email, mdp, reprise, qualite, sous_titre) " +
                            "VALUES(?, ?, ?, ?, ?, ?)");
            preparedStatement.setString(1, obj.getNom_client());
            preparedStatement.setString(2, obj.getEmail());
            preparedStatement.setString(3, obj.getMdp());
            preparedStatement.setInt(4, obj.getReprise());
            preparedStatement.setInt(5, obj.getQualite());
            preparedStatement.setInt(6, obj.getSous_titre());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Client obj) {
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "UPDATE client SET nom_client = ?, email = ?, mdp = ?, reprise = ?, qualite = ?, sous_titre = ? WHERE id_client = ?");
            preparedStatement.setString(1, obj.getNom_client());
            preparedStatement.setString(2, obj.getEmail());
            preparedStatement.setString(3, obj.getMdp());
            preparedStatement.setInt(4, obj.getReprise());
            preparedStatement.setInt(5, obj.getQualite());
            preparedStatement.setInt(6, obj.getSous_titre());
            preparedStatement.setLong(7, obj.getId());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void supprimer(Client obj) {
        try{
            PreparedStatement preparedStatement=this.connection.prepareStatement(
                    "DELETE FROM client WHERE id_client = ?");
            preparedStatement.setLong(1,obj.getId());

            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<Client> lister(){
        List<Client> clientList=new ArrayList<>();
        try {
            ResultSet resultSet=this.connection.createStatement().executeQuery("SELECT id_client, nom_client, email, mdp, reprise, qualite, sous_titre FROM client");

            while(resultSet.next()){
                Client client=new Client();
                client.setId(resultSet.getLong("id_client"));
                client.setNom_client(resultSet.getString("nom_client"));
                client.setEmail(resultSet.getString("email"));
                client.setMdp(resultSet.getString("mdp"));
                client.setReprise(resultSet.getInt("reprise"));
                client.setQualite(resultSet.getInt("qualite"));
                client.setSous_titre(resultSet.getInt("sous_titre"));

                clientList.add(client);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    return clientList;
    }

}
