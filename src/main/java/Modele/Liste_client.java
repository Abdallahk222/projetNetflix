package Modele;

/** La liste du client*/

public class Liste_client {
    private long id_list;
    private String nom_list;
    private String description;
    private long id_client;

    public Liste_client(){}

    public Liste_client(String nom_list, String description, long id_client) {
        this.nom_list = nom_list;
        this.description = description;
        this.id_client = id_client;
    }

    public long getId_list() {
        return id_list;
    }

    public void setId_list(long id_list) {
        this.id_list = id_list;
    }

    public String getNom_list() {
        return nom_list;
    }

    public void setNom_list(String nom_list) {
        this.nom_list = nom_list;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getId_client() {
        return id_client;
    }

    public void setId_client(long id_client) {
        this.id_client = id_client;
    }

    @Override
    public String toString() {
        return "Liste_client{" +
                "id_list=" + id_list +
                ", nom_list='" + nom_list + '\'' +
                ", description='" + description + '\'' +
                ", id_client=" + id_client +
                '}';
    }
}
