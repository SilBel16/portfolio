package com.portfolio.SilBel.Repository;

import com.portfolio.SilBel.Entity.Proyecto;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RProyecto extends JpaRepository<Proyecto, Integer> {
    
    public Optional<Proyecto> findByNombrePro (String nombrePro);
    
    public boolean existsByNombrePro (String nombrePro);
} 

