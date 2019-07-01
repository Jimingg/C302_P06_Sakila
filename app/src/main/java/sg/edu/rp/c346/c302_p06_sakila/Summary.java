package sg.edu.rp.c346.c302_p06_sakila;

import java.io.Serializable;

public class Summary implements Serializable {
    private String category ;
    private String number;

    public Summary(String category, String number) {
        this.category = category;
        this.number = number;
    }

    public String getCategory() {
        return category;
    }

    public String getNumber() {
        return number;
    }
}
