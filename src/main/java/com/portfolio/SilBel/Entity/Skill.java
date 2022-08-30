package com.portfolio.SilBel.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHab;
    private String iconHab;
    private int nivelHab;
    private String etiquetaHab;

    public Skill() {
    }

    public Skill(String nombreHab, String iconHab, int nivelHab, String etiquetaHab) {
        this.nombreHab = nombreHab;
        this.iconHab = iconHab;
        this.nivelHab = nivelHab;
        this.etiquetaHab = etiquetaHab;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreHab() {
        return nombreHab;
    }

    public void setNombreHab(String nombreHab) {
        this.nombreHab = nombreHab;
    }

    public String getIconHab() {
        return iconHab;
    }

    public void setIconHab(String iconHab) {
        this.iconHab = iconHab;
    }

    public int getNivelHab() {
        return nivelHab;
    }

    public void setNivelHab(int nivelHab) {
        this.nivelHab = nivelHab;
    }

    public String getEtiquetaHab() {
        return etiquetaHab;
    }

    public void setEtiquetaHab(String etiquetaHab) {
        this.etiquetaHab = etiquetaHab;
    }
    
    
}
