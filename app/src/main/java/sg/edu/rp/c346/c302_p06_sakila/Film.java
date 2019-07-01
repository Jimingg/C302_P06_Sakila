package sg.edu.rp.c346.c302_p06_sakila;

import java.io.Serializable;

public class Film implements Serializable {
    private int id;
    private String title;
    private int year;
    private String rating;

    public Film(int id, String title, int year, String rating) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }


}
