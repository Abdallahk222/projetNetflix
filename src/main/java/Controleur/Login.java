package Controleur;

import Modele.*;

import java.util.List;

public class Login {

    public void signUp(Client client){
        ClientDAO clientdao= new ClientDAO();
        clientdao.ajouter(client);
    }

    public boolean signIn(Client client){
        ClientDAO clientdao= new ClientDAO();
        List<Client> clientList;
        clientList=clientdao.lister();
        int i=0;
        while(clientList.iterator().hasNext()){
            Client client1;
            client1=clientList.get(i);
            if(client1.getEmail().equals(client.getEmail()) && client1.getMdp().equals(client.getMdp())){
                return true;
            }
            i++;
        }
        return false;
    }
}
