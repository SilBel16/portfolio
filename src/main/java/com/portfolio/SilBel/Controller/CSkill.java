package com.portfolio.SilBel.Controller;

import com.portfolio.SilBel.Dto.dtoSkill;
import com.portfolio.SilBel.Entity.Skill;
import com.portfolio.SilBel.Security.Controller.Mensaje;
import com.portfolio.SilBel.Service.SSkill;
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
@RequestMapping("/skill")
@CrossOrigin(origins = "http://localhost:4200")
public class CSkill {
   @Autowired
    SSkill sSkill;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Skill>> list() {
        List<Skill> list = sSkill.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Skill> getById(@PathVariable("id") int id){
        if(!sSkill.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Skill skill = sSkill.getOne(id).get();
        return new ResponseEntity(skill, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoSkill dtoskill) {
        
        if (StringUtils.isBlank(dtoskill.getNombreHab())) 
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        
        if (sSkill.existsByNombreHab(dtoskill.getNombreHab()))
            return new ResponseEntity(new Mensaje("Ya existe esa skill"), HttpStatus.BAD_REQUEST);
        
        //Si pasa las validaciones anteriores, crea el objeto Proyecto
        Skill skill = new Skill(dtoskill.getNombreHab(), dtoskill.getIconHab(), dtoskill.getNivelHab(), dtoskill.getEtiquetaHab());
        sSkill.save(skill);
        
        return new ResponseEntity(new Mensaje("Skill agregada"), HttpStatus.OK);
        
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoSkill dtoskill) {
      // Existe el ID?
        if (!sSkill.existsById(id))
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.NOT_FOUND);
      
        // Compara nombre de experiencia nueva con antiguas, si existen, da error
        if(sSkill.existsByNombreHab(dtoskill.getNombreHab()) && sSkill.getByNombreHab(dtoskill.getNombreHab()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa skill ya existe"), HttpStatus.BAD_REQUEST);
        
        //No puede estar en blanco nombre experiencia
        if(StringUtils.isBlank(dtoskill.getNombreHab()))
            return new ResponseEntity(new Mensaje("Nombre obligatorio"), HttpStatus.BAD_REQUEST);
        
        Skill skill = sSkill.getOne(id).get();
        skill.setNombreHab(dtoskill.getNombreHab());
        skill.setIconHab(dtoskill.getIconHab());
        skill.setNivelHab(dtoskill.getNivelHab());
        skill.setEtiquetaHab(dtoskill.getEtiquetaHab());
        
        sSkill.save(skill);
        return new ResponseEntity(new Mensaje("Skill actualizada"), HttpStatus.OK);
    }
    
    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        // Existe el ID?
        if (!sSkill.existsById(id)) {
            return new ResponseEntity(new Mensaje("El Id no existe"), HttpStatus.BAD_REQUEST);
        }
        sSkill.delete(id);
        
        return new ResponseEntity(new Mensaje("Skill eliminado"), HttpStatus.OK);
    } 
}

