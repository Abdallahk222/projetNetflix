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

    public boolean SignDirection(Direction direction)
    {
        DirectionDao directiondao =  new DirectionDao();
        List<Direction> directionList;
        directionList = directiondao.lister();
        int i = 0;
        while(directionList.iterator().hasNext()){
           Direction direction1;
            direction1= directionList.get(i);
            if(direction1.getEmail_ad().equals(direction.getEmail_ad()) && direction1.getMdp_ad().equals(direction.getMdp_ad())){
                return true;
            }
            i++;
        }
        return false;
    }}
