package Modele;

public class Video {
    private long id_video=0;
    private String titre;
    private String lien;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private String img;
    private String resume;
    private String teaser;
    private String duree;
    private String annee;
    private String acteur;
    private String realisateur;
    private int Note_j;

    public Video(){}
    public Video(String titre, String lien, String resume, String teaser, String duree,
                 String annee, String acteur, String realisateur, int note_j) {
        this.titre = titre;
        this.lien = lien;
        this.resume = resume;
        this.teaser = teaser;
        this.duree = duree;
        this.annee = annee;
        this.acteur = acteur;
        this.realisateur = realisateur;
        Note_j = note_j;
    }

    public long getId_video() {
        return id_video;
    }

    public void setId_video(long id_video) {
        this.id_video = id_video;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getTeaser() {
        return teaser;
    }

    public void setTeaser(String teaser) {
        this.teaser = teaser;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getActeur() {
        return acteur;
    }

    public void setActeur(String acteur) {
        this.acteur = acteur;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public void setRealisateur(String realisateur) {
        this.realisateur = realisateur;
    }

    public int getNote_j() {
        return Note_j;
    }

    public void setNote_j(int note_j) {
        Note_j = note_j;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id_video=" + id_video +
                ", titre='" + titre + '\'' +
                ", lien='" + lien + '\'' +
                ", resume='" + resume + '\'' +
                ", teaser='" + teaser + '\'' +
                ", duree='" + duree + '\'' +
                ", annee='" + annee + '\'' +
                ", acteur='" + acteur + '\'' +
                ", realisateur='" + realisateur + '\'' +
                ", Note_j=" + Note_j +
                '}';
    }
}
