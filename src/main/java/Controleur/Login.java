package Controleur;

import Modele.*;

public class Login {

    public void signUp(){
        MethodDao<Client> clientdao= new ClientDAO();
        Client client1 = new Client();
        clientdao.ajouter(client1);

    }
}
