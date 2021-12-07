package hu.reginatoth.beadando.Model;

import java.io.Serializable;

public class todoModel implements Serializable {
    private int id;
    private  String desc;
    private String title;
    private String dueto;

    public todoModel(int id, String title,String desc, String dueto) {
        this.id = id;
        this.desc = desc;
        this.title = title;
        this.dueto = dueto;
    }

    public todoModel() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueto() {
        return dueto;
    }

    public void setDueto(String dueto) {
        this.dueto = dueto;
    }
}
