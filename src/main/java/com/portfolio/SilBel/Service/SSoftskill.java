package com.portfolio.SilBel.Service;

import com.portfolio.SilBel.Entity.Softskill;
import com.portfolio.SilBel.Repository.RSoftskill;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SSoftskill {
     @Autowired
    RSoftskill rSoftskill;
    
public List<Softskill> list() {
    return rSoftskill.findAll(); 
    }

public Optional <Softskill> getOne(int id){
    return rSoftskill.findById(id);
}

public Optional<Softskill> getByNombreHab (String nombreHab) {
    return rSoftskill.findByNombreHab(nombreHab);
}

public void save (Softskill softskill) {
    rSoftskill.save(softskill);
}

public void delete (int id) {
    rSoftskill.deleteById(id);
}

public boolean existsById (int id) {
    return rSoftskill.existsById(id);
}

public boolean existsByNombreHab (String nombreHab) {
    return rSoftskill.existsByNombreHab(nombreHab);
}

}

