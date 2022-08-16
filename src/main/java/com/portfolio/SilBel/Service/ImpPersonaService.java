package com.portfolio.SilBel.Service;

import com.portfolio.SilBel.Entity.Persona;
import com.portfolio.SilBel.Interface.IPersonaService;
import com.portfolio.SilBel.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImpPersonaService implements IPersonaService{

//traigo una dependencia (repositorio) acá para que lea los campos y pueda trabajar sobre esto. Permite inyectar dependencias dentro de otras.
    @Autowired IPersonaRepository iPersonaRepository;
    
    @Override
    public List<Persona> getPersona() {
    List<Persona> persona = iPersonaRepository.findAll();
    return persona;
    }

    @Override
    public void savePersona(Persona persona) {
    iPersonaRepository.save(persona);
    }

    @Override
    public void deletePersona(Long id) {
    iPersonaRepository.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
    Persona persona = iPersonaRepository.findById(id).orElse(null);
    return persona;
    }
    
}
