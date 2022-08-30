package com.portfolio.SilBel.Repository;

import com.portfolio.SilBel.Entity.Softskill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSoftskill extends JpaRepository <Softskill, Integer> {
    
    public Optional<Softskill> findByNombreHab (String nombreHab);
    
    public boolean existsByNombreHab (String nombreHab);
    
} 

