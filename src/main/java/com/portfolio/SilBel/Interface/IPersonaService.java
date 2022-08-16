package com.portfolio.SilBel.Interface;

import com.portfolio.SilBel.Entity.Persona;
import java.util.List;

public interface IPersonaService {
    
//Traer List de personas
    public List<Persona> getPersona();
    
//Guardar un objeto de tipo Persona
    public void savePersona(Persona persona);
    
//Eliminar un objeto por ID
    public void deletePersona(Long id);
    
//Buscar persona por ID
    public Persona findPersona(Long id);
}
