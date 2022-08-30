package com.portfolio.SilBel.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Softskill {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreHab;
    private String iconHab;

    public Softskill() {
    }

    public Softskill(String nombreHab, String iconHab) {
        this.nombreHab = nombreHab;
        this.iconHab = iconHab;
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
  
}
