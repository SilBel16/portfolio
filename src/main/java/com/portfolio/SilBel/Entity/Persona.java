package com.portfolio.SilBel.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con longitud")
    private String nombre;
    
    @NotNull
    @Size(min = 1, max = 50, message = "No cumple con longitud")
    private String apellido;
    
    @Size(min = 1, max = 500, message = "No cumple con longitud")
    private String profileImg;
    
    @Size(min = 1, max = 500, message = "No cumple con longitud")
    private String position;
    
    @Size(min = 1, max = 500, message = "No cumple con longitud")
    private String aboutMe;
    
    @Size(min = 1, max = 50, message = "No cumple con longitud")
    private String mail;
    
    @Size(min = 1, max = 50, message = "No cumple con longitud")
    private String phone;

    @Size(min = 1, max = 50, message = "No cumple con longitud")
    private String city;
    
    @Size(min = 1, max = 50, message = "No cumple con longitud")
    private String country;
}   
