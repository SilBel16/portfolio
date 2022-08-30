
package com.portfolio.SilBel.Service;

import com.portfolio.SilBel.Entity.Redes;
import com.portfolio.SilBel.Repository.RRedes;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SRedes {
    @Autowired
    RRedes rRedes;
    
public List<Redes> list() {
    return rRedes.findAll(); 
    }

public Optional <Redes> getOne(int id){
    return rRedes.findById(id);
}

public Optional<Redes> getByNombreRed (String nombreRed) {
    return rRedes.findByNombreRed(nombreRed);
}

public void save (Redes redes) {
    rRedes.save(redes);
}

public void delete (int id) {
    rRedes.deleteById(id);
}

public boolean existsById (int id) {
    return rRedes.existsById(id);
}

public boolean existsByNombreRed (String nombreRed) {
    return rRedes.existsByNombreRed(nombreRed);
}

}


