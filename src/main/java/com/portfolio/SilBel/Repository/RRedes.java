
package com.portfolio.SilBel.Repository;

import com.portfolio.SilBel.Entity.Redes;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RRedes extends JpaRepository <Redes, Integer> {
    
    public Optional<Redes> findByNombreRed (String nombreRed);
    
    public boolean existsByNombreRed (String nombreRed);
    
} 
    
