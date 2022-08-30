package com.portfolio.SilBel.Security.Service;

import com.portfolio.SilBel.Security.Entity.Rol;
import com.portfolio.SilBel.Security.Enums.RolNombre;
import com.portfolio.SilBel.Security.Repository.iRolRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional /* Persistencia, si una operación falla, no impacta en la BD */
public class RolService {
    @Autowired
    iRolRepository irolRepository;
    
    public Optional<Rol> getByRolNombre(RolNombre rolNombre) {
        return irolRepository.findByRolNombre(rolNombre);
    }
    
    public void save(Rol rol) {
    irolRepository.save(rol);
    }
}
