package com.portfolio.SilBel.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSkill {
    @NotBlank
    private String nombreHab;
    @NotBlank
    private String iconHab;
    @NotBlank
    private int nivelHab;
    @NotBlank
    private String etiquetaHab;

    public dtoSkill() {
    }
    
    public dtoSkill(String nombreHab, String iconHab, int nivelHab, String etiquetaHab) {
        this.nombreHab = nombreHab;
        this.iconHab = iconHab;
        this.nivelHab = nivelHab;
        this.etiquetaHab = etiquetaHab;
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
