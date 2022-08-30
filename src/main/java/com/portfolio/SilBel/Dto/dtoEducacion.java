package com.portfolio.SilBel.Dto;

import javax.validation.constraints.NotBlank;

public class dtoEducacion {
    @NotBlank    
    private String urlImgEdu;
    @NotBlank    
    private String nombreEdu;
    @NotBlank
    private String descripcionEdu;
    @NotBlank
    private String inicioEdu;
    @NotBlank
    private String finEdu;
    @NotBlank    
    private String urlEdu;

    public dtoEducacion() {
    }

    public dtoEducacion(String urlImgEdu, String nombreEdu, String descripcionEdu, String inicioEdu, String finEdu, String urlEdu) {
        this.urlImgEdu = urlImgEdu;
        this.nombreEdu = nombreEdu;
        this.descripcionEdu = descripcionEdu;
        this.inicioEdu = inicioEdu;
        this.finEdu = finEdu;
        this.urlEdu = urlEdu;
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
