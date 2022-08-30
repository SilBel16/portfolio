package com.portfolio.SilBel.Controller;

import com.portfolio.SilBel.Entity.Persona;
import com.portfolio.SilBel.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {
    @Autowired IPersonaService iPersonaService;
    
    @GetMapping("/personas/traer")
    public List<Persona> getPersona() {
    return iPersonaService.getPersona();
    }
   
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("personas/crear")
    public String createPersona(@RequestBody Persona persona) {
        iPersonaService.savePersona(persona);
        return "Persona creada exitosamente";
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/personas/borrar/{id}")
    public String deletePersona(@PathVariable Long id) {
    iPersonaService.deletePersona(id);
    return "Persona eliminada exitosamente";
    }
    
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/personas/editar/{id}")
    public Persona editPersona(@PathVariable Long id,
                               @RequestParam("nombre") String nuevoNombre,
                               @RequestParam("apellido") String nuevoApellido,
                               @RequestParam("profileImg") String nuevoprofileImg,
                               @RequestParam("position") String nuevoposition,
                               @RequestParam("aboutMe") String nuevoaboutMe,
                               @RequestParam("cvFile") String nuevocvFile,    
                               @RequestParam("mail") String nuevoMail,
                               @RequestParam("phone") String nuevoPhone,
                               @RequestParam("city") String nuevoCity,
                               @RequestParam("country") String nuevoCountry) {  
                                                                               
    Persona persona = iPersonaService.findPersona(id);
    persona.setNombre(nuevoNombre);
    persona.setApellido(nuevoApellido);
    persona.setProfileImg(nuevoprofileImg);
    persona.setPosition(nuevoposition);
    persona.setAboutMe(nuevoaboutMe);
    persona.setCvFile(nuevocvFile);
    persona.setMail(nuevoMail);
    persona.setPhone(nuevoPhone);
    persona.setCity(nuevoCity);
    persona.setCountry(nuevoCountry);
    iPersonaService.savePersona(persona);
    return persona;
    }
    
    @GetMapping("/personas/traer/perfil")
    public Persona findPersona() {
        return iPersonaService.findPersona((long)1);
    }
}
