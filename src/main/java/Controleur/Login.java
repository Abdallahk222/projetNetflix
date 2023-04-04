package Controleur;

import Modele.*;

public class Login {

    public void signUp(Client client1){
        MethodDao<Client> clientdao= new ClientDAO();
        clientdao.ajouter(client1);

    }
}
