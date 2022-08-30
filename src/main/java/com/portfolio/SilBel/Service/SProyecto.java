package com.portfolio.SilBel.Service;

import com.portfolio.SilBel.Entity.Proyecto;
import com.portfolio.SilBel.Repository.RProyecto;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SProyecto {
    @Autowired
    RProyecto rProyecto;
    
public List<Proyecto> list() {
    return rProyecto.findAll(); 
    }

public Optional <Proyecto> getOne(int id){
    return rProyecto.findById(id);
}

public Optional<Proyecto> getByNombrePro (String nombrePro) {
    return rProyecto.findByNombrePro(nombrePro);
}

public void save (Proyecto proyecto) {
    rProyecto.save(proyecto);
}

public void delete (int id) {
    rProyecto.deleteById(id);
}

public boolean existsById (int id) {
    return rProyecto.existsById(id);
}

public boolean existsByNombrePro (String nombrePro) {
    return rProyecto.existsByNombrePro(nombrePro);
}

}

