package com.example.mycustomapp.Models;

public class Repo {
    private int id;
    //campo del nomnre del respositorio
    private String name;
    //por si acaso guardaremos descripción del sitio como hicimos con la web
    private String description;

    //traemos diferentes getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
