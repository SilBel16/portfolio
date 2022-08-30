package com.portfolio.SilBel.Repository;

import com.portfolio.SilBel.Entity.Skill;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RSkill extends JpaRepository<Skill, Integer> {
    
    public Optional<Skill> findByNombreHab (String nombreHab);
    
    public boolean existsByNombreHab (String nombreHab);
    
} 


