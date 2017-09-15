package com.example.vindhya.proxynotes.Model;

/**
 * Created by VINDHYA on 15-Sep-17.
 */

public class ListItemModel {

    int thumb;
    String title;
    String discription;
    String url;
    String duration;

    public ListItemModel(int thumb, String title, String discription, String url, String duration) {
        this.thumb = thumb;
        this.title = title;
        this.discription = discription;
        this.url = url;

        this.duration = duration;
    }

    public int getThumb() {
        return thumb;
    }

    public void setThumb(int thumb) {
        this.thumb = thumb;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
