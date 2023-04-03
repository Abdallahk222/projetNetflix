package Modele;

public class Categorie {
    private long id_cat;
    private String nom_cat;

    public Categorie(){}

    public Categorie(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    public long getId_cat() {
        return id_cat;
    }

    public void setId_cat(long id_cat) {
        this.id_cat = id_cat;
    }

    public String getNom_cat() {
        return nom_cat;
    }

    public void setNom_cat(String nom_cat) {
        this.nom_cat = nom_cat;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "id_cat=" + id_cat +
                ", nom_cat='" + nom_cat + '\'' +
                '}';
    }
}
