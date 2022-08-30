package com.portfolio.SilBel.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String urlImgPro;
    private String nombrePro;
    private String descripcionPro;
    private String urlPro;

    public Proyecto() {
    }

    public Proyecto(String urlImgPro, String nombrePro, String descripcionPro, String urlPro) {
        this.urlImgPro = urlImgPro;
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
        this.urlPro = urlPro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImgPro() {
        return urlImgPro;
    }

    public void setUrlImgPro(String urlImgPro) {
        this.urlImgPro = urlImgPro;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public String getDescripcionPro() {
        return descripcionPro;
    }

    public void setDescripcionPro(String descripcionPro) {
        this.descripcionPro = descripcionPro;
    }

    public String getUrlPro() {
        return urlPro;
    }

    public void setUrlPro(String urlPro) {
        this.urlPro = urlPro;
    }

    
}
