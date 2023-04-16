package Modele;

/** Classe client avec ses informations*/
public class Client {
    private long id=0;
    private String nom_client;
    private String email;
    private String mdp;
    private int reprise=1;
    private int qualite=1;
    private int sous_titre=0;

    public Client(){}
    public Client(String nom_client, String email, String mdp) {
        this.nom_client = nom_client;
        this.email = email;
        this.mdp = mdp;
    }

    public long getId() {
        return id;
    }

    public String getNom_client() {
        return nom_client;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public int getReprise() {
        return reprise;
    }

    public int getQualite() {
        return qualite;
    }

    public int getSous_titre() {
        return sous_titre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setReprise(int reprise) {
        this.reprise = reprise;
    }

    public void setQualite(int qualite) {
        this.qualite = qualite;
    }

    public void setSous_titre(int sous_titre) {
        this.sous_titre = sous_titre;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom_client='" + nom_client + '\'' +
                ", email='" + email + '\'' +
                ", mdp='" + mdp + '\'' +
                ", reprise=" + reprise +
                ", qualite=" + qualite +
                ", sous_titre=" + sous_titre +
                '}';
    }

}
