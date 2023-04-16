package Modele;

/** Classe administrateur*/
public class Direction {
    private long id_admin;
    private String email_ad;
    private String mdp_ad;
    public Direction(){};

    public Direction(String email_ad, String mdp_ad) {
        this.email_ad = email_ad;
        this.mdp_ad = mdp_ad;
    }

    public long getId_admin() {
        return id_admin;
    }

    public void setId_admin(long id_admin) {
        this.id_admin = id_admin;
    }

    public String getEmail_ad() {
        return email_ad;
    }

    public void setEmail_ad(String email_ad) {
        this.email_ad = email_ad;
    }

    public String getMdp_ad() {
        return mdp_ad;
    }

    public void setMdp_ad(String mdp_ad) {
        this.mdp_ad = mdp_ad;
    }

    @Override
    public String toString() {
        return "direction{" +
                "id_admin=" + id_admin +
                ", email_ad='" + email_ad + '\'' +
                ", mdp_ad='" + mdp_ad + '\'' +
                '}';
    }
}
