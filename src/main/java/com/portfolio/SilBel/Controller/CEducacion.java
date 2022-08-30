package com.portfolio.SilBel.Controller;

import com.portfolio.SilBel.Dto.dtoEducacion;
import com.portfolio.SilBel.Entity.Educacion;
import com.portfolio.SilBel.Security.Controller.Mensaje;
import com.portfolio.SilBel.Service.SEducacion;
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
@RequestMapping("/educacion")
@CrossOrigin(origins = "http://localhost:4200")
public class CEducacion {
    @Autowired
    SEducacion sEducacion;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Educacion>> list() {
        List<Educacion> list = sEducacion.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Educacion> getById(@PathVariable("id") int id){
        if(!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Educacion educacion = sEducacion.getOne(id).get();
        return new ResponseEntity(educacion, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoEducacion dtoedu) {
        
        if (StringUtils.isBlank(dtoedu.getNombreEdu())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (sEducacion.existsByNombreEdu(dtoedu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("Ya existe esa educacion"), HttpStatus.BAD_REQUEST);
        
        //Si pasa las validaciones anteriores, crea el objeto Experiencia
        Educacion educacion = new Educacion(dtoedu.getUrlImgEdu(), dtoedu.getNombreEdu(), dtoedu.getDescripcionEdu(), dtoedu.getInicioEdu(), dtoedu.getFinEdu(), dtoedu.getUrlEdu());
        sEducacion.save(educacion);
        
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoEducacion dtoedu) {
      // Existe el ID?
        if (!sEducacion.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
      
        // Compara nombre de experiencia nueva con antiguas, si existen, da error
        if(sEducacion.existsByNombreEdu(dtoedu.getNombreEdu()) && sEducacion.getByNombreEdu(dtoedu.getNombreEdu()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa educación ya existe"), HttpStatus.BAD_REQUEST);
        
        //No puede estar en blanco nombre experiencia
        if(StringUtils.isBlank(dtoedu.getNombreEdu()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        
        Educacion educacion = sEducacion.getOne(id).get();
        educacion.setUrlImgEdu(dtoedu.getUrlImgEdu());
        educacion.setNombreEdu(dtoedu.getNombreEdu());
        educacion.setDescripcionEdu(dtoedu.getDescripcionEdu());
        educacion.setInicioEdu(dtoedu.getInicioEdu());
        educacion.setFinEdu((dtoedu.getFinEdu()));
        educacion.setUrlEdu(dtoedu.getUrlEdu());
        
        sEducacion.save(educacion);
        return new ResponseEntity(new Mensaje("Educación actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Existe el ID?
        if (!sEducacion.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }
        sEducacion.delete(id);
        
        return new ResponseEntity(new Mensaje("Educación eliminada"), HttpStatus.OK);
    } 
}

