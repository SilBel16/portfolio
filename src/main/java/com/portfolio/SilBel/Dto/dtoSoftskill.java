package com.portfolio.SilBel.Dto;

import javax.validation.constraints.NotBlank;

public class dtoSoftskill {
     @NotBlank
    private String nombreHab;
    @NotBlank
    private String iconHab;

    public dtoSoftskill() {
    }

    public dtoSoftskill(String nombreHab, String iconHab) {
        this.nombreHab = nombreHab;
        this.iconHab = iconHab;
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
