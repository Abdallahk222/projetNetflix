package Controleur;

import Modele.Client;
import Modele.ClientDAO;

import java.util.ArrayList;
import java.util.List;

public class ListageClients {
    /** Liste de client */
    public List<Client> ListClients(){
        ClientDAO clientdao = new ClientDAO();
        List<Client> ListClients;
        ListClients = clientdao.lister();

        return ListClients;
    }
}
