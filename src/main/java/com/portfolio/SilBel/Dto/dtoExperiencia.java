package com.portfolio.SilBel.Dto;

import javax.validation.constraints.NotBlank;

public class dtoExperiencia {
    @NotBlank    
    private String nombreE;
    @NotBlank
    private String descripcionE;
    @NotBlank
    private String inicioE;
    @NotBlank
    private String finE;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descripcionE, String inicioE, String finE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.inicioE = inicioE;
        this.finE = finE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getInicioE() {
        return inicioE;
    }

    public void setInicioE(String inicioE) {
        this.inicioE = inicioE;
    }

    public String getFinE() {
        return finE;
    }

    public void setFinE(String finE) {
        this.finE = finE;
    }
  
}
