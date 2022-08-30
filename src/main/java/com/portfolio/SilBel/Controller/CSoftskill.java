package com.portfolio.SilBel.Controller;

import com.portfolio.SilBel.Dto.dtoSoftskill;
import com.portfolio.SilBel.Entity.Softskill;
import com.portfolio.SilBel.Security.Controller.Mensaje;
import com.portfolio.SilBel.Service.SSoftskill;
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
@RequestMapping("/softskill")
@CrossOrigin(origins = "http://localhost:4200")
public class CSoftskill {
    @Autowired
    SSoftskill sSoftskill;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Softskill>> list() {
        List<Softskill> list = sSoftskill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Softskill> getById(@PathVariable("id") int id){
        if(!sSoftskill.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Softskill softskill = sSoftskill.getOne(id).get();
        return new ResponseEntity(softskill, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSoftskill dtosoftskill) {
        
        if (StringUtils.isBlank(dtosoftskill.getNombreHab())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (sSoftskill.existsByNombreHab(dtosoftskill.getNombreHab()))
            return new ResponseEntity(new Mensaje("Ya existe esa skill"), HttpStatus.BAD_REQUEST);
        
        //Si pasa las validaciones anteriores, crea el objeto Proyecto
        Softskill softskill = new Softskill(dtosoftskill.getNombreHab(), dtosoftskill.getIconHab());
        sSoftskill.save(softskill);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSoftskill dtosoftskill) {
      // Existe el ID?
        if (!sSoftskill.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
      
        // Compara nombre de experiencia nueva con antiguas, si existen, da error
        if(sSoftskill.existsByNombreHab(dtosoftskill.getNombreHab()) && sSoftskill.getByNombreHab(dtosoftskill.getNombreHab()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        
        //No puede estar en blanco nombre experiencia
        if(StringUtils.isBlank(dtosoftskill.getNombreHab()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        
        Softskill softskill = sSoftskill.getOne(id).get();
        softskill.setNombreHab(dtosoftskill.getNombreHab());
        softskill.setIconHab(dtosoftskill.getIconHab());
        
        sSoftskill.save(softskill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Existe el ID?
        if (!sSoftskill.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }
        sSoftskill.delete(id);
        
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    } 
}

