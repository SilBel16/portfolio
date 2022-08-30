package com.portfolio.SilBel.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Redes {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String iconRed;
    private String nombreRed;
    private String urlRed;

    public Redes() {
    }

    public Redes(String iconRed, String nombreRed, String urlRed) {
        this.iconRed = iconRed;
        this.nombreRed = nombreRed;
        this.urlRed = urlRed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIconRed() {
        return iconRed;
    }

    public void setIconRed(String iconRed) {
        this.iconRed = iconRed;
    }

    public String getNombreRed() {
        return nombreRed;
    }

    public void setNombreRed(String nombreRed) {
        this.nombreRed = nombreRed;
    }

    public String getUrlRed() {
        return urlRed;
    }

    public void setUrlRed(String urlRed) {
        this.urlRed = urlRed;
    }

    
}