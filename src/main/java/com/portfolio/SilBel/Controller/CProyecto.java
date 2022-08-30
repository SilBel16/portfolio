package com.portfolio.SilBel.Controller;

import com.portfolio.SilBel.Dto.dtoProyecto;
import com.portfolio.SilBel.Entity.Proyecto;
import com.portfolio.SilBel.Security.Controller.Mensaje;
import com.portfolio.SilBel.Service.SProyecto;
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
@RequestMapping("/proyecto")
@CrossOrigin(origins = "http://localhost:4200")
public class CProyecto {
 @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id){
        if(!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtopro) {
        
        if (StringUtils.isBlank(dtopro.getNombrePro())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (sProyecto.existsByNombrePro(dtopro.getNombrePro()))
            return new ResponseEntity(new Mensaje("Ya existe ese proyecto"), HttpStatus.BAD_REQUEST);
        
        //Si pasa las validaciones anteriores, crea el objeto Proyecto
        Proyecto proyecto = new Proyecto(dtopro.getUrlImgPro(), dtopro.getNombrePro(), dtopro.getDescripcionPro(), dtopro.getUrlPro());
        sProyecto.save(proyecto);
        
        return new ResponseEntity(new Mensaje("Educación agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtopro) {
      // Existe el ID?
        if (!sProyecto.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
      
        // Compara nombre de experiencia nueva con antiguas, si existen, da error
        if(sProyecto.existsByNombrePro(dtopro.getNombrePro()) && sProyecto.getByNombrePro(dtopro.getNombrePro()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Ese proyecto ya existe"), HttpStatus.BAD_REQUEST);
        
        //No puede estar en blanco nombre experiencia
        if(StringUtils.isBlank(dtopro.getNombrePro()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        
        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setUrlImgPro(dtopro.getUrlImgPro());
        proyecto.setNombrePro(dtopro.getNombrePro());
        proyecto.setDescripcionPro(dtopro.getDescripcionPro());
        proyecto.setUrlPro(dtopro.getUrlPro());
        
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Existe el ID?
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }
        sProyecto.delete(id);
        
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    } 
}

