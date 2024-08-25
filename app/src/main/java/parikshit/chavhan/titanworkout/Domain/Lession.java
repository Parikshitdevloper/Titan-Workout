package parikshit.chavhan.titanworkout.Domain;

import java.io.Serializable;

public class Lession implements Serializable {
    private String titile;
    private String duration;
    private String link;
    private  String picPath;



    public Lession(String titile, String duration, String link, String picPath) {
        this.titile = titile;
        this.duration = duration;
        this.link = link;
        this.picPath = picPath;


    }

    public String getTitile() {
        return titile;
    }

    public void setTitile(String titile) {
        this.titile = titile;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
