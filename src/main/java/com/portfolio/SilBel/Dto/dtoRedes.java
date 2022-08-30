
package com.portfolio.SilBel.Dto;

import javax.validation.constraints.NotBlank;


public class dtoRedes {
    @NotBlank
    private String iconRed;
    @NotBlank
    private String nombreRed;
    @NotBlank
    private String urlRed;

    public dtoRedes() {
    }

    public dtoRedes(String iconRed, String nombreRed, String urlRed) {
        this.iconRed = iconRed;
        this.nombreRed = nombreRed;
        this.urlRed = urlRed;
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