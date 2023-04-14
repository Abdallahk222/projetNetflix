package Modele;

import java.sql.Date;

public class Visionne {
    private long id_video;
    private long id_client;
    private Date date_v;
    private String Pause="";
    private int Note;
    private int Vue=0;

    public Visionne(){}

    public Visionne(long id_video, long id_client, Date date_v) {
        this.id_video = id_video;
        this.id_client = id_client;
        this.date_v = date_v;
    }

    public long getId_video() {
        return id_video;
    }

    public void setId_video(long id_video) {
        this.id_video = id_video;
    }

    public long getId_client() {
        return id_client;
    }

    public void setId_client(long id_client) {
        this.id_client = id_client;
    }

    public Date getDate_v() {
        return date_v;
    }

    public void setDate_v(Date date_v) {
        this.date_v = date_v;
    }

    public String getPause() {
        return Pause;
    }

    public void setPause(String pause) {
        Pause = pause;
    }

    public int getNote() {
        return Note;
    }

    public void setNote(int note) {
        Note = note;
    }

    public int getVue() {
        return Vue;
    }

    public void setVue(int vue) {
        Vue = vue;
    }

    @Override
    public String toString() {
        return "Visionne{" +
                "id_video=" + id_video +
                ", id_client=" + id_client +
                ", date_v='" + date_v + '\'' +
                ", Pause='" + Pause + '\'' +
                ", Note=" + Note +
                ", Vue=" + Vue +
                '}';
    }
}
