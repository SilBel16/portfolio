
package com.portfolio.SilBel.Controller;

import com.portfolio.SilBel.Dto.dtoRedes;
import com.portfolio.SilBel.Entity.Redes;
import com.portfolio.SilBel.Security.Controller.Mensaje;
import com.portfolio.SilBel.Service.SRedes;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redes")
@CrossOrigin(origins = "http://localhost:4200")
public class CRedes {
     @Autowired
    SRedes sRedes;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Redes>> list() {
        List<Redes> list = sRedes.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Redes> getById(@PathVariable("id") int id){
        if(!sRedes.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Redes redes = sRedes.getOne(id).get();
        return new ResponseEntity(redes, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoRedes dtoredes) {
        
        if (StringUtils.isBlank(dtoredes.getNombreRed())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (sRedes.existsByNombreRed(dtoredes.getNombreRed()))
            return new ResponseEntity(new Mensaje("Ya existe esa red"), HttpStatus.BAD_REQUEST);
        
        //Si pasa las validaciones anteriores, crea el objeto Proyecto
        Redes redes = new Redes( dtoredes.getIconRed(),dtoredes.getNombreRed(), dtoredes.getUrlRed());
        sRedes.save(redes);
        
        return new ResponseEntity(new Mensaje("Red agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoRedes dtoredes) {
      // Existe el ID?
        if (!sRedes.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
      
        // Compara nombre de experiencia nueva con antiguas, si existen, da error
        if(sRedes.existsByNombreRed(dtoredes.getNombreRed()) && sRedes.getByNombreRed(dtoredes.getNombreRed()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa red ya existe"), HttpStatus.BAD_REQUEST);
        
        //No puede estar en blanco nombre experiencia
        if(StringUtils.isBlank(dtoredes.getNombreRed()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        
        Redes redes = sRedes.getOne(id).get();
        redes.setIconRed(dtoredes.getIconRed());
        redes.setNombreRed(dtoredes.getNombreRed());
        redes.setUrlRed(dtoredes.getUrlRed());
        
        sRedes.save(redes);
        return new ResponseEntity(new Mensaje("Red actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Existe el ID?
        if (!sRedes.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }
        sRedes.delete(id);
        
        return new ResponseEntity(new Mensaje("Red eliminada"), HttpStatus.OK);
    } 
}


