package com.example.bt3_app.model;

public class Group {
    private int idgroup;
    private String name;

    public Group(int idgroup, String name) {
        this.idgroup = idgroup;
        this.name = name;
    }

    public int getIdgroup() {
        return idgroup;
    }

    public void setIdgroup(int idgroup) {
        this.idgroup = idgroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
