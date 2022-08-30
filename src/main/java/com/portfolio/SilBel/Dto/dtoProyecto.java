package com.portfolio.SilBel.Dto;

import javax.validation.constraints.NotBlank;

public class dtoProyecto {
    @NotBlank
    private String urlImgPro;
    @NotBlank
    private String nombrePro;
    @NotBlank
    private String descripcionPro;
    @NotBlank
    private String urlPro;

    public dtoProyecto() {
    }

    public dtoProyecto(String urlImgPro, String nombrePro, String descripcionPro, String urlPro) {
        this.urlImgPro = urlImgPro;
        this.nombrePro = nombrePro;
        this.descripcionPro = descripcionPro;
        this.urlPro = urlPro;
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
