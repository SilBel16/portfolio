package com.portfolio.SilBel.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String urlImgEdu;
    private String nombreEdu;
    private String descripcionEdu;
    private String inicioEdu;
    private String finEdu;
    private String urlEdu;

    public Educacion() {
    }

    public Educacion(String urlImgEdu, String nombreEdu, String descripcionEdu, String inicioEdu, String finEdu, String urlEdu) {
        this.urlImgEdu = urlImgEdu;
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.inicioEdu = inicioEdu;
        this.finEdu = finEdu;
        this.urlEdu = urlEdu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlImgEdu() {
        return urlImgEdu;
    }

    public void setUrlImgEdu(String urlImgEdu) {
        this.urlImgEdu = urlImgEdu;
    }

    public String getNombreEdu() {
        return nombreEdu;
    }

    public void setNombreEdu(String nombreEdu) {
        this.nombreEdu = nombreEdu;
    }

    public String getDescripcionEdu() {
        return descripcionEdu;
    }

    public void setDescripcionEdu(String descripcionEdu) {
        this.descripcionEdu = descripcionEdu;
    }

    public String getInicioEdu() {
        return inicioEdu;
    }

    public void setInicioEdu(String inicioEdu) {
        this.inicioEdu = inicioEdu;
    }

    public String getFinEdu() {
        return finEdu;
    }

    public void setFinEdu(String finEdu) {
        this.finEdu = finEdu;
    }
    
    public String getUrlEdu() {
        return urlEdu;
    }

    public void setUrlEdu(String urlEdu) {
        this.urlEdu = urlEdu;
    }
    
}
